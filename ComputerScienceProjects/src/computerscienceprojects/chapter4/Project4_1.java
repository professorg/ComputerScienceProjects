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
public class Project4_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = scanner.nextInt();
        System.out.print("Enter a second integer: ");
        int y = scanner.nextInt();

        if (x > y && y != 0) {
            if (y == 0) {
                System.out.println("Quotient is undefined");
            }
            System.out.println("Quotient: " + x / y + "r" + x % y);
        } else {
            if (x == 0) {
                System.out.println("Quotient is undefined");
            }
            System.out.println("Quotient: " + y / x + "r" + y % x);
        }
    }
    /*
    run:
    Enter an integer: 4
    Enter a second integer: 10
    Quotient: 2r2
    BUILD SUCCESSFUL (total time: 3 seconds)
    
    run:
    Enter an integer: 10
    Enter a second integer: 4
    Quotient: 2r2
    BUILD SUCCESSFUL (total time: 4 seconds)

    run:
    Enter an integer: 5
    Enter a second integer: 5
    Quotient: 1r0
    BUILD SUCCESSFUL (total time: 2 seconds)

     */
}
