/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4.project13;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class ContrastPanel extends JPanel {
    
    public static void main(String[] args) {

        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI Example");
        theGUI.setSize(600, 400);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(1,2));
        
        pane.add(new ContrastPanel(Color.BLACK));
        pane.add(new ContrastPanel(Color.WHITE));
        
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);
    }
    
    public ContrastPanel(Color c) {
        
        setBackground(c);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        int width = getWidth();
        int height = getHeight();
        g.fillRect(width / 3, height / 3, width / 3, height / 3);
    }
}
