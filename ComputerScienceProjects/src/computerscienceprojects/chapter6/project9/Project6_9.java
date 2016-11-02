/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project9;

import computerscienceprojects.chapter6.project8.RectPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gvandomelen19
 */
public class Project6_9 {
    
    public static void main(String[] args) {
        
        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI Program");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        theGUI.setSize(screenSize);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        
        int rows = Integer.parseInt(JOptionPane.showInputDialog(theGUI, 
                "Enter the number of rows:", JOptionPane.PLAIN_MESSAGE));
        int cols = Integer.parseInt(JOptionPane.showInputDialog(theGUI, 
                "Enter the number of columns:", JOptionPane.PLAIN_MESSAGE));
        
        pane.setLayout(new GridLayout(cols, rows));
        
        for (int i = 0; i < rows*cols; i++) {
            
            pane.add(new ClickableColorPanel(Color.WHITE));
        }
        
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);
    }
}
