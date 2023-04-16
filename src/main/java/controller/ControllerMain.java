package controller;

import controller.form.ControllerFormConfiguracao;
import controller.grid.ControllerGridJogador;
import controller.grid.ControllerGridTime;
import dao.Dao;
import model.Configuracao;
import model.Model;
import view.ViewMain;

/**
 *
 * @author ruang
 */
public class ControllerMain extends Controller<Model, ViewMain, Dao> {

    public ControllerMain() {
        super(null);
        this.verificaConfiguracaoGeral();
    }
    
    private void verificaConfiguracaoGeral() {
        Dao<Configuracao> daoConfiguracao = new Dao<>(Configuracao.class);
        if (daoConfiguracao.get(1) == null) {
            Configuracao configuracao = new Configuracao()
                    .setTipoExperiencia(Configuracao.TIPO_EXPERIENCIA_PRIMEIRA_BOLA)
                    .setPercentualMatch(90)
                    .setMargemErroLocalizacao(30);
            
            daoConfiguracao.add(configuracao);
        }
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
        this.addActionListenersMenuItemJogadores();
        this.addActionListenersMenuItemTimes();
    }
    
    private void addActionListenersMenuItemConfiguracoes() {
        this.getView().getMenuItemConfiguracoes().addActionListener((e) -> {
            (new ControllerFormConfiguracao(this)).showView();
        });
    }
    
    private void addActionListenersMenuItemJogadores() {
        this.getView().getMenuItemJogadores().addActionListener((e) -> {
            (new ControllerGridJogador(this)).showView();
        });
    }
    
    private void addActionListenersMenuItemTimes() {
        this.getView().getMenuItemTimes().addActionListener((e) -> {
            (new ControllerGridTime(this)).showView();
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
