/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class ImagePanel extends JPanel {

    private ImageIcon image;

    public ImagePanel(Color c, String s) {
        
        setBackground(c);
        image = new ImageIcon(s);
        setPreferredSize(new Dimension(image.getIconWidth() * 2, image.getIconHeight() * 2));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int x = (getWidth() - image.getIconWidth()) / 2;
        int y = (getHeight() - image.getIconHeight()) / 2;
        image.paintIcon(this, g, x, y);
    }
}
