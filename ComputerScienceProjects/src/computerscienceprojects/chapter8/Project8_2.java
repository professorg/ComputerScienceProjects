/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter8;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project8_2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            
            System.out.print("Enter the number: ");
            double d = scanner.nextDouble();
            System.out.print("Enter the number of iterations: ");
            int iter = scanner.nextInt();
            
            if(d >= 0 && iter > 0) {
                
                
            
                System.out.printf("%12%30%n", "Iteration", "Guess");
                double num = d;
                double guess = d;
                
                for (int i = 1; i < iter; i++) {
                    
                    
                }
            } else if(d < 0) {
                
                System.out.println("Cannot compute the root of a negative"
                        + "number");
            } else {
                
                System.out.println("Number of iterations must be positive");
            }
            
            System.out.print("\nDo it again (y/n)? ");
            if(scanner.nextLine().equalsIgnoreCase("n")) {
                
                break;
            }
        }
    }
}
