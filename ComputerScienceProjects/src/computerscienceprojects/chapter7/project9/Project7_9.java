/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project9;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gvandomelen19
 */
public class Project7_9 {
    
    public static final String PATH = Paths.get(".").toAbsolutePath()
            .normalize().toString()
            + "\\computerscienceprojects\\chapter7\\project9";
    
    public static void main(String[] args) {
        
        Scanner scanner;
        
        try {
            
            scanner = new Scanner(new File(PATH + "\\text.txt"));
        } catch (FileNotFoundException ex) {
            
            System.out.println("File not found.");
            System.exit(0);
        }
        
        
    }
}
