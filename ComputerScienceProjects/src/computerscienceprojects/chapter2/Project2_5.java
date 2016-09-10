/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter2;

import java.util.Scanner;

/**
 *
 * @author grant
 */
public class Project2_5 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double mass = 0;
        double velocity = 0;
        mass:{
            
            while(true){
                
                System.out.print("Enter the objects mass (in kilograms) as a double: ");
                try{
                    
                    mass = scanner.nextDouble();
                    break mass;
                } catch (Exception e){
                    
                    System.out.println("Incorrect input type.");
                    scanner.next();
                }
            }
        }
        vel:{
            
            while(true){
                
                System.out.print("Enter the objects velocity (in meters per second) as a double: ");
                try{
                    
                    velocity = scanner.nextDouble();
                    break vel;
                } catch (Exception e){
                    
                    System.out.println("Incorrect input type.");
                    scanner.next();
                }
            }
        }
        System.out.println("The objects momentum is " + calculateMomentum(mass, velocity) + " kilogram meters per second.");
    }
    
    public static double calculateMomentum(double mass, double velocity){
        
        return mass * velocity;
    }
    
    /*
     run-single:
     Enter the objects mass (in kilograms) as a double: 45
     Enter the objects velocity (in meters per second) as a double: 4.6
     The objects momentum is 206.99999999999997 kilogram meters per second.
     BUILD SUCCESSFUL (total time: 11 seconds)
     */
}
