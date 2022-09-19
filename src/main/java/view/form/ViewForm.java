package view.form;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import model.Model;
import view.View;

/**
 *
 * @author Ruan
 * @param <TypeModel>
 */
abstract public class ViewForm<TypeModel extends Model> extends View<TypeModel> {

    private boolean onlyVisualizacao;

    abstract public TypeModel getModelFromDadosTela();
    
    abstract public void beanDados();
    
    public boolean isOnlyVisualizacao() {
        return this.onlyVisualizacao;
    }

    public ViewForm setOnlyVisualizacao(boolean onlyVisualizacao) {
        this.onlyVisualizacao = onlyVisualizacao;
        if (onlyVisualizacao) {
            this.trataCamposVisualizacao(this);
        }
        return this;
    }
    
    public void trataCamposVisualizacao(Container container) {
        for (Component component : container.getComponents()) {
            if (!(component instanceof JButton)) {
                component.setEnabled(false);
            }
            if (component instanceof Container) {
                this.trataCamposVisualizacao((Container) component);
            }
        }
    }

}