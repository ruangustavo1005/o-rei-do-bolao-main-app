package controller.grid;

import controller.Controller;
import controller.form.ControllerFormTime;
import dao.Dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.TimeJogador;
import view.grid.ViewGridTime;

/**
 *
 * @author ruan
 */
public class ControllerGridTime extends ControllerGrid<TimeJogador, ViewGridTime, Dao> {

    public ControllerGridTime(Controller caller) {
        super(caller);
    }

    @Override
    protected TimeJogador getInstanceModel() {
        return new TimeJogador();
    }

    @Override
    protected ViewGridTime getInstanceView() {
        return new ViewGridTime();
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
        this.addActionListenerBotaoGerenciarJogadores();
    }

    private void addActionListenerBotaoInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerFormTime(this, false)).showView();
        });
    }

    private void addActionListenerBotaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerFormTime(this, false)).setModel(this.getSelectedModel()).showView();
        });
    }

    private void addActionListenerBotaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            int escolha = this.getView().showDialog("Atenção", "Deseja excluir o(s) registro(s) selecionado(s)?", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                boolean sucesso = true;
                Dao.disableTransactions();
                this.getDao().getEntityManager().getTransaction().begin();
                for (TimeJogador Timejogador : this.getSelectedModels()) {
                    sucesso = this.getDao().remove(Timejogador);
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
            (new ControllerFormTime(this, true)).setModel(this.getSelectedModel()).showView();
        });
    }
    
    private void addActionListenerBotaoGerenciarJogadores() {
        this.getView().getBotaoGerenciarJogadores().addActionListener((e) -> {
            try {
                (new ControllerGridTimeJogador(this, this.getSelectedModel())).showView();
            } catch (Exception ex) {
                Logger.getLogger(ControllerGridTime.class.getName()).log(Level.SEVERE, null, ex);
                this.getView().showTypedMessage("Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
}
