package util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

/**
 * 
 * @author ruang
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;
    private Shape shape = null;
    private Point startDrag, endDrag;
    private JLabel selectedArea;
    private EventListenerList afterMousePressedListner = new EventListenerList();
    
    public ImagePanel() {
        ImagePanel self = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (isEditMode()) {
                    endDrag = startDrag = new Point(event.getX(), event.getY());
                    for (Object actionListener : afterMousePressedListner.getListenerList()) {
                        if (actionListener instanceof ActionListener) {
                            ((ActionListener) actionListener).actionPerformed(new ActionEvent(self, 0, null));
                        }
                    }
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                if (isEditMode()) {
                    if (endDrag != null && startDrag != null) {
                        try {
                            shape = makeRectangle(startDrag.x, startDrag.y, event.getX(), event.getY());
                            
                            if (event.getX() - startDrag.x != 0 && event.getY() - startDrag.y != 0) {
                                if (event.getX() <= image.getWidth() && event.getY() < image.getHeight()) {
                                    int x = Math.min((int) startDrag.getX(), event.getX());
                                    int y = Math.min((int) startDrag.getY(), event.getY());
                                    int w = Math.abs((int) startDrag.getX() - event.getX());
                                    int h = Math.abs((int) startDrag.getY() - event.getY());
                                    updateSelectedRegion(image.getSubimage(x, y, w, h));
                                }
                            }
                            
                            startDrag = null;
                            endDrag = null;
                            unsetSelectedAreaPanel();
                            
                            repaint();
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if (isEditMode()) {
                    endDrag = new Point(event.getX(), event.getY());
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

        if (shape != null) {
            g2.setPaint(Color.BLACK);
            g2.draw(shape);
            g2.setPaint(Color.LIGHT_GRAY);
            g2.fill(shape);
        }

        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.LIGHT_GRAY);
            Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
            g2.draw(r);
        }
    }

    private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public void updateSelectedRegion(BufferedImage bufferedImage) {
        this.selectedArea.setIcon(new ImageIcon(bufferedImage));
    }

    public void setSelectedAreaPanel(JLabel selectedArea) {
        if (this.selectedArea != null) this.unsetSelectedAreaPanel();
        this.selectedArea = selectedArea;
        this.selectedArea.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 3));
    }

    private void unsetSelectedAreaPanel() {
        this.selectedArea.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.selectedArea = null;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Point getStartDrag() {
        return startDrag;
    }

    public JLabel getSelectedArea() {
        return selectedArea;
    }

    public void addAfterMousePressedListner(ActionListener actionListener) {
        this.afterMousePressedListner.add(ActionListener.class, actionListener);
    }
    
    private boolean isEditMode() {
        return this.selectedArea != null;
    }
    
}
