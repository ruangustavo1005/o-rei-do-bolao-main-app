package util;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;

public class TelaBloqueio extends JPanel {

    private JLabel mensagem;

    public TelaBloqueio() {
        this("Carregando...");
    }
    
    public TelaBloqueio(String texto) {
        this.setLayout(null);
        this.setBackground(new Color(0, 0, 0, 128)); // Define a cor de fundo com transparência
        this.setOpaque(false); // Torna o componente transparente para o mouse
        this.mensagem = new JLabel(texto);
        this.mensagem.setForeground(Color.WHITE);
        this.mensagem.setHorizontalAlignment(JLabel.CENTER);
        this.mensagem.setVerticalAlignment(JLabel.CENTER);
        this.add(this.mensagem);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha um retângulo preenchido com transparência em cima do componente
        g.setColor(new Color(0, 0, 0, 128));
        g.fillRect(0, 0, getWidth(), getHeight());
        this.mensagem.setBounds(0, 0, getWidth(), getHeight());
    }

    public static void bloquearTela(JFrame parent, String texto) {
        JLayer<TelaBloqueio> layer = new JLayer<>(new TelaBloqueio(texto));
        layer.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        layer.setOpaque(false);
        layer.setLayerEventMask(AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_WHEEL_EVENT_MASK);
        JComponent glassPane = (JComponent) parent.getGlassPane();
        glassPane.setLayout(null);
        glassPane.add(layer);
        glassPane.setVisible(true);
    }

    public static void desbloquearTela(JFrame parent) {
        JComponent glassPane = (JComponent) parent.getGlassPane();
        glassPane.setVisible(false);
        glassPane.removeAll();
        glassPane.revalidate();
        glassPane.repaint();
    }
}
