/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.raycast;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage img;
    
    public ImagePanel(BufferedImage img) {
        
        this.img = img;
        this.setSize(img.getWidth(), img.getHeight());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
