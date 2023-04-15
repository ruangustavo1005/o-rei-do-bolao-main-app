package view.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.ConfiguracaoCamera;
import model.ConfiguracaoPino;
import util.ImagePanel;

/**
 *
 * @author ruang
 */
public class ViewFormConfiguracaoCamera extends ViewForm<ConfiguracaoCamera> {

    public ViewFormConfiguracaoCamera() {
        super();
        initComponents();
        initLocalComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboBoxCamera = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textPercentualMatchCamera = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textMargemErroLocalizacaoCamera = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelPino1 = new javax.swing.JLabel();
        textPercentualMatchPino1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelPino2 = new javax.swing.JLabel();
        textPercentualMatchPino2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labelPino3 = new javax.swing.JLabel();
        textPercentualMatchPino3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        labelPino4 = new javax.swing.JLabel();
        textPercentualMatchPino4 = new javax.swing.JTextField();
        labelPino5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        labelPino6 = new javax.swing.JLabel();
        textPercentualMatchPino5 = new javax.swing.JTextField();
        textPercentualMatchPino6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino5 = new javax.swing.JTextField();
        textMargemErroLocalizacaoPino6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelPino7 = new javax.swing.JLabel();
        textPercentualMatchPino7 = new javax.swing.JTextField();
        labelPino8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        labelPino9 = new javax.swing.JLabel();
        textPercentualMatchPino8 = new javax.swing.JTextField();
        textPercentualMatchPino9 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textMargemErroLocalizacaoPino8 = new javax.swing.JTextField();
        textMargemErroLocalizacaoPino9 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        botaoGravarConfiguracoesCamera = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        panelImagemCamera = new ImagePanel();
        botaoGravarConfiguracoesPinos = new javax.swing.JButton();
        textEndpointRTSP = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Câmera:");

        jLabel3.setText("Percentual de match da câmera:");

        jLabel4.setText("Margem de erro da localização da câmera:");

        labelPino1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("PM:");

        jLabel5.setText("ME:");

        labelPino2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("PM:");

        jLabel7.setText("ME:");

        labelPino3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("PM:");

        jLabel9.setText("ME:");

        labelPino4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelPino5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("PM:");

        jLabel11.setText("ME:");

        labelPino6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("PM:");

        jLabel13.setText("PM:");

        jLabel14.setText("ME:");

        jLabel15.setText("ME:");

        labelPino7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelPino8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("PM:");

        jLabel17.setText("ME:");

        labelPino9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelPino9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setText("PM:");

        jLabel19.setText("PM:");

        jLabel20.setText("ME:");

        jLabel21.setText("ME:");

        botaoGravarConfiguracoesCamera.setText("Gravar configurações da câmera");

        jLabel22.setText("<html>\n* Clique nas imagens dos pinos para editá-las;<br/>\n* PM: Percentual de match (do pino);<br/>\n* ME: Margem de erro (do pino).\n</html>");

        panelImagemCamera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelImagemCameraLayout = new javax.swing.GroupLayout(panelImagemCamera);
        panelImagemCamera.setLayout(panelImagemCameraLayout);
        panelImagemCameraLayout.setHorizontalGroup(
            panelImagemCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelImagemCameraLayout.setVerticalGroup(
            panelImagemCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botaoGravarConfiguracoesPinos.setText("Gravar configurações dos pinos");

        textEndpointRTSP.setToolTipText("");

        jLabel23.setText("Endpoint RTSP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImagemCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoGravarConfiguracoesPinos))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel14)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel20)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel15)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelPino9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textPercentualMatchPino9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel21)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textMargemErroLocalizacaoPino9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelPino1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textPercentualMatchPino1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textMargemErroLocalizacaoPino1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelPino2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textPercentualMatchPino2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textMargemErroLocalizacaoPino2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelPino3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textPercentualMatchPino3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textMargemErroLocalizacaoPino3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEndpointRTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPercentualMatchCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMargemErroLocalizacaoCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoGravarConfiguracoesCamera)
                        .addContainerGap())))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(textPercentualMatchCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMargemErroLocalizacaoCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(botaoGravarConfiguracoesCamera)
                    .addComponent(textEndpointRTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelPino3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(textPercentualMatchPino3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMargemErroLocalizacaoPino3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelPino2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(textPercentualMatchPino2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMargemErroLocalizacaoPino2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(textMargemErroLocalizacaoPino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPino1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(textPercentualMatchPino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPino6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(textPercentualMatchPino6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textMargemErroLocalizacaoPino6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPino4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(textPercentualMatchPino4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textMargemErroLocalizacaoPino4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPino5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(textPercentualMatchPino5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMargemErroLocalizacaoPino5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPino9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(textPercentualMatchPino9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textMargemErroLocalizacaoPino9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPino7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(textPercentualMatchPino7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textMargemErroLocalizacaoPino7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPino8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(textPercentualMatchPino8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMargemErroLocalizacaoPino8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoGravarConfiguracoesPinos))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelImagemCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected String getTitulo() {
        return "Configurações dos Parâmetros das Câmeras";
    }

    @Override
    public ConfiguracaoCamera getModelFromDadosTela() {
        return this.getModel();
    }

    @Override
    public void beanDados() {
        
    }

    @Override
    protected ConfiguracaoCamera getInstanceModel() {
        return new ConfiguracaoCamera();
    }

    private void initLocalComponents() {
        ConfiguracaoCamera.getIds().forEach((id) -> {
            this.getComboBoxCamera().addItem(id);
        });
    }
    
    public JComboBox<Integer> getComboBoxCamera() {
        return comboBoxCamera;
    }

    public JTextField getTextPercentualMatchCamera() {
        return textPercentualMatchCamera;
    }
    
    public JTextField getTextMargemErroLocalizacaoCamera() {
        return textMargemErroLocalizacaoCamera;
    }

    public JTextField getTextEndpointRTSP() {
        return textEndpointRTSP;
    }

    public JButton getBotaoGravarConfiguracoesCamera() {
        return botaoGravarConfiguracoesCamera;
    }

    public JButton getBotaoGravarConfiguracoesPinos() {
        return botaoGravarConfiguracoesPinos;
    }

    public ImagePanel getPanelImagemCamera() {
        return panelImagemCamera;
    }

    public JLabel getLabelImagemPino(int pino) {
        switch (pino) {
            case ConfiguracaoPino.NUMERO_PINO_1: return this.labelPino1;
            case ConfiguracaoPino.NUMERO_PINO_2: return this.labelPino2;
            case ConfiguracaoPino.NUMERO_PINO_3: return this.labelPino3;
            case ConfiguracaoPino.NUMERO_PINO_4: return this.labelPino4;
            case ConfiguracaoPino.NUMERO_PINO_5: return this.labelPino5;
            case ConfiguracaoPino.NUMERO_PINO_6: return this.labelPino6;
            case ConfiguracaoPino.NUMERO_PINO_7: return this.labelPino7;
            case ConfiguracaoPino.NUMERO_PINO_8: return this.labelPino8;
            case ConfiguracaoPino.NUMERO_PINO_9: return this.labelPino9;
            default: return null;
        }
    }

    public JTextField getTextPercentualMatchPino(int pino) {
        switch (pino) {
            case ConfiguracaoPino.NUMERO_PINO_1: return this.textPercentualMatchPino1;
            case ConfiguracaoPino.NUMERO_PINO_2: return this.textPercentualMatchPino2;
            case ConfiguracaoPino.NUMERO_PINO_3: return this.textPercentualMatchPino3;
            case ConfiguracaoPino.NUMERO_PINO_4: return this.textPercentualMatchPino4;
            case ConfiguracaoPino.NUMERO_PINO_5: return this.textPercentualMatchPino5;
            case ConfiguracaoPino.NUMERO_PINO_6: return this.textPercentualMatchPino6;
            case ConfiguracaoPino.NUMERO_PINO_7: return this.textPercentualMatchPino7;
            case ConfiguracaoPino.NUMERO_PINO_8: return this.textPercentualMatchPino8;
            case ConfiguracaoPino.NUMERO_PINO_9: return this.textPercentualMatchPino9;
            default: return null;
        }
    }
    
    public JTextField getTextMargemErroLocalizacaoPino(int pino) {
        switch (pino) {
            case ConfiguracaoPino.NUMERO_PINO_1: return this.textMargemErroLocalizacaoPino1;
            case ConfiguracaoPino.NUMERO_PINO_2: return this.textMargemErroLocalizacaoPino2;
            case ConfiguracaoPino.NUMERO_PINO_3: return this.textMargemErroLocalizacaoPino3;
            case ConfiguracaoPino.NUMERO_PINO_4: return this.textMargemErroLocalizacaoPino4;
            case ConfiguracaoPino.NUMERO_PINO_5: return this.textMargemErroLocalizacaoPino5;
            case ConfiguracaoPino.NUMERO_PINO_6: return this.textMargemErroLocalizacaoPino6;
            case ConfiguracaoPino.NUMERO_PINO_7: return this.textMargemErroLocalizacaoPino7;
            case ConfiguracaoPino.NUMERO_PINO_8: return this.textMargemErroLocalizacaoPino8;
            case ConfiguracaoPino.NUMERO_PINO_9: return this.textMargemErroLocalizacaoPino9;
            default: return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGravarConfiguracoesCamera;
    private javax.swing.JButton botaoGravarConfiguracoesPinos;
    private javax.swing.JComboBox<Integer> comboBoxCamera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPino1;
    private javax.swing.JLabel labelPino2;
    private javax.swing.JLabel labelPino3;
    private javax.swing.JLabel labelPino4;
    private javax.swing.JLabel labelPino5;
    private javax.swing.JLabel labelPino6;
    private javax.swing.JLabel labelPino7;
    private javax.swing.JLabel labelPino8;
    private javax.swing.JLabel labelPino9;
    private ImagePanel panelImagemCamera;
    private javax.swing.JTextField textEndpointRTSP;
    private javax.swing.JTextField textMargemErroLocalizacaoCamera;
    private javax.swing.JTextField textMargemErroLocalizacaoPino1;
    private javax.swing.JTextField textMargemErroLocalizacaoPino2;
    private javax.swing.JTextField textMargemErroLocalizacaoPino3;
    private javax.swing.JTextField textMargemErroLocalizacaoPino4;
    private javax.swing.JTextField textMargemErroLocalizacaoPino5;
    private javax.swing.JTextField textMargemErroLocalizacaoPino6;
    private javax.swing.JTextField textMargemErroLocalizacaoPino7;
    private javax.swing.JTextField textMargemErroLocalizacaoPino8;
    private javax.swing.JTextField textMargemErroLocalizacaoPino9;
    private javax.swing.JTextField textPercentualMatchCamera;
    private javax.swing.JTextField textPercentualMatchPino1;
    private javax.swing.JTextField textPercentualMatchPino2;
    private javax.swing.JTextField textPercentualMatchPino3;
    private javax.swing.JTextField textPercentualMatchPino4;
    private javax.swing.JTextField textPercentualMatchPino5;
    private javax.swing.JTextField textPercentualMatchPino6;
    private javax.swing.JTextField textPercentualMatchPino7;
    private javax.swing.JTextField textPercentualMatchPino8;
    private javax.swing.JTextField textPercentualMatchPino9;
    // End of variables declaration//GEN-END:variables

}
