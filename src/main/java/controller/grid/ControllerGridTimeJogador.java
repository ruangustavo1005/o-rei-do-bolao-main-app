package controller.grid;

import controller.Controller;
import controller.form.ControllerFormJogador;
import controller.form.ControllerFormTimeJogador;
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
        this.view = this.getInstanceView();
        this.dao = this.getInstanceDao(null);
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
        return new DaoTimeJogador(this.time);
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
            (new ControllerFormTimeJogador(this, this.time)).showView();
        });
    }

    private void addActionListenerBotaoRemoverJogador() {
        this.getView().getBotaoRemoverJogador().addActionListener((e) -> {
            int escolha = this.getView().showDialog("Atenção", "Deseja desvincular o(s) jogador(es) selecionado(s)?", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                boolean sucesso = true;
                Dao.disableTransactions();
                this.getDao().getEntityManager().getTransaction().begin();
                for (Jogador jogador : this.getSelectedModels()) {
                    jogador.setTime(null);
                    sucesso = this.getDao().update(jogador);
                    if (!sucesso) {
                        break;
                    }
                }

                if (sucesso) {
                    this.getDao().getEntityManager().getTransaction().commit();
                    this.getView().showTypedMessage("Informação", "Registro(s) desvinculado(s) com sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if (this.getDao().getEntityManager().getTransaction().isActive()) {
                        this.getDao().getEntityManager().getTransaction().rollback();
                    }
                    this.getView().showTypedMessage("Erro", "Houve um erro ao tentar excluir o(s) registro(s)", JOptionPane.ERROR_MESSAGE);
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
            this.getView().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ((ControllerGrid) getCaller()).atualizaConsulta();
                    super.windowClosing(e);
                }
            });
        }
    }
        
}
