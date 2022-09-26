package controller.form;

import controller.Controller;
import dao.Dao;
import dao.DaoConfiguracaoPino;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.ConfiguracaoCamera;
import model.ConfiguracaoPino;
import util.ImagePanel;
import util.ImageUtils;
import util.NumberUtils;
import view.form.ViewFormConfiguracaoCamera;

/**
 *
 * @author ruang
 */
public class ControllerFormConfiguracaoCamera extends ControllerForm<ConfiguracaoCamera, ViewFormConfiguracaoCamera, Dao> {

    static public final int MAX_DIMENSAO_IMAGEM_CAMERA = 800;
    
    private int ultimaCameraSelecionadaNumero;
    private HashMap<Integer, Point> localizacoesPinos = new HashMap<>();
    private DaoConfiguracaoPino daoConfiguracaoPino;
    
    public ControllerFormConfiguracaoCamera(Controller caller) {
        super(caller, false);
    }

    @Override
    protected void createInstances() {
        super.createInstances();
        this.daoConfiguracaoPino = new DaoConfiguracaoPino();
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

    @Override
    protected void beanDadosTela() {
        super.beanDadosTela();
        this.addListeners();
        this.onChangeComboBoxCamera();
    }
    
    private void addListeners() {
        this.addActionListenerComboBoxCamera();
        this.addActionListenerBotaoGravarConfiguracoesCamera();
        this.addActionListenerBotaoGravarConfiguracoesPinos();
        this.addActionListenersLabelsPinos();
        this.getView().getPanelImagemCamera().addAfterMousePressedListner((e) -> {
            Integer pinoAtual = null;
            for (Integer numero : ConfiguracaoPino.getNumeros()) {
                if (this.getView().getLabelImagemPino(numero).equals(((ImagePanel) e.getSource()).getSelectedArea())) {
                    pinoAtual = numero;
                    break;
                }
            }
            
            Point startPoint = ((ImagePanel) e.getSource()).getStartDrag();
            this.localizacoesPinos.put(pinoAtual, startPoint);
        });
    }
    
    private void addActionListenerComboBoxCamera() {
        this.getView().getComboBoxCamera().addActionListener((e) -> {
            this.onChangeComboBoxCamera();
        });
    }
    
    private void addActionListenersLabelsPinos() {
        ConfiguracaoPino.getNumeros().forEach((numero) -> {
            JLabel labelImagemPino = this.getView().getLabelImagemPino(numero);
            labelImagemPino.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    getView().getPanelImagemCamera().setSelectedAreaPanel(labelImagemPino);
                }
            });
        });
    }
    
    private void addActionListenerBotaoGravarConfiguracoesCamera() {
        this.getView().getBotaoGravarConfiguracoesCamera().addActionListener((e) -> {
            float percentualMatchCamera = NumberUtils.parseFloat(this.getView().getTextPercentualMatchCamera().getText());
            int margemErroLocalizacao = NumberUtils.parseInt(this.getView().getTextMargemErroLocalizacaoCamera().getText());
            
            ConfiguracaoCamera configuracaoCamera = (ConfiguracaoCamera) this.getDao().get(this.getSelectedCameraNumero());
            if (configuracaoCamera != null) {
                configuracaoCamera.setPercentualMatch(percentualMatchCamera);
                configuracaoCamera.setMargemErroLocalizacao(margemErroLocalizacao);
                if (this.getDao().update(configuracaoCamera)) {
                    this.getView().showTypedMessage("Sucesso", "Configuração alterada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    this.getView().showTypedMessage("Erro", "Houve um erro ao tentar alterar a configuração. Contate o suporte", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                configuracaoCamera = new ConfiguracaoCamera();
                configuracaoCamera.setNumero(this.getSelectedCameraNumero());
                configuracaoCamera.setPercentualMatch(percentualMatchCamera);
                configuracaoCamera.setMargemErroLocalizacao(margemErroLocalizacao);
                if (this.getDao().add(configuracaoCamera)) {
                    this.getView().showTypedMessage("Sucesso", "Configuração inserida com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    this.getView().showTypedMessage("Erro", "Houve um erro ao tentar inserir a configuração. Contate o suporte", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    
    private void addActionListenerBotaoGravarConfiguracoesPinos() {
        this.getView().getBotaoGravarConfiguracoesPinos().addActionListener((e) -> {
            try {
                this.daoConfiguracaoPino.disableTransactions();
                this.daoConfiguracaoPino.begin();

                boolean sucesso = true;
                int selectedCameraNumero = this.getSelectedCameraNumero();

                for (int numero : ConfiguracaoPino.getNumeros()) {
                    ImageIcon icon = (ImageIcon) this.getView().getLabelImagemPino(numero).getIcon();
                    if (icon != null) {
                        BufferedImage image = (BufferedImage) icon.getImage();
                        float percentualMatch = NumberUtils.parseFloat(this.getView().getTextPercentualMatchPino(numero).getText());
                        int margemErroLocalizacao = NumberUtils.parseInt(this.getView().getTextMargemErroLocalizacaoPino(numero).getText());

                        ConfiguracaoPino configuracaoPino = this.daoConfiguracaoPino.get(selectedCameraNumero, numero);
                        if (configuracaoPino != null) {
                            configuracaoPino.setPercentualMatch(percentualMatch);
                            configuracaoPino.setMargemErroLocalizacao(margemErroLocalizacao);
                            configuracaoPino.setImagem(ImageUtils.getBytesFromBufferedImage(image, "jpg"));

                            Point point = this.localizacoesPinos.get(numero);
                            if (point != null) {
                                configuracaoPino.setPosX((int) point.getX());
                                configuracaoPino.setPosY((int) point.getY());
                            }

                            if (!this.daoConfiguracaoPino.update(configuracaoPino)) {
                                sucesso = false;
                                break;
                            }
                        }
                        else {
                            configuracaoPino = new ConfiguracaoPino();
                            configuracaoPino.setCamera(new ConfiguracaoCamera()).getCamera().setNumero(selectedCameraNumero);
                            configuracaoPino.setNumero(numero);
                            configuracaoPino.setPercentualMatch(percentualMatch);
                            configuracaoPino.setMargemErroLocalizacao(margemErroLocalizacao);
                            configuracaoPino.setImagem(ImageUtils.getBytesFromBufferedImage(image, "jpg"));

                            Point point = this.localizacoesPinos.get(numero);
                            if (point != null) {
                                configuracaoPino.setPosX((int) point.getX());
                                configuracaoPino.setPosY((int) point.getY());
                            }

                            if (!this.daoConfiguracaoPino.add(configuracaoPino)) {
                                sucesso = false;
                                break;
                            }
                        }
                    }
                }

                if (sucesso) {
                    this.daoConfiguracaoPino.commit();
                    this.getView().showTypedMessage("Sucesso", "Configuração alterada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    this.getView().showTypedMessage("Erro", "Houve um erro ao tentar alterar a configuração. Contate o suporte", JOptionPane.ERROR_MESSAGE);
                    this.daoConfiguracaoPino.rollback();
                }
            }
            catch (Exception ex) {
                this.getView().showTypedMessage("Erro", "Houve um erro não esperado. Contate o suporte", JOptionPane.ERROR_MESSAGE);
                if (this.daoConfiguracaoPino.isTransactionActive()) {
                    this.daoConfiguracaoPino.rollback();
                }
            }
            finally {
                this.daoConfiguracaoPino.enableTransactions();
            }
        });
    }
    
    private void onChangeComboBoxCamera() {
        int numeroCamera = this.getSelectedCameraNumero();
        
        if (numeroCamera != this.ultimaCameraSelecionadaNumero) {
            this.reloadImagemCamera(numeroCamera);
            
            ConfiguracaoCamera configuracaoCamera = (ConfiguracaoCamera) this.getDao().get(numeroCamera);
            if (configuracaoCamera != null) {
                this.reloadConfiguracaoCamera(configuracaoCamera);
                this.reloadConfiguracoesPinos(configuracaoCamera);
            }
            else {
                this.resetConfiguracaoCamera();
                this.resetConfiguracoesPinos();
            }
            
            this.ultimaCameraSelecionadaNumero = numeroCamera;
        }
    }

    private void reloadImagemCamera(int numeroCamera) {
        try {
            // @todo ler da câmera
//            BufferedImage image = ImageUtils.resizeKeepProportion(ImageIO.read(new File("/home/ruan/Documentos/tcc/cancha.png")), MAX_DIMENSAO_IMAGEM_CAMERA);
            BufferedImage image = ImageUtils.resizeKeepProportion(ImageIO.read(new File("C:/Users/ruang/Downloads/cancha.JPG")), MAX_DIMENSAO_IMAGEM_CAMERA);
            this.getView().getPanelImagemCamera().setImage(image);
            this.getView().repaint();
        }
        catch (IOException ex) {
            Logger.getLogger(ControllerFormConfiguracaoCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reloadConfiguracaoCamera(ConfiguracaoCamera configuracaoCamera) {
        this.getView().getTextMargemErroLocalizacaoCamera().setText(String.valueOf(configuracaoCamera.getMargemErroLocalizacao()));
        this.getView().getTextPercentualMatchCamera().setText(NumberUtils.formataValor(configuracaoCamera.getPercentualMatch()));
    }

    private void reloadConfiguracoesPinos(ConfiguracaoCamera configuracaoCamera) {
        
    }

    private void resetConfiguracaoCamera() {
        
        this.getView().getTextMargemErroLocalizacaoCamera().setText("");
        this.getView().getTextPercentualMatchCamera().setText("");
    }

    private void resetConfiguracoesPinos() {
        
    }

    private int getSelectedCameraNumero() {
        JComboBox<Integer> comboBoxCamera = this.getView().getComboBoxCamera();
        return comboBoxCamera.getItemAt(comboBoxCamera.getSelectedIndex());
    }
    
}
