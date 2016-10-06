/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4.project13;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class Project4_13 {

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
}
