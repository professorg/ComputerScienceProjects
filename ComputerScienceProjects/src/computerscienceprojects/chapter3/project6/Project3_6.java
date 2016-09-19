/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3.project6;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author gvandomelen19
 */
public class Project3_6 {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Muller-Lyer");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MullerPanel panel = new MullerPanel();
        Container pane = frame.getContentPane();
        
        pane.add(panel);
        
        frame.setVisible(true);
        
    }
}
