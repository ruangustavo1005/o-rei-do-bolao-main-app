package controller.form;

import controller.Controller;
import controller.grid.ControllerGridJogador;
import dao.DaoJogador;
import dao.DaoTime;
import javax.swing.JOptionPane;
import model.Jogador;
import model.TimeJogador;
import view.form.ViewFormJogador;

/**
 *
 * @author ruang
 */
public class ControllerFormJogador extends ControllerForm<Jogador, ViewFormJogador, DaoJogador> {

    public ControllerFormJogador(Controller caller, boolean onlyVisualizacao) {
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
            Jogador modelFromTela = this.getView().getModelFromDadosTela();

            if (modelFromTela.getNumero() == 0) {
                this.getView().showTypedMessage("Atenção", "O número deve ser informado", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (modelFromTela.getNome().isEmpty()) {
                this.getView().showTypedMessage("Atenção", "O nome deve ser informado", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Jogador jogadorExistente = this.getDao().getByNumero(modelFromTela.getNumero());
            if (jogadorExistente != null && jogadorExistente.getId() != modelFromTela.getId()) {
                this.getView().showTypedMessage("Atenção", "O número informado já está em uso pelo jogador " + jogadorExistente.getNome(), JOptionPane.WARNING_MESSAGE);
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
                if (this.getCaller() instanceof ControllerGridJogador) {
                    ((ControllerGridJogador) this.getCaller()).atualizaConsulta();
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
        super.beanDadosTela();
        if (!this.getModel().isChavePreenchida()) {
            this.getView().getModel().setNumero(this.getDao().getSuggestNumero());
            this.getView().beanDados();
        }
    }
    
    private void loadDadosComboBox() {
        this.getView().getComboBoxTime().addItem(null);
        (new DaoTime()).getOrderedByNome().forEach((time) -> {
            this.getView().getComboBoxTime().addItem((TimeJogador) time);
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
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected ViewFormJogador getInstanceView() {
        return new ViewFormJogador();
    }

    @Override
    protected DaoJogador getInstanceDao(Class classe) {
        return new DaoJogador();
    }

}
