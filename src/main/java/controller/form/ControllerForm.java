package controller.form;

import controller.Controller;
import dao.Dao;
import model.Model;
import view.form.ViewForm;

/**
 * Controlador base para controladores de manutenção
 * @author Ruan
 * @param <TypeModel>
 * @param <TypeView>
 * @param <TypeDao>
 */
abstract public class ControllerForm<TypeModel extends Model, TypeView extends ViewForm, TypeDao extends Dao> extends Controller<TypeModel, TypeView, TypeDao> {
    
    private boolean onlyVisualizacao;
    
    public ControllerForm(Controller caller, boolean onlyVisualizacao) {
        super(caller);
        this.onlyVisualizacao = onlyVisualizacao;
    }

    @Override
    public void showView() {
        super.showView();
        this.getView().setOnlyVisualizacao(this.isOnlyVisualizacao());
        this.beanDadosTela();
    }
    
    protected void beanDadosTela() {
        if (this.getModel().isChavePreenchida()) {
            this.getView().setModel(this.getModel());
            this.getView().beanDados();
        }
    }

    public boolean isOnlyVisualizacao() {
        return this.onlyVisualizacao;
    }

    public ControllerForm setOnlyVisualizacao(boolean onlyVisualizacao) {
        this.onlyVisualizacao = onlyVisualizacao;
        return this;
    }

}