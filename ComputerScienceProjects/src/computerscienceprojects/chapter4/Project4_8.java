/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4;

import java.util.Scanner;

/**
 *
 * @author grant
 */
public class Project4_8 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base as an integer: ");
        int base = scanner.nextInt();
        System.out.print("Enter an exponent as an integer: ");
        int exp = scanner.nextInt();
        System.out.println(base + "^" + exp + " = " + pow(base, exp));
    }
    
    public static double pow(double base, int exp) {
        
        if(exp < 0) return 1/pow(base, -exp);
        double out = 1;
        for (int i = 0; i < exp; i++) {
            
            out *= base;
        }
        return out;
    }
    /*
    run:
    Enter the base as an integer: 2
    Enter an exponent as an integer: 6
    2^6 = 64.0
    BUILD SUCCESSFUL (total time: 9 seconds)
    
    run:
    Enter the base as an integer: 10
    Enter an exponent as an integer: 3
    10^3 = 1000.0
    BUILD SUCCESSFUL (total time: 4 seconds)
    */
}
