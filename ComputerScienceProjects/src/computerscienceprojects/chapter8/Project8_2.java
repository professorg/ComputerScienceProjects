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
            
            scanner.nextLine();
            
            if(d >= 0 && iter > 0) {
                
                double num = d;
                double guess = d;
                
                System.out.printf("%12s%30s%n", "Iteration", "Guess");
                
                for (int i = 1; i <= iter; i++) {
                    
                    guess = (guess + num / guess) / 2;
                    
                    System.out.printf("%12d%30.16f%n", i, guess);
                }
                
                System.out.printf("%nThe square root of %.1f is %.16f%n",
                        num, guess);
                
            } else if(d < 0) {
                
                System.out.println("Cannot compute the root of a negative"
                        + " number");
            } else {
                
                System.out.println("Number of iterations must be positive");
            }
            
            System.out.print("\nDo it again (y/n)? ");
            if(scanner.nextLine().equalsIgnoreCase("n")) {
                
                break;
            }
        }
    }
    /*
    run:
    Enter the number: -10
    Enter the number of iterations: 25
    Cannot compute the root of a negative number

    Do it again (y/n)? y
    Enter the number: 37
    Enter the number of iterations: 0
    Number of iterations must be positive

    Do it again (y/n)? y
    Enter the number: 74
    Enter the number of iterations: 20
       Iteration                         Guess
               1           37.5000000000000000
               2           19.7366666666666680
               3           11.7430166638518280
               4            9.0223171112318280
               5            8.6121006466380660
               6            8.6023308149368130
               7            8.6023252670444150
               8            8.6023252670426270
               9            8.6023252670426270
              10            8.6023252670426270
              11            8.6023252670426270
              12            8.6023252670426270
              13            8.6023252670426270
              14            8.6023252670426270
              15            8.6023252670426270
              16            8.6023252670426270
              17            8.6023252670426270
              18            8.6023252670426270
              19            8.6023252670426270
              20            8.6023252670426270

    The square root of 74.0 is 8.6023252670426270

    Do it again (y/n)? n
    */
}
