package controller.form;

import controller.Controller;
import dao.Dao;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import model.ConfiguracaoCamera;
import util.NumberUtils;
import view.form.ViewFormConfiguracaoCamera;

/**
 *
 * @author ruang
 */
public class ControllerFormConfiguracaoCamera extends ControllerForm<ConfiguracaoCamera, ViewFormConfiguracaoCamera, Dao> {

    static public final int MAX_DIMENSAO_IMAGEM_CAMERA = 800;
    
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

    @Override
    protected void beanDadosTela() {
        super.beanDadosTela();
        this.addActionListeners();
        this.onChangeComboBoxCamera();
    }
    
    private void addActionListeners() {
        this.getView().getComboBoxCamera().addActionListener((e) -> {
            this.onChangeComboBoxCamera();
        });
    }
    
    private void onChangeComboBoxCamera() {
        JComboBox<Integer> comboBoxCamera = this.getView().getComboBoxCamera();
        int idCamera = comboBoxCamera.getItemAt(comboBoxCamera.getSelectedIndex());
        
        this.loadImagemCamera(idCamera);
        this.loadConfiguracaoCamera(idCamera);
        this.loadConfiguracoesPinos(idCamera);
    }

    private void loadImagemCamera(int idCamera) {
        try {
            // @todo ler da câmera
            BufferedImage image = ImageIO.read(new File("/home/ruan/Documentos/tcc/cancha.png"));
            
            int originalWidth  = image.getWidth();
            int originalHeight = image.getHeight();
            
            int maxDimensao = Math.max(originalWidth, originalHeight);
            
            if (maxDimensao > MAX_DIMENSAO_IMAGEM_CAMERA) {
                int mdc = NumberUtils.mdc(originalWidth, originalHeight);
                int targetWidth  = originalWidth  / mdc * ((int) MAX_DIMENSAO_IMAGEM_CAMERA / (maxDimensao / mdc));
                int targetHeight = originalHeight / mdc * ((int) MAX_DIMENSAO_IMAGEM_CAMERA / (maxDimensao / mdc));
                
                BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = resizedImage.createGraphics();
                graphics2D.drawImage(image, 0, 0, targetWidth, targetHeight, null);
                graphics2D.dispose();
                image = resizedImage;
            }
            
            Icon icon = new ImageIcon(image);
            this.getView().getLabelImagemCamera().setIcon(icon);
        }
        catch (IOException ex) {
            Logger.getLogger(ControllerFormConfiguracaoCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadConfiguracaoCamera(int idCamera) {
        
    }

    private void loadConfiguracoesPinos(int idCamera) {
        
    }

}
