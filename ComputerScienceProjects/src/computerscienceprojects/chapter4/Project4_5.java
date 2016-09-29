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
public class Project4_5 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of iterations (integer): ");
        int no = scanner.nextInt();
        double pi = 0;
        
        for (int i = 0; i < no; i++) {
            
            pi += (Math.pow(-1, i) / (2*i + 1));
        }
        pi *= 4;
        
        System.out.println("Pi after " + no + " iterations: " + pi);
    }
    
    /*
    run:
    Enter the number of iterations (integer): 1
    Pi after 1 iterations: 4.0
    BUILD SUCCESSFUL (total time: 1 second)
    
    run:
    Enter the number of iterations (integer): 2
    Pi after 2 iterations: 2.666666666666667
    BUILD SUCCESSFUL (total time: 1 second)
    
    run:
    Enter the number of iterations (integer): 3
    Pi after 3 iterations: 3.466666666666667
    BUILD SUCCESSFUL (total time: 1 second)
    
    run:
    Enter the number of iterations (integer): 1000
    Pi after 1000 iterations: 3.140592653839794
    BUILD SUCCESSFUL (total time: 1 second)
    */
}
