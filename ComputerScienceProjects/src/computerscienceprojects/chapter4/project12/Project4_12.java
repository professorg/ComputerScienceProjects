/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4.project12;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gvandomelen19
 */
public class Project4_12 {

    public static void main(String[] args) {

        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI Example");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setResizable(false);
        Container pane = theGUI.getContentPane();
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows", null));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns", null));
        int width = 50;
        int height = 50;
        pane.setLayout(new GridLayout(rows,cols));
        Color color = Color.BLACK;
        
        for (int x = 0; x < rows; x++) {
            
            for (int y = 0; y < cols; y++) {
                
                if (color == Color.BLACK)
                    color = Color.WHITE;
                else
                    color = Color.BLACK;
                
                pane.add(new ColorPanel(color, width, height));
            }
            if(rows % 2 == 0) {
                if (color == Color.BLACK)
                    color = Color.WHITE;
                else
                    color = Color.BLACK;
            }
        }
        
        theGUI.pack();
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);
    }
}
