package controller;

import dao.Dao;
import model.Model;
import view.View;

/**
 *
 * @author ruang
 * @param <TypeModel>
 * @param <TypeView>
 * @param <TypeDao>
 */
abstract public class Controller<TypeModel extends Model, TypeView extends View, TypeDao extends Dao> {
    
    protected Controller caller;
    protected TypeModel  model;
    protected TypeView   view;
    protected TypeDao    dao;

    public Controller(Controller caller) {
        this.caller = caller;
        this.createInstances();
    }

    protected void createInstances() {
        this.model = this.getInstanceModel();
        this.view  = this.getInstanceView();
        this.dao   = this.getInstanceDao();
    }
    
    abstract public boolean processaDados();
    
    abstract protected TypeModel getInstanceModel();
    
    abstract protected TypeView getInstanceView();
    
    protected TypeDao getInstanceDao() {
        return this.getInstanceDao(this.getModel().getClass());
    }
    
    protected TypeDao getInstanceDao(Class classe) {
        return (TypeDao) new Dao(classe);
    }
    
    public void showView() {
        this.getView().setVisible(true);
    }
    
    protected TypeModel getModel() {
        if (this.model == null) {
            this.model = this.getInstanceModel();
        }
        return model;
    }

    public Controller setModel(TypeModel model) {
        this.model = model;
        return this;
    }

    protected TypeView getView() {
        if (this.view == null) {
            this.view = this.getInstanceView();
        }
        return view;
    }

    protected TypeDao getDao() {
        return this.getDao(false);
    }
    
    protected TypeDao getDao(boolean newInstance) {
        if (this.dao == null || newInstance) {
            this.dao = this.getInstanceDao();
        }
        return dao;
    }

    protected TypeDao getDao(boolean newInstance, Class classe) {
        if (this.dao == null || newInstance) {
            this.dao = this.getInstanceDao(classe);
        }
        return dao;
    }
    
    public Controller getCaller() {
        return caller;
    }
    
}
