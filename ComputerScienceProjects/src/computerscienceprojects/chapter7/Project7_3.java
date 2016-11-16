/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project7_3 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int grade = -1;
        
        while(grade < 0 || grade > 100) {
            
            System.out.print("Enter your grade percent (0-100) in the class: ");
            
            try {
                
                grade = scanner.nextInt();
            } catch (Exception e) {
                
                System.out.println("Invalid percent...");
                grade = -1;
            }
        }
        
        String s = "";
        
        if(grade < 60) {
            
            
        }
        else if(grade < 62) {
            
            
        }
    }
}
