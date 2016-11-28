package computerscienceprojects.chapter7.project11;

import computerscienceprojects.chapter7.project10.Circle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {

    private Circle circle1;
    private Circle circle2;
    private javax.swing.Timer timer;
    private boolean moving = true;

    public CirclePanel(Color backColor, int width, int height) {
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height));
        // Circle with center point (25, 100) and radius 25
        circle1 = new Circle(25, height / 2, 25, Color.red);
        circle2 = new Circle(width - 25, height / 2, 25, Color.red);
        circle1.setDirection(180);
        circle2.setDirection(0);
        // Move 6 pixels per second with 30 frames/second
        circle1.setSpeed(6);
        circle2.setSpeed(6);
        // Move every 33 milliseconds 
        timer = new javax.swing.Timer(33, new MoveListener());
        addMouseListener(new MouseListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle1.fill(g);
        circle2.fill(g);
    }

    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!moving) {
                return;
            }
            int x = circle1.getX();             // New method in class Circle
            int radius = circle1.getRadius();   // New method in class Circle
            int width = getWidth();
            // Check for boundaries and reverse direction
            // if necessary
            if (x - radius <= 0 || x + radius >= width) {
                circle1.turn(180);
            }
            circle1.move();
            x = circle2.getX();             // New method in class Circle
            radius = circle2.getRadius();   // New method in class Circle
            // Check for boundaries and reverse direction
            // if necessary
            if (x - radius <= 0 || x + radius >= width) {
                circle2.turn(180);
            }
            circle2.move();
            repaint();
        }
    }

    private class MouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            moving = !moving;
        }
    }
}
