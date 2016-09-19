/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3.project7;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author gvandomelen19
 */
public class CoordPanel extends JPanel {
    
    public CoordPanel() {
        
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.setColor(Color.GRAY);
        g.drawString("(" + x + ", " + y / 2 + ")", x + 5 , y - 5);
        g.drawLine(x - 5, y, x + 5, y);
        g.drawLine(x, y - 5, x, y + 5);
    }
}
