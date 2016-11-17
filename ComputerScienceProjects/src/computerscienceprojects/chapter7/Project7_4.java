/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project7_4 {

    public static void main(String[] args) {

        boolean running = true;
        int num;
        double avg = 0.0;
        int min = 101;
        int max = -1;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a list of grades.");

        while (running) {

            String s = "";

            System.out.print("\r> ");
            try {

                s = scanner.next();
                num = Integer.parseInt(s);
                if (num == -1) {
                    break;
                }
                if (num < 0 || num > 100) {
                    throw new Exception();
                }
            } catch (Exception e) {

                System.out.println("Invalid integer: " + s);
                continue;
            }

            min = Math.min(min, num);
            max = Math.max(max, num);
            avg = (avg * count + (double) num) / (double) ++count;
        }

        System.out.println("Minimum: " + getLetterGrade(min));
        System.out.println("Maximum: " + getLetterGrade(max));
        System.out.println("Average: " + getLetterGrade((int) avg));
    }

    private static String getLetterGrade(int grade) {

        String s = "";

        if (grade < 60) {

            s += "F";
        } else if (grade < 70) {

            s += "D";
            if (grade < 62) {
                s += "-";
            }
            if (grade > 65) {
                s += "+";
            }
        } else if (grade < 80) {

            s += "C";
            if (grade < 72) {
                s += "-";
            }
            if (grade > 75) {
                s += "+";
            }
        } else if (grade < 90) {

            s += "B";
            if (grade < 82) {
                s += "-";
            }
            if (grade > 85) {
                s += "+";
            }
        } else {

            s += "A";
            if (grade < 92) {
                s += "-";
            }
            if (grade > 95) {
                s += "+";
            }
        }

        return s;
    }
    
    /*
    run:
    Please enter a list of grades.
    > 65
    > 95 76 39 99 89 76 50 69
    > -1
    Minimum: F
    Maximum: A+
    Average: C
    */

}
