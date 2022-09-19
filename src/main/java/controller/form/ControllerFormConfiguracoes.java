package controller.form;

import controller.Controller;
import dao.Dao;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Configuracao;
import util.ListaItem;
import view.form.ViewFormConfiguracoes;

/**
 *
 * @author ruang
 */
public class ControllerFormConfiguracoes extends ControllerForm<Configuracao, ViewFormConfiguracoes, Dao> {

    public ControllerFormConfiguracoes(Controller caller) {
        super(caller, false);
    }
    
    @Override
    protected ViewFormConfiguracoes getInstanceView() {
        return new ViewFormConfiguracoes();
    }

    @Override
    public boolean processaDados() {
        return this.getDao().update(this.getModel());
    }

    @Override
    public Configuracao getInstanceModel() {
        return new Configuracao();
    }

    @Override
    public void showView() {
        this.model = (Configuracao) this.getDao().get(this.getModel().getId());
        this.addActionListeners();
        super.showView();
    }
    
    private void addActionListeners() {
        addActionListenerBotaoGravar();
    }
    
    private void addActionListenerBotaoGravar() {
        this.getView().getBotaoGravar().addActionListener((e) -> {
            JComboBox<ListaItem> comboBoxTipoExperiencia = this.getView().getComboBoxTipoExperiencia();
            Integer tipoExperienciaSelecionado = (Integer) comboBoxTipoExperiencia.getItemAt(comboBoxTipoExperiencia.getSelectedIndex()).getCodigo();
            this.getModel().setTipoExperiencia(tipoExperienciaSelecionado);
            if (this.processaDados()) {
                this.getView().showTypedMessage("Sucesso", "Configurações salvas com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                this.getView().showTypedMessage("Erro", "Houve um erro ao tentar salvar as configurações. Contate o suporte", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
}
