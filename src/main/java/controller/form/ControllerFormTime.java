package controller.form;

import controller.Controller;
import controller.grid.ControllerGridTime;
import dao.DaoTime;
import javax.swing.JOptionPane;
import model.TimeJogador;
import view.form.ViewFormTime;

/**
 *
 * @author ruang
 */
public class ControllerFormTime extends ControllerForm<TimeJogador, ViewFormTime, DaoTime> {

    public ControllerFormTime(Controller caller, boolean onlyVisualizacao) {
        super(caller, onlyVisualizacao);
    }

    @Override
    public void showView() {
        this.addActionListeners();
        super.showView();
    }
    
    private void addActionListeners() {
        this.addActionListenerBotaoGravar();
        this.addActionListenerBotaoCancelar();
    }
    
    private void addActionListenerBotaoGravar() {
        this.getView().getBotaoGravar().addActionListener((e) -> {
            TimeJogador modelFromTela = this.getView().getModelFromDadosTela();

            if (modelFromTela.getNome().isEmpty()) {
                this.getView().showTypedMessage("Atenção", "O nome deve ser informado", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (modelFromTela.getCidadeOrigem().isEmpty()) {
                this.getView().showTypedMessage("Atenção", "a cidade de origem deve ser informado", JOptionPane.WARNING_MESSAGE);
                return;
            }

            this.setModel(modelFromTela);

            boolean isAlteracao = this.getModel().isChavePreenchida();
            
            if (this.processaDados()) {
                if (isAlteracao) {
                    this.getView().showTypedMessage("Informação", "Registro alterado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    this.getView().showTypedMessage("Informação", "Registro inserido com sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                if (this.getCaller() instanceof ControllerGridTime) {
                    ((ControllerGridTime) this.getCaller()).atualizaConsulta();
                }
                this.getView().dispose();
            }
        });
    }
    
    private void addActionListenerBotaoCancelar() {
        this.getView().getBotaoCancelar().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
    @Override
    public boolean processaDados() {
        if (this.getModel().isChavePreenchida()) {
            return this.getDao().update(this.getModel());
        }
        return this.getDao().add(this.getModel());
    }

    @Override
    protected TimeJogador getInstanceModel() {
        return new TimeJogador();
    }

    @Override
    protected ViewFormTime getInstanceView() {
        return new ViewFormTime();
    }

    @Override
    protected DaoTime getInstanceDao(Class classe) {
        return new DaoTime();
    }

}
