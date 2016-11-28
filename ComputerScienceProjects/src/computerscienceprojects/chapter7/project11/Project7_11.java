package computerscienceprojects.chapter7.project11;

// A frame with an empty panel

import computerscienceprojects.chapter7.project10.CirclePanel;
import javax.swing.*;
import java.awt.*;

public class Project7_11 {

   public static void main(String[] args){
      JFrame theGUI = new JFrame();
      theGUI.setTitle("GUI Program");
      //theGUI.setSize(300, 200);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      CirclePanel panel = new CirclePanel(Color.white, 600, 400);
      Container pane = theGUI.getContentPane();
      pane.add(panel);
      theGUI.pack();
      theGUI.setVisible(true);
   }
}