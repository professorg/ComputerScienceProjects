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
public class Project3_2 {

    public static void main(String[] args) {
        
        Scanner numScanner = new Scanner(System.in);
        double radius;
        radius:
        {
            
            while (true) {

                System.out.print("Enter the radius of the sphere as a double: ");
                try{
                    
                    radius = numScanner.nextDouble();
                    break radius;
                } catch (Exception e) {
                    
                    System.out.println("Incorrect input type.");
                    numScanner.nextLine();
                }
            }
        }
        
        System.out.println("Diameter: " + radius * 2);
        System.out.println("Circumference: " + radius * 2 * Math.PI);
        System.out.println("Surface Area: " + radius * radius * 4 * Math.PI);
        System.out.println("Volume: " + radius * radius * Math.PI);
    }
    /*
    run:
    Enter the radius of the sphere as a double: 2.0
    Diameter: 4.0
    Circumference: 12.566370614359172
    Surface Area: 50.26548245743669
    Volume: 12.566370614359172
    BUILD SUCCESSFUL (total time: 6 seconds)
     */
}