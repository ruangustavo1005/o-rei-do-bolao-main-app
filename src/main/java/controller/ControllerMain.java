package controller;

import controller.form.ControllerFormConfiguracoes;
import dao.Dao;
import model.Model;
import view.ViewMain;

/**
 *
 * @author ruang
 */
public class ControllerMain extends Controller<Model, ViewMain, Dao> {

    public ControllerMain() {
        super(null);
    }
    
    @Override
    protected ViewMain getInstanceView() {
        return new ViewMain();
    }

    @Override
    protected void createInstances() {
        super.createInstances();
        this.addActionListenersMenus();
    }
    
    private void addActionListenersMenus() {
        this.addActionListenersMenuItemConfiguracoes();
    }
    
    private void addActionListenersMenuItemConfiguracoes() {
        this.getView().getMenuItemConfiguracoes().addActionListener((e) -> {
            (new ControllerFormConfiguracoes(this)).showView();
        });
    }

    @Override
    public boolean processaDados() {
        return true;
    }

    @Override
    protected Model getInstanceModel() {
        return null;
    }

    @Override
    protected Dao getInstanceDao() {
        return null;
    }
    
}
