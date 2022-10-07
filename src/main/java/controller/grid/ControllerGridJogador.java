package controller.grid;

import controller.Controller;
import controller.form.ControllerFormJogador;
import dao.Dao;
import javax.swing.JOptionPane;
import model.Jogador;
import view.grid.ViewGridJogador;

/**
 *
 * @author ruan
 */
public class ControllerGridJogador extends ControllerGrid<Jogador, ViewGridJogador, Dao> {

    public ControllerGridJogador(Controller caller) {
        super(caller);
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected ViewGridJogador getInstanceView() {
        return new ViewGridJogador();
    }

    @Override
    public void showView() {
        this.addActionListeners();
        super.showView();
    }

    private void addActionListeners() {
        this.addActionListenerBotaoInserir();
        this.addActionListenerBotaoAlterar();
        this.addActionListenerBotaoExcluir();
        this.addActionListenerBotaoVisualizar();
    }

    private void addActionListenerBotaoInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerFormJogador(this, false)).showView();
        });
    }

    private void addActionListenerBotaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerFormJogador(this, false)).setModel(this.getSelectedModel()).showView();
        });
    }

    private void addActionListenerBotaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            int escolha = this.getView().showDialog("Atenção", "Deseja excluir o(s) registro(s) selecionado(s)?", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                boolean sucesso = true;
                Dao.disableTransactions();
                this.getDao().getEntityManager().getTransaction().begin();
                for (Jogador jogador : this.getSelectedModels()) {
                    sucesso = this.getDao().remove(jogador);
                    if (!sucesso) {
                        break;
                    }
                }

                if (sucesso) {
                    this.getDao().getEntityManager().getTransaction().commit();
                    this.getView().showTypedMessage("Informação", "Registros excluídos com sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if (this.getDao().getEntityManager().getTransaction().isActive()) {
                        this.getDao().getEntityManager().getTransaction().rollback();
                    }
                    this.getView().showTypedMessage("Erro", "Houve um erro ao tentar excluir os registros", JOptionPane.ERROR_MESSAGE);
                }
                Dao.enableTransactions();
                this.atualizaConsulta();
            }
        });
    }

    private void addActionListenerBotaoVisualizar() {
        this.getView().getBotaoVisualizar().addActionListener((e) -> {
            (new ControllerFormJogador(this, true)).setModel(this.getSelectedModel()).showView();
        });
    }
    
}
