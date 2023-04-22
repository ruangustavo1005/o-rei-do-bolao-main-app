package view.grid;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import model.Jogador;
import model.TimeJogador;
import util.CampoFiltro;
import util.OperadorFiltro;

/**
 *
 * @author ruan
 */
public class ViewGridTimeJogador extends ViewGrid<Jogador> {

    private TimeJogador time;
    
    public ViewGridTimeJogador(TimeJogador time) {
        this.time = time;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoRelacionarJogador = new javax.swing.JButton();
        botaoRemoverJogador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listaCampo = new javax.swing.JComboBox<>();
        listaOperador = new javax.swing.JComboBox<>();
        campoValorFiltro = new javax.swing.JFormattedTextField();
        campoValorFiltro2 = new javax.swing.JFormattedTextField();
        botaoConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botaoRelacionarJogador.setText("Relacionar Jogador");

        botaoRemoverJogador.setText("Remover Jogador");

        jLabel1.setText("Filtros:");

        botaoConsultar.setText("Consultar");

        table.setModel(this.getTableModel());
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoRelacionarJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoRemoverJogador)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaOperador, 0, 109, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(botaoConsultar)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRelacionarJogador)
                    .addComponent(botaoRemoverJogador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConsultar)
                    .addComponent(jLabel1)
                    .addComponent(listaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValorFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> botoes = new ArrayList<>();
        botoes.add(this.botaoRemoverJogador);
        return botoes;
    }

    @Override
    public ArrayList<JButton> getAcoesGridMultiSelecao() {
        ArrayList<JButton> acoesGridMultiSelecao = super.getAcoesGridMultiSelecao();
        acoesGridMultiSelecao.add(this.botaoRemoverJogador);
        return acoesGridMultiSelecao;
    }
    
    @Override
    public JTable getTable() {
        return this.table; 
   }

    @Override
    public JButton getBotaoConsultar() {
        return this.botaoConsultar;
    }

    @Override
    protected Jogador getInstanceModel() {
        return new Jogador();
    }

    @Override
    protected String getTitulo() {
        return "Consulta de Jogadores";
    }

    public JButton getBotaoRelacionarJogador() {
        return botaoRelacionarJogador;
    }

    public JButton getBotaoRemoverJogador() {
        return botaoRemoverJogador;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro() {
        return campoValorFiltro;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro2() {
        return campoValorFiltro2;
    }

    @Override
    public JComboBox<CampoFiltro> getListaCampo() {
        return listaCampo;
    }

    @Override
    public JComboBox<OperadorFiltro> getListaOperador() {
        return listaOperador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoRelacionarJogador;
    private javax.swing.JButton botaoRemoverJogador;
    private javax.swing.JFormattedTextField campoValorFiltro;
    private javax.swing.JFormattedTextField campoValorFiltro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<CampoFiltro> listaCampo;
    private javax.swing.JComboBox<OperadorFiltro> listaOperador;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
