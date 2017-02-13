/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage img;
    
    public ImagePanel(BufferedImage img) {
        
        this.img = img;
    }
    
    public ImagePanel() {
        
        this.img = new BufferedImage(256, 256, TYPE_INT_RGB);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
    
    public BufferedImage getImage() {
        
        return this.img;
    }
    
}
