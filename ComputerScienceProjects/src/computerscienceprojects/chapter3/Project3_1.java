/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project3_1 {

    public static void main(String[] args) {
        
        Scanner numScanner = new Scanner(System.in);
        int length;
        length:
        {
            
            while (true) {

                System.out.print("Enter the length of the cube's edge as an int: ");
                try{
                    
                    length = numScanner.nextInt();
                    break length;
                } catch (Exception e) {
                    
                    System.out.println("Incorrect input type.");
                    numScanner.nextLine();
                }
            }
        }
        
        System.out.println("Surface Area: " + (length * length) * 6);
    }
    /*
    run:
    Enter the length of the cube's edge as an int: 5
    Surface Area: 150
    BUILD SUCCESSFUL (total time: 3 seconds)
     */
}