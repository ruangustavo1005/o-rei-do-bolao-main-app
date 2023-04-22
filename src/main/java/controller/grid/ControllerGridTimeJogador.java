package controller.grid;

import controller.Controller;
import controller.form.ControllerFormJogador;
import dao.Dao;
import dao.DaoTimeJogador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.Jogador;
import model.TimeJogador;
import view.grid.ViewGridTimeJogador;

/**
 *
 * @author ruan
 */
public class ControllerGridTimeJogador extends ControllerGrid<Jogador, ViewGridTimeJogador, DaoTimeJogador> {

    private TimeJogador time;
    
    public ControllerGridTimeJogador(Controller caller, TimeJogador time) throws Exception {
        super(caller);
        if (time == null) {
            throw new Exception("É necessário informar um time para acessar a consulta de jogadores do time");
        }
        this.time = time;
        this.getView().setTitle(this.getView().getTitle() + " do time " + time.getNome());
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected ViewGridTimeJogador getInstanceView() {
        return new ViewGridTimeJogador(this.time);
    }

    @Override
    protected DaoTimeJogador getInstanceDao(Class classe) {
        return new DaoTimeJogador(time);
    }
    
    @Override
    public void showView() {
        this.addActionListeners();
        this.addActionCallerRefresh();
        super.showView();
    }

    private void addActionListeners() {
        this.addActionListenerBotaoRelacionarJogador();
        this.addActionListenerBotaoRemoverJogador();
    }

    private void addActionListenerBotaoRelacionarJogador() {
        this.getView().getBotaoRelacionarJogador().addActionListener((e) -> {
            (new ControllerFormJogador(this, false)).showView();
        });
    }

    private void addActionListenerBotaoRemoverJogador() {
        this.getView().getBotaoRemoverJogador().addActionListener((e) -> {
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
    
    private void addActionCallerRefresh() {
        /**
         * @todo testar
         */
        if (this.getCaller() instanceof ControllerGrid) {
            ControllerGrid caller = (ControllerGrid) this.getCaller();
            this.getView().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    caller.atualizaConsulta();
                    super.windowClosing(e);
                }
            });
        }
    }
        
}
