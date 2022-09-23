package view.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.Configuracao;
import util.ListaItem;
import util.ListaUtils;
import util.NumberUtils;

/**
 *
 * @author ruang
 */
public class ViewFormConfiguracao extends ViewForm<Configuracao> {

    public ViewFormConfiguracao() {
        super();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboBoxTipoExperiencia = new javax.swing.JComboBox<>();
        botaoGravar = new javax.swing.JButton();
        botaoConfigurarCamera = new javax.swing.JButton();
        textPercentualMatch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textMargemErroLocalizacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tipo da jogada de experiência:");

        botaoGravar.setText("Gravar");

        botaoConfigurarCamera.setText("Configurar Parâmetros da Câmera");

        jLabel2.setText("Percentual de match geral:");

        jLabel3.setText("Margem de erro da localização");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfigurarCamera))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxTipoExperiencia, 0, 219, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textPercentualMatch, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(textMargemErroLocalizacao))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPercentualMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMargemErroLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGravar)
                    .addComponent(botaoConfigurarCamera))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected String getTitulo() {
        return "Configurações";
    }

    @Override
    protected Configuracao getInstanceModel() {
        return new Configuracao();
    }

    @Override
    public Configuracao getModelFromDadosTela() {
        return this.getModel();
    }

    @Override
    public void beanDados() {
        ListaUtils.povoaComboBox(this.getComboBoxTipoExperiencia(), Configuracao.getListaTipoExperiencia(), this.getModel().getTipoExperiencia());
        this.getTextPercentualMatch().setText(NumberUtils.formataValor(this.getModel().getPercentualMatch()));
        this.getTextMargemErroLocalizacao().setText(String.valueOf(this.getModel().getMargemErroLocalizacao()));
    }

    public JComboBox<ListaItem> getComboBoxTipoExperiencia() {
        return comboBoxTipoExperiencia;
    }

    public JButton getBotaoConfigurarCamera() {
        return botaoConfigurarCamera;
    }

    public JButton getBotaoGravar() {
        return botaoGravar;
    }

    public JTextField getTextPercentualMatch() {
        return textPercentualMatch;
    }

    public JTextField getTextMargemErroLocalizacao() {
        return textMargemErroLocalizacao;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfigurarCamera;
    private javax.swing.JButton botaoGravar;
    private javax.swing.JComboBox<ListaItem> comboBoxTipoExperiencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textMargemErroLocalizacao;
    private javax.swing.JTextField textPercentualMatch;
    // End of variables declaration//GEN-END:variables

}
