/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project4_2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a triangle side length: ");
        double a = scanner.nextDouble();
        System.out.print("Enter a triangle side length: ");
        double b = scanner.nextDouble();
        System.out.print("Enter a triangle side length: ");
        double c = scanner.nextDouble();
        
        int largest;
        
        if(a > b) {
            
            if(a > c) {
                
                largest = 0;
            } else {
                
                largest = 2;
            }
        } else {
            
            if(b > c) {
                
                largest = 1;
            } else {
                
                largest = 2;
            }
        }
        
        if(largest == 0) {
            
            System.out.println("The triangle is " 
                    + ((a * a - (b * b + c * c) < 0.000001) ? "":"not") 
                    + " a right triangle.");
        } else if(largest == 1) {
            
            System.out.println("The triangle is " 
                    + ((b * b - (a * a + c * c) < 0.000001) ? "":"not") 
                    + " a right triangle.");
        } else {
            
            System.out.println("The triangle is " 
                    + ((c * c - (a * a + b * b) < 0.000001) ? "":"not ") 
                    + "a right triangle.");
        }
    }
    /*
    run:
    Enter a triangle side length: 3
    Enter a triangle side length: 4
    Enter a triangle side length: 5
    The triangle is a right triangle.
    BUILD SUCCESSFUL (total time: 9 seconds)
    
    run:
    Enter a triangle side length: 3
    Enter a triangle side length: 4
    Enter a triangle side length: 6
    The triangle is not a right triangle.
    BUILD SUCCESSFUL (total time: 7 seconds)
    
    run:
    Enter a triangle side length: 1.5
    Enter a triangle side length: 5.2
    Enter a triangle side length: 2.2
    The triangle is not a right triangle.
    BUILD SUCCESSFUL (total time: 10 seconds)
    
    run:
    Enter a triangle side length: 1.5
    Enter a triangle side length: 2
    Enter a triangle side length: 2.5
    The triangle is a right triangle.
    BUILD SUCCESSFUL (total time: 8 seconds)
     */
}
