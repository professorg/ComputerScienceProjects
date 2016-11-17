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
            
            s += "F";
        } else if(grade < 70) {
            
            s += "D";
            if(grade < 62) s+= "-";
            if(grade > 65) s+= "+";
        } else if(grade < 80) {
            
            s += "C";
            if(grade < 72) s+= "-";
            if(grade > 75) s+= "+";
        } else if(grade < 90) {
            
            s += "B";
            if(grade < 82) s+= "-";
            if(grade > 85) s+= "+";
        } else {
            
            s += "A";
            if(grade < 92) s+= "-";
            if(grade > 95) s+= "+";
        }
        
        System.out.println("You have a(n) " + s + " in the class");
    }
    /*
    run:
    Enter your grade percent (0-100) in the class: 50
    You have a(n) F in the class
    
    run:
    Enter your grade percent (0-100) in the class: 71
    You have a(n) C- in the class
    
    run:
    Enter your grade percent (0-100) in the class: 99
    You have a(n) A+ in the class
    */
}
