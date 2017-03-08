/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.raycast;

import java.awt.image.BufferedImage;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class FrameBufferTest {
    
    public static void main(String[] args) {
        
        BufferedImage img = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        ImagePanel panel = new ImagePanel(img);
        
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        
        int x = 0;
        int y = 0;
        int col = 0;
        while(true) {
            
            long stop = System.nanoTime() + 1000000 / 6000;
            
            img.setRGB(x, y, col);
            
            x++;
            if (x >= 600) {
                x = 0;
                y++;
            }
            if (y >= 400) y = 0;
            col++;
            col %= 16777216;    // Magic Number -- 256^3
            panel.repaint();
            while (System.nanoTime() < stop);
        }
    }
}
