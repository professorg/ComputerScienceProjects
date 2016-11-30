/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project9;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author gvandomelen19
 */
public class ClickableColorPanel extends JPanel {
    
    public ClickableColorPanel(Color c) {
        
        setBackground(c);
        addMouseListener(new PanelListener());
    }
    
    private class PanelListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            
            Random r = new Random();
            setBackground(new Color(r.nextInt(255),
                    r.nextInt(255),
                    r.nextInt(255)));
        }
    }
    
    /*
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
    */
    
}
