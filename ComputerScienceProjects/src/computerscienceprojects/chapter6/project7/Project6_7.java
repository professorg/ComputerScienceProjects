/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project7;

import computerscienceprojects.chapter6.project8.RectPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gvandomelen19
 */
public class Project6_7 {
    
    public static void main(String[] args) {
        
        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI Program");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int n = Integer.parseInt(JOptionPane.showInputDialog(theGUI, "How many"
                + "panels do you want? 1, 2, or 4", JOptionPane.PLAIN_MESSAGE));
        
        GridLayout gl = null;
        
        if(n == 1 || n == 2) {
            gl = new GridLayout(1,n);
        } else if(n == 4){
            gl = new GridLayout(2,2);
        } else {    
            System.out.println("You must enter 1, 2, or 4.");
            System.exit(1);
        }
        
        theGUI.setLayout(gl);
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 1; i <= n; i++) {
            
            String s = JOptionPane.showInputDialog(theGUI, "Enter path for"
                    + " image " + i + ":", JOptionPane.PLAIN_MESSAGE);
            theGUI.add(new ImagePanel(Color.BLACK, s));
        }
        
        theGUI.pack();
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);
    }
    /*
    ImagePanel.java:
    
        package computerscienceprojects.chapter6.project7;

        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Graphics;
        import javax.swing.ImageIcon;
        import javax.swing.JPanel;

        public class ImagePanel extends JPanel {

            private ImageIcon image;

            public ImagePanel(Color c, String s) {

                setBackground(c);
                image = new ImageIcon(s);
                setPreferredSize(new Dimension(image.getIconWidth() * 2, image.getIconHeight() * 2));
            }

            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                int x = (getWidth() - image.getIconWidth()) / 2;
                int y = (getHeight() - image.getIconHeight()) / 2;
                image.paintIcon(this, g, x, y);
            }
        }

    */
}
