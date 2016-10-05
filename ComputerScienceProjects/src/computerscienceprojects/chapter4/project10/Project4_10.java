/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4.project10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project4_10 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new File("src/computerscienceprojects/chapter4/project10/salary.dat"));
        
        System.out.print("Enter the starting salary: $");
        double salary = scanner.nextDouble();
        System.out.print("Enter the annual % increase: ");
        double inc = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        
        writer.println("Year   Salary");
        writer.println("-------------");
        
        for (int i = 1; i <= years; i++) {
            
            writer.println(i + "  " + salary);
            salary *= (1+(i >= 11? 0 : inc*0.01));
        }
        writer.close();
    }
    /*
    run:
    Enter the starting salary: $40000
    Enter the annual % increase: 3
    Enter the number of years: 25
    BUILD SUCCESSFUL (total time: 5 seconds)
    
    salary.dat:
        Year   Salary
        -------------
        1  40000.0
        2  41200.0
        3  42436.0
        4  43709.08
        5  45020.3524
        6  46370.962972
        7  47762.09186116
        8  49194.9546169948
        9  50670.803255504645
        10  52190.92735316978
        11  53756.65517376488
        12  53756.65517376488
        13  53756.65517376488
        14  53756.65517376488
        15  53756.65517376488
        16  53756.65517376488
        17  53756.65517376488
        18  53756.65517376488
        19  53756.65517376488
        20  53756.65517376488
        21  53756.65517376488
        22  53756.65517376488
        23  53756.65517376488
        24  53756.65517376488
        25  53756.65517376488
    
    */
}
