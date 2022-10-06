package view.grid;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import model.Jogador;
import util.CampoFiltro;
import util.OperadorFiltro;

/**
 *
 * @author ruan
 */
public class ViewGridJogador extends ViewGrid<Jogador> {

    public ViewGridJogador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoInserir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listaCampo = new javax.swing.JComboBox<>();
        listaOperador = new javax.swing.JComboBox<>();
        campoValorFiltro = new javax.swing.JFormattedTextField();
        campoValorFiltro2 = new javax.swing.JFormattedTextField();
        botaoConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botaoInserir.setText("Inserir");

        botaoAlterar.setText("Alterar");

        botaoExcluir.setText("Excluir");

        botaoVisualizar.setText("Visualizar");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaCampo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVisualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaOperador, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(botaoConsultar)
                        .addContainerGap())))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoVisualizar))
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
        botoes.add(this.botaoAlterar);
        botoes.add(this.botaoExcluir);
        botoes.add(this.botaoVisualizar);
        return botoes;
    }

    @Override
    public ArrayList<JButton> getAcoesGridMultiSelecao() {
        ArrayList<JButton> acoesGridMultiSelecao = super.getAcoesGridMultiSelecao();
        acoesGridMultiSelecao.add(this.botaoExcluir);
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

    public JButton getBotaoAlterar() {
        return botaoAlterar;
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public JButton getBotaoInserir() {
        return botaoInserir;
    }

    public JButton getBotaoVisualizar() {
        return botaoVisualizar;
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
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JFormattedTextField campoValorFiltro;
    private javax.swing.JFormattedTextField campoValorFiltro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<CampoFiltro> listaCampo;
    private javax.swing.JComboBox<OperadorFiltro> listaOperador;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
