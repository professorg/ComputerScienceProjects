/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3.project6;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class MullerPanel extends JPanel {
    
    public MullerPanel(){
        
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(getWidth() / 2 - 100, getHeight() / 3, getWidth() / 2 + 100, getHeight() / 3);
        g.drawLine(getWidth() / 2 - 100, 2 * getHeight() / 3, getWidth() / 2 + 100, 2 * getHeight() / 3);
        g.drawLine(getWidth() / 2 - 80, getHeight() / 3 - 20, getWidth() / 2 - 100, getHeight() / 3);
        g.drawLine(getWidth() / 2 - 80, getHeight() / 3 + 20, getWidth() / 2 - 100, getHeight() / 3);
        g.drawLine(getWidth() / 2 + 80, getHeight() / 3 - 20, getWidth() / 2 + 100, getHeight() / 3);
        g.drawLine(getWidth() / 2 + 80, getHeight() / 3 + 20, getWidth() / 2 + 100, getHeight() / 3);
        g.drawLine(getWidth() / 2 - 120, 2 * getHeight() / 3 - 20, getWidth() / 2 - 100, 2 * getHeight() / 3);
        g.drawLine(getWidth() / 2 - 120, 2 * getHeight() / 3 + 20, getWidth() / 2 - 100, 2 * getHeight() / 3);
        g.drawLine(getWidth() / 2 + 120, 2 * getHeight() / 3 - 20, getWidth() / 2 + 100, 2 * getHeight() / 3);
        g.drawLine(getWidth() / 2 + 120, 2 * getHeight() / 3 + 20, getWidth() / 2 + 100, 2 * getHeight() / 3);
    }
}
