package computerscienceprojects.chapter6.project8;

// Example 6.5: Displays a circle and a filled circle
// Allows the user to drag a circle to another position
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectPanel extends JPanel {

    private Rectangle r1, r2;
    private Rectangle selRect;

    private int x, y;               // Used to track mouse coordinates  

    public RectPanel(Color backColor) {
        setBackground(backColor);
        r1 = new Rectangle(200, 100, 50, 100, Color.red);
        r2 = new Rectangle(100, 100, 100, 250, Color.blue);
        selRect = null;
        addMouseListener(new PanelListener());
        addMouseMotionListener(new PanelMotionListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        r1.fill(g);
        r2.draw(g);
    }

    private class PanelListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            if (r1.containsPoint(x, y)) {
                selRect = r1;
            } else if (r2.containsPoint(x, y)) {
                selRect = r2;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            selRect = null;
        }
    }

    private class PanelMotionListener extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selRect != null) {
                // Compute the distance and move the selected circle
                int newX = e.getX();
                int newY = e.getY();
                int dx = newX - x;
                int dy = newY - y;
                selRect.move(dx, dy);
                x = newX;
                y = newY;
                repaint();
            }
        }
    }
}
