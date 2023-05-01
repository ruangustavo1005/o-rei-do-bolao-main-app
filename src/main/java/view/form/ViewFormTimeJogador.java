package view.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Jogador;

/**
 *
 * @author ruan
 */
public class ViewFormTimeJogador extends ViewForm<Jogador> {

    public ViewFormTimeJogador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoGravar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        comboBoxJogador = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botaoGravar.setText("Gravar");

        botaoCancelar.setText("Cancelar");

        jLabel3.setText("Jogador:");

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
                        .addComponent(botaoCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGravar)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Jogador getModelFromDadosTela() {
        return this.getComboBoxJogador().getItemAt(this.getComboBoxJogador().getSelectedIndex());
    }

    @Override
    public void beanDados() {
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected String getTitulo() {
        return "Jogador x Time";
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public JButton getBotaoGravar() {
        return botaoGravar;
    }

    public JComboBox<Jogador> getComboBoxJogador() {
        return comboBoxJogador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoGravar;
    private javax.swing.JComboBox<Jogador> comboBoxJogador;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
