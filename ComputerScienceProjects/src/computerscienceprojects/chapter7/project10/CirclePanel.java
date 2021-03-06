package computerscienceprojects.chapter7.project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {

    private Circle circle;
    private javax.swing.Timer timer;
    private boolean moving = true;

    public CirclePanel(Color backColor, int width, int height) {
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height));
        // Circle with center point (25, 100) and radius 25
        circle = new Circle(25, height / 2, 25, Color.red);
        circle.setDirection(180);
        // Move 6 pixels per second with 30 frames/second
        circle.setSpeed(6);
        // Move every 33 milliseconds 
        timer = new javax.swing.Timer(33, new MoveListener());
        addMouseListener(new MouseListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle.fill(g);
    }

    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!moving) {
                return;
            }
            int x = circle.getX();             // New method in class Circle
            int radius = circle.getRadius();   // New method in class Circle
            int width = getWidth();
            // Check for boundaries and reverse direction
            // if necessary
            if (x - radius <= 0 || x + radius >= width) {
                circle.turn(180);
            }
            circle.move();
            repaint();
        }
    }

    private class MouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            moving = !moving;
        }
    }
}
