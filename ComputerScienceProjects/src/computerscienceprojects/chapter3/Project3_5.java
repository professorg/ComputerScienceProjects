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
public class Project3_5 {

    public static void main(String[] args) {

        Scanner numScanner = new Scanner(System.in);
        double wage = 0;
        double hours = 0;
        double overtime = 0;
        double hoursTotal = 0;
        double overtimeTotal = 0;
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
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (int i = 0; i < days.length; i++) {
            
            hours:
            {
                while (true) {

                    System.out.print("Enter the regular hours for " + days[i] + " as a double: ");
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

                    System.out.print("Enter the overtime hours for " + days[i] + " as a double: ");
                    try {

                        overtime = numScanner.nextDouble();
                        break overtime;
                    } catch (Exception e) {

                        System.out.println("Invalid input type.");
                        numScanner.nextLine();
                    }
                }
            }
            
            hoursTotal += hours;
            overtimeTotal += overtime;
        }

        System.out.println("Total weekly pay: " + ((wage * hoursTotal) + (wage * 1.5 * overtimeTotal)));
    }
    /*
    run:
    Enter the hourly wage as a double: 5
    Enter the regular hours for Monday as a double: 5
    Enter the overtime hours for Monday as a double: 3
    Enter the regular hours for Tuesday as a double: 1
    Enter the overtime hours for Tuesday as a double: 7
    Enter the regular hours for Wednesday as a double: 3.5
    Enter the overtime hours for Wednesday as a double: 2
    Enter the regular hours for Thursday as a double: 7
    Enter the overtime hours for Thursday as a double: .01
    Enter the regular hours for Friday as a double: 2
    Enter the overtime hours for Friday as a double: 5
    Total weekly pay: 220.075
    BUILD SUCCESSFUL (total time: 25 seconds)
     */
}
