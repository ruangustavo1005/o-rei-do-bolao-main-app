package controller.form;

import controller.Controller;
import dao.Dao;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Configuracao;
import util.ListaItem;
import util.NumberUtils;
import view.form.ViewFormConfiguracao;

/**
 *
 * @author ruang
 */
public class ControllerFormConfiguracao extends ControllerForm<Configuracao, ViewFormConfiguracao, Dao> {

    public ControllerFormConfiguracao(Controller caller) {
        super(caller, false);
    }
    
    @Override
    protected ViewFormConfiguracao getInstanceView() {
        return new ViewFormConfiguracao();
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
        addActionListenerBotaoConfigurarCamera();
    }
    
    private void addActionListenerBotaoGravar() {
        this.getView().getBotaoGravar().addActionListener((e) -> {
            JComboBox<ListaItem> comboBoxTipoExperiencia = this.getView().getComboBoxTipoExperiencia();
            Integer tipoExperienciaSelecionado = (Integer) comboBoxTipoExperiencia.getItemAt(comboBoxTipoExperiencia.getSelectedIndex()).getCodigo();
            this.getModel().setTipoExperiencia(tipoExperienciaSelecionado);
            
            float percentualMatch = NumberUtils.parseFloat(this.getView().getTextPercentualMatch().getText());
            if (percentualMatch < 0 || percentualMatch > 100) {
                this.getView().showTypedMessage("Atenção", "Percentual de match inválido! Informe valores entre 0 e 100", JOptionPane.WARNING_MESSAGE);
            }
            
            this.getModel().setPercentualMatch(percentualMatch);
            
            int margemErroLocalizacao = NumberUtils.parseInt(this.getView().getTextMargemErroLocalizacao().getText());
            this.getModel().setMargemErroLocalizacao(margemErroLocalizacao);
            
            if (this.processaDados()) {
                this.getView().showTypedMessage("Sucesso", "Configurações salvas com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                this.getView().showTypedMessage("Erro", "Houve um erro ao tentar salvar as configurações. Contate o suporte", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    
    private void addActionListenerBotaoConfigurarCamera() {
        this.getView().getBotaoConfigurarCamera().addActionListener((e) -> {
            (new ControllerFormConfiguracaoCamera(this)).showView();
        });
    }
    
}
