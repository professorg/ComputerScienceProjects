/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3.project7;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author gvandomelen19
 */
public class Project3_7 {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Center Coords");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CoordPanel panel = new CoordPanel();
        Container pane = frame.getContentPane();
        
        pane.add(panel);
        
        frame.setVisible(true);
        
    }
}
