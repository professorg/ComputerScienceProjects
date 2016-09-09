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
public class Project2_7 {
    
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 2-6a");
        theGUI.setSize(300, 300);
        theGUI.setLocationRelativeTo(null);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //France
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.WHITE);
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.BLACK);
        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.WHITE);
        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.BLACK);
        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.WHITE);
        JPanel panel9 = new JPanel();
        panel9.setBackground(Color.BLACK);
        
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        pane.add(panel4);
        pane.add(panel5);
        pane.add(panel6);
        pane.add(panel7);
        pane.add(panel8);
        pane.add(panel9);
        
        theGUI.setVisible(true);
    }
}
