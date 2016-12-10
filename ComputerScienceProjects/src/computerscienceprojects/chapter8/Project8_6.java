/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author gvandomelen19
 */
public class Project8_6 {
    
    public static void main(String[] args) {
        
        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI Program");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = theGUI.getContentPane();
        pane.setLayout(new FlowLayout());
        
        JPanel outputPanel = new JPanel(new GridLayout(3, 2));
        
        JLabel areaLabel = new JLabel("Area:");
        outputPanel.add(areaLabel);
        JLabel areaOut = new JLabel();
        outputPanel.add(areaOut);
        
        JLabel surfaceAreaLabel = new JLabel("Surface Area:");
        outputPanel.add(surfaceAreaLabel);
        JLabel surfaceAreaOut = new JLabel();
        outputPanel.add(surfaceAreaOut);
        
        JLabel volumeLabel = new JLabel("Volume:");
        outputPanel.add(volumeLabel);
        JLabel volumeOut = new JLabel();
        outputPanel.add(volumeOut);
        
        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        
        JLabel radiusLabel = new JLabel("Radius");
        inputPanel.add(radiusLabel);
        JTextArea radiusArea = new JTextArea();
        inputPanel.add(radiusArea);
        JButton button = new JButton("Calculate");
        inputPanel.add(button);
        
        // lambda replaces actionPerformed
        button.addActionListener((ActionEvent e) -> {
            // Calculations
            try {
                
                double radius = Double.parseDouble(radiusArea.getText());
                double area = Math.PI * radius * radius;
                double surfaceArea = 4 * Math.PI * radius * radius;
                double volume = 4.0/3.0 * Math.PI * Math.pow(radius, 3);
                
                areaOut.setText(area + "");
                surfaceAreaOut.setText(surfaceArea + "");
                volumeOut.setText(volume + "");
                theGUI.pack();
            } catch (NumberFormatException nfe) {
                
                areaOut.setText("Invalid input");
                surfaceAreaOut.setText("Invalid input");
                volumeOut.setText("Invalid input");
            }
        });
        
        pane.add(inputPanel, BorderLayout.CENTER);
        pane.add(outputPanel, BorderLayout.CENTER);
        
        theGUI.pack();
        
        theGUI.setResizable(false);
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);
    }
}
