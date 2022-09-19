package view.grid;

import interfaces.ListagemFiltravel;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import model.Model;
import util.CampoFiltro;
import util.OperadorFiltro;
import view.View;

/**
 *
 * @author Ruan
 * @param <TypeModel>
 */
abstract public class ViewGrid<TypeModel extends Model> extends View<TypeModel> {
    
    protected TableModelPadrao<TypeModel> tableModel;

    /**
     * Ações que dependem de uma seleção de registro da consulta
     * @return ArrayList
     */
    abstract public ArrayList<JButton> getAcoesGrid();
    
    abstract public JTable getTable();
    
    abstract public JButton getBotaoConsultar();
    
    public ViewGrid() throws HeadlessException {
        this.tableModel = this.getInstanceTableModel();
    }

    public void trataFiltros() {
        if (this.usaFiltros()) {
            this.setListaCampos(((ListagemFiltravel) this.getModel()).getCamposFiltraveis());
        }
    }
    
    public boolean usaFiltros() {
        return this.getModel() instanceof ListagemFiltravel
            && this.getListaCampo()         != null
            && this.getListaOperador()      != null
            && this.getCampoValorFiltro()   != null
            && this.getCampoValorFiltro2()  != null;
    }
    
    public boolean isFiltrosSetados() {
        boolean retorno = false;
        
        CampoFiltro    campoFiltro    = this.getListaCampo().getItemAt(this.getListaCampo().getSelectedIndex());
        OperadorFiltro operadorFiltro = this.getListaOperador().getItemAt(this.getListaOperador().getSelectedIndex());
        String         valor          = this.getCampoValorFiltro().getText();
        String         valor2         = this.getCampoValorFiltro2().getText();
        
        if (campoFiltro != null && operadorFiltro != null) {
            if (campoFiltro.isTipoString()) {
                retorno = !valor.equals("");
            }
            else if (campoFiltro.isTipoInteger()) {
                retorno = !valor.equals("");
                if (operadorFiltro.usaCampo2()) {
                    retorno = retorno && !valor2.equals("");
                }
            }
            else if (campoFiltro.isTipoFloat()) {
                retorno = !valor.replace(((MaskFormatter) this.getCampoValorFiltro().getFormatter()).getPlaceholderCharacter(), '#').equals(this.MASCARA_DOUBLE_7_2);
                if (operadorFiltro.usaCampo2()) {
                    retorno = retorno && !valor2.replace(((MaskFormatter) this.getCampoValorFiltro2().getFormatter()).getPlaceholderCharacter(), '#').equals(this.MASCARA_DOUBLE_7_2);
                }
            }
            else if (campoFiltro.isTipoDate()) {
                retorno = !valor.replace(((MaskFormatter) this.getCampoValorFiltro().getFormatter()).getPlaceholderCharacter(), '#').equals(this.MASCARA_DATE);
                if (operadorFiltro.usaCampo2()) {
                    retorno = retorno && !valor2.replace(((MaskFormatter) this.getCampoValorFiltro2().getFormatter()).getPlaceholderCharacter(), '#').equals(this.MASCARA_DATE);
                }
            }
        }
        
        return retorno;
    }
    
    public void setListaCampos(ArrayList<CampoFiltro> camposFiltro) {
        for (ActionListener actionListener : this.getListaCampo().getActionListeners()) {
            this.getListaCampo().removeActionListener(actionListener);
        }
        
        this.getListaCampo().removeAllItems();
        
        camposFiltro.forEach(campoFiltro -> {
            this.getListaCampo().addItem(campoFiltro);
        });
        
        this.setListaOperadores(camposFiltro.get(0).getOperadores());
        
        this.getListaCampo().addActionListener((e) -> {
            CampoFiltro campoFiltro = this.getListaCampo().getItemAt(this.getListaCampo().getSelectedIndex());
            this.setListaOperadores(campoFiltro.getOperadores());
            this.trataMascarasFiltros(campoFiltro);
        });
    }
    
    public void setListaOperadores(ArrayList<OperadorFiltro> operadoresFiltro) {
        for (ActionListener actionListener : this.getListaOperador().getActionListeners()) {
            this.getListaOperador().removeActionListener(actionListener);
        }
        
        this.getListaOperador().removeAllItems();
        
        operadoresFiltro.forEach(operadorFiltro -> {
            this.getListaOperador().addItem(operadorFiltro);
        });
        
        this.getCampoValorFiltro2().setEnabled(operadoresFiltro.get(0).usaCampo2());
        
        this.getListaOperador().addActionListener((e) -> {
            OperadorFiltro operadorFiltro = this.getListaOperador().getItemAt(this.getListaOperador().getSelectedIndex());
            this.getCampoValorFiltro2().setEnabled(operadorFiltro.usaCampo2());
        });
    }
    
    protected void trataMascarasFiltros(CampoFiltro campoFiltro) {
        if (campoFiltro.isTipoString()) {
            if (this.getCampoValorFiltro().getFormatter() != null) {
                this.getCampoValorFiltro().getFormatter().uninstall();
                this.getCampoValorFiltro().setText("");
            }
            if (this.getCampoValorFiltro2().getFormatter() != null) {
                this.getCampoValorFiltro2().getFormatter().uninstall();
                this.getCampoValorFiltro2().setText("");
            }
        }
        else if (campoFiltro.isTipoInteger()) {
            if (this.getCampoValorFiltro().getFormatter() != null) {
                this.getCampoValorFiltro().getFormatter().uninstall();
                this.getCampoValorFiltro().setText("");
            }
            if (this.getCampoValorFiltro2().getFormatter() != null) {
                this.getCampoValorFiltro2().getFormatter().uninstall();
                this.getCampoValorFiltro2().setText("");
            }
        }
        else if (campoFiltro.isTipoFloat()) {
            this.formataCampo(this.getCampoValorFiltro(),  View.MASCARA_DOUBLE_7_2, '0');
            this.formataCampo(this.getCampoValorFiltro2(), View.MASCARA_DOUBLE_7_2, '0');
        }
        else if (campoFiltro.isTipoDate()) {
            this.formataCampo(this.getCampoValorFiltro(),  View.MASCARA_DATE, '0');
            this.formataCampo(this.getCampoValorFiltro2(), View.MASCARA_DATE, '0');
        }
    }
    
    protected TableModelPadrao<TypeModel> getInstanceTableModel() {
        return new TableModelPadrao<>(this.getInstanceModel());
    }
    
    public TableModelPadrao<TypeModel> getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModelPadrao tableModel) {
        this.tableModel = tableModel;
    }
    
    public ArrayList<JButton> getAcoesGridMultiSelecao() {
        return new ArrayList<>();
    }

    public JComboBox<CampoFiltro> getListaCampo() {
        return null;
    }

    public JComboBox<OperadorFiltro> getListaOperador() {
        return null;
    }
    
    public JFormattedTextField getCampoValorFiltro() {
        return null;
    }

    public JFormattedTextField getCampoValorFiltro2() {
        return null;
    }

}