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
        addMouseListener(new MouseListener());
        // Circle centered in the panel with radius 25
        circle = new Circle(width / 2, height / 2, 25, Color.red);
        // Move 50 pixels per timer event
        circle.setSpeed(6);
        // Fire timer events every 1/8 second
        timer = new javax.swing.Timer(33, new MoveListener());
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle.fill(g);
    }

    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!moving) return;
            circle.move();
            circle.turn(2);   // Turn 2 degrees
            repaint();
        }
    }

    private class MouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            moving = !moving;
        }
    }
}
