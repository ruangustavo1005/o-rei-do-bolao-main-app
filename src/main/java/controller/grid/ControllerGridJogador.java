package controller.grid;

import controller.Controller;
import dao.Dao;
import model.Jogador;
import view.grid.ViewGridJogador;

/**
 *
 * @author ruan
 */
public class ControllerGridJogador extends ControllerGrid<Jogador, ViewGridJogador, Dao> {

    public ControllerGridJogador(Controller caller) {
        super(caller);
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected ViewGridJogador getInstanceView() {
        return new ViewGridJogador();
    }
    
}
