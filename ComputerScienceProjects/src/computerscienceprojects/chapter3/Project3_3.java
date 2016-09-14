/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter3;

import java.util.Scanner;

/**
 *
 * @author grant
 */
public class Project3_3 {
    
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
                    scanner.nextLine();
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
        System.out.println("The objects momentum is " + calculateKineticEnergy(mass, velocity) + " Newtons.");
    }
    
    public static double calculateKineticEnergy(double mass, double velocity){
        
        return 0.5 * mass * velocity * velocity;
    }
    
    /*
    run:
    Enter the objects mass (in kilograms) as a double: 5.0
    Enter the objects velocity (in meters per second) as a double: 1.5
    The objects momentum is 5.625 Newtons.
    BUILD SUCCESSFUL (total time: 7 seconds)
     */
}
