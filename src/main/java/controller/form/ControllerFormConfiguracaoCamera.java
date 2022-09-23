package controller.form;

import controller.Controller;
import dao.Dao;
import model.ConfiguracaoCamera;
import view.form.ViewFormConfiguracaoCamera;

/**
 *
 * @author ruang
 */
public class ControllerFormConfiguracaoCamera extends ControllerForm<ConfiguracaoCamera, ViewFormConfiguracaoCamera, Dao> {

    public ControllerFormConfiguracaoCamera(Controller caller) {
        super(caller, false);
    }

    @Override
    public boolean processaDados() {
        return true;
    }

    @Override
    protected ConfiguracaoCamera getInstanceModel() {
        return new ConfiguracaoCamera();
    }

    @Override
    protected ViewFormConfiguracaoCamera getInstanceView() {
        return new ViewFormConfiguracaoCamera();
    }
    
}
