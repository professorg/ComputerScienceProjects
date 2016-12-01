/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter8;

import java.util.Scanner;

/**
 *
 * @author GVandomelen19
 */
public class Project8_3 {
    
    public static final double MAX_AMOUNT = 10000;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the initial investment: $");
        double amt = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        System.out.print("Enter the annual interest rate [%]: ");
        double interest = scanner.nextDouble();
        
        if(amt < 0 || amt > MAX_AMOUNT) {
            
            
        }        
    }
}
