package view;

import java.awt.ComponentOrientation;
import javax.swing.JMenuItem;
import model.Model;

/**
 *
 * @author ruang
 */
public class ViewMain extends View<Model> {

    public ViewMain() {
        super();
        initComponents();
    }

    @Override
    protected String getTitulo() {
        return "o Rei do Bolão";
    }

    public JMenuItem getMenuItemConfiguracoes() {
        return menuItemConfiguracoes;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        menuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuOpcoes = new javax.swing.JMenu();
        menuItemConfiguracoes = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("Cadastros");
        menuBar.add(jMenu2);

        menuOpcoes.setText("Opções");

        menuItemConfiguracoes.setText("Configurações");
        menuItemConfiguracoes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menuOpcoes.add(menuItemConfiguracoes);

        menuBar.add(menuOpcoes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemConfiguracoes;
    private javax.swing.JMenu menuOpcoes;
    // End of variables declaration//GEN-END:variables

    @Override
    protected Model getInstanceModel() {
        return null;
    }
    
}
