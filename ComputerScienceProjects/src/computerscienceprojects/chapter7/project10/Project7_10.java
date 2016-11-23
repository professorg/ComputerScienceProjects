package computerscienceprojects.chapter7.project10;

// A frame with an empty panel

import javax.swing.*;
import java.awt.*;

public class Project7_10{

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