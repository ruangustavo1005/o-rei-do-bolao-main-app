package view.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Configuracao;
import util.ListaItem;
import util.ListaUtils;

/**
 *
 * @author ruang
 */
public class ViewFormConfiguracoes extends ViewForm<Configuracao> {

    public ViewFormConfiguracoes() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tipo da jogada de experiência:");

        botaoGravar.setText("Gravar");

        botaoConfigurarCamera.setText("Configurar Parâmetros da Câmera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTipoExperiencia, 0, 222, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfigurarCamera)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfigurarCamera;
    private javax.swing.JButton botaoGravar;
    private javax.swing.JComboBox<ListaItem> comboBoxTipoExperiencia;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
