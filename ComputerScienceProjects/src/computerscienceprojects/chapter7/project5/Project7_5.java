/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project5;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project7_5 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the first integer: ");
        int n1 = scanner.nextInt();
        System.out.print("Please enter the second integer: ");
        int n2 = scanner.nextInt();
        
        
        System.out.println("GCD(" + n1 + ", " + n2 + ") = " + findGCD(n1, n2));
    }
    
    private static int findGCD(int n1, int n2) {
        
        while(!(n2 == 0)) {
            
            if(n1 < n2) {
                
                int tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        
        return n1;
    }
    
    /*
    run:
    Please enter the first integer: 36
    Please enter the second integer: 104
    GCD(36, 104) = GCD(104, 36)
    104%36 = 32, so 
    GCD(104, 36) = GCD(36, 32)
    36%32 = 4, so 
    GCD(36, 32) = GCD(32, 4)
    32%4 = 0, so 
    GCD(32, 4) = GCD(4, 0)
    GCD(36, 104) = 4
    */
    
}
