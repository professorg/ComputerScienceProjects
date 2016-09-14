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
public class Project3_4 {

    public static void main(String[] args) {

        Scanner numScanner = new Scanner(System.in);
        double wage = 0;
        double hours = 0;
        double overtime = 0;
        wage:
        {

            while (true) {

                System.out.print("Enter the hourly wage as a double: ");
                try {

                    wage = numScanner.nextDouble();
                    break wage;
                } catch (Exception e) {

                    System.out.println("Invalid input type.");
                    numScanner.nextLine();
                }
            }
        }
        hours:
        {
            while (true) {

                System.out.print("Enter the regular hours as a double: ");
                try {

                    hours = numScanner.nextDouble();
                    break hours;
                } catch (Exception e) {

                    System.out.println("Invalid input type.");
                    numScanner.nextLine();
                }
            }
        }
        overtime:
        {

            while (true) {

                System.out.print("Enter the overtime hours as a double: ");
                try {

                    overtime = numScanner.nextDouble();
                    break overtime;
                } catch (Exception e) {

                    System.out.println("Invalid input type.");
                    numScanner.nextLine();
                }
            }
        }
        
        System.out.println("Total weekly pay: " + ((wage * hours) + (wage * 1.5 * overtime)));
    }
    /*
    run:
    Enter the hourly wage as a double: 12
    Enter the regular hours as a double: 5
    Enter the overtime hours as a double: 2
    Total weekly pay: 96.0
    BUILD SUCCESSFUL (total time: 3 seconds)
     */
}
