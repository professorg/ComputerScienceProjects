/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class Project2_6c {

    public static void main(String[] args) {

        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 2-6");
        theGUI.setSize(300, 200);
        theGUI.setLocationRelativeTo(null);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Bulgaria
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0x009900));
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.RED);
        
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(3, 1));
        
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        
        theGUI.setVisible(true);
        
        
    }

}
