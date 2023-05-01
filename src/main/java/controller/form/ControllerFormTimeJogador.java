package controller.form;

import controller.Controller;
import controller.grid.ControllerGridJogador;
import controller.grid.ControllerGridTimeJogador;
import dao.DaoJogador;
import dao.DaoTimeJogador;
import javax.swing.JOptionPane;
import model.Jogador;
import model.TimeJogador;
import view.form.ViewFormTimeJogador;

/**
 *
 * @author ruang
 */
public class ControllerFormTimeJogador extends ControllerForm<Jogador, ViewFormTimeJogador, DaoTimeJogador> {

    private TimeJogador time;
    
    public ControllerFormTimeJogador(Controller caller, TimeJogador time) {
        super(caller, false);
        this.time = time;
        this.dao = this.getInstanceDao();
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
            Jogador modelFromTela = this.getView().getModelFromDadosTela();
            modelFromTela.setTime(this.time);

            this.setModel(modelFromTela);

            if (this.processaDados()) {
                this.getView().showTypedMessage("Informação", "Jogador relacionado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                
                if (this.getCaller() instanceof ControllerGridTimeJogador) {
                    ((ControllerGridTimeJogador) this.getCaller()).atualizaConsulta();
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
    protected void beanDadosTela() {
        this.loadDadosComboBox();
    }
    
    private void loadDadosComboBox() {
        (new DaoJogador()).getJogadoresSemTime().forEach((jogador) -> {
            this.getView().getComboBoxJogador().addItem((Jogador) jogador);
        });
    }
    
    @Override
    public boolean processaDados() {
        return this.getDao().update(this.getModel());
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected ViewFormTimeJogador getInstanceView() {
        return new ViewFormTimeJogador();
    }

    @Override
    protected DaoTimeJogador getInstanceDao(Class classe) {
        return new DaoTimeJogador(this.time);
    }

}
