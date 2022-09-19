package controller.grid;

import controller.Controller;
import dao.Dao;
import exceptions.ValorInvalidoCampo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.Model;
import util.CampoFiltro;
import util.NumberUtils;
import util.OperadorFiltro;
import view.grid.ViewGrid;

/**
 * Controlador base para controladores de consultas
 * @author Ruan
 * @param <TypeModel>
 * @param <TypeView>
 * @param <TypeDao>
 */
abstract public class ControllerGrid<TypeModel extends Model, TypeView extends ViewGrid, TypeDao extends Dao> extends Controller<TypeModel, TypeView, TypeDao> {
    
    public ControllerGrid(Controller caller) {
        super(caller);
    }

    @Override
    public void showView() {
        super.showView();
        this.setEnabledAcoesGrid(false, false);
        this.getView().getTable().getSelectionModel().addListSelectionListener((e) -> {
            this.onSelectRegistroConsulta();
        });
        this.processaDados();
        this.addListenerAcaoConsultar();
        this.getView().trataFiltros();
    }

    @Override
    public boolean processaDados() {
        this.getView().getTableModel().setModelos(this.getDadosConsulta());
        this.getView().getTableModel().sort();
        return true;
    }

    protected void addListenerAcaoConsultar() {
        this.getView().getBotaoConsultar().addActionListener((e) -> {
            this.atualizaConsulta();
        });
    }
    
    protected List<TypeModel> getDadosConsulta() {
        if (this.getView().usaFiltros()) {
            if (this.getView().isFiltrosSetados()) {
                CampoFiltro    campoFiltro    = (CampoFiltro)    this.getView().getListaCampo().getItemAt(this.getView().getListaCampo().getSelectedIndex());
                OperadorFiltro operadorFiltro = (OperadorFiltro) this.getView().getListaOperador().getItemAt(this.getView().getListaOperador().getSelectedIndex());
                
                String campo = this.trataValorFiltro(campoFiltro, this.getView().getCampoValorFiltro());
                
                if (operadorFiltro.usaCampo2()) {
                    String campo2 = this.trataValorFiltro(campoFiltro, this.getView().getCampoValorFiltro2());
                    
                    try {
                        return this.getDao().get(campoFiltro, operadorFiltro, campo, campo2);
                    }
                    catch (ValorInvalidoCampo exception) {
                        this.getView().showTypedMessage("Erro", "Valor inválido para o valor do filtro de " + campoFiltro.getDescricao(), JOptionPane.WARNING_MESSAGE);
                    }
                }
                
                try {
                    return this.getDao().get(campoFiltro, operadorFiltro, campo);
                }
                catch (ValorInvalidoCampo exception) {
                    this.getView().showTypedMessage("Erro", "Valor inválido para o valor do filtro de " + campoFiltro.getDescricao(), JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return this.getDao().get();
    }
    
    protected String trataValorFiltro(CampoFiltro campoFiltro, JFormattedTextField campo) {
        if (campoFiltro.isTipoFloat()) {
            return String.valueOf(NumberUtils.parseFloat(campo.getText()));
        }
        
        return campo.getText();
    }
    
    protected void setEnabledAcoesGrid(boolean enabled, boolean enabledMultiSelecao) {
        this.getView().getAcoesGrid().forEach((botao) -> {
            if (botao instanceof JButton) {
                ((JButton) botao).setEnabled(enabled || (this.getView().getAcoesGridMultiSelecao().contains(botao) && enabledMultiSelecao));
            }
        });
    }
    
    public void atualizaConsulta() {
        this.getView().getTableModel().atualizaModelos(this.getDadosConsulta());
    }
    
    protected void onSelectRegistroConsulta() {
        this.setEnabledAcoesGrid(this.getView().getTable().getSelectedRows().length == 1, this.getView().getTable().getSelectedRows().length >= 1);
    }
    
    public TypeModel getSelectedModel() {
        TypeModel model = null;
        if (this.getView().getTable().getSelectedRowCount() == 1) {
            model = (TypeModel) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
        }
        return model;
    }
    
    public ArrayList<TypeModel> getSelectedModels() {
        ArrayList<TypeModel> models = new ArrayList();
        if (this.getView().getTable().getSelectedRowCount() > 0) {
            for (int row : this.getView().getTable().getSelectedRows()) {
                models.add((TypeModel) this.getView().getTableModel().get(row));
            }
        }
        return models;
    }
    
}