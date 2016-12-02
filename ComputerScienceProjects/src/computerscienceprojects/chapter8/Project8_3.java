/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author GVandomelen19
 */
public class Project8_3 {
    
    public static final double MAX_AMOUNT = 10000;
    public static final double MAX_YEARS = 40;
    public static final double MAX_RATE = 200;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the initial investment: $ ");
        double amt = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        System.out.print("Enter the annual interest rate [%]: ");
        double rate = scanner.nextDouble();
        
        String err = "";
        if(amt < 0 || amt > MAX_AMOUNT)
            err += String.format("Must have 0 < investment <= %s%n", 
                   formatFloat(MAX_AMOUNT));
        if(years < 0 || years > MAX_YEARS)
            err += String.format("Must have 0 < years <= %s%n",
                    formatFloat(MAX_YEARS));       
        if(rate < 0 || rate > MAX_RATE)
            err += String.format("Must have 0 < rate <= %s%n",
                    formatFloat(MAX_RATE));
        if(err.equals("")) {
            
            char[] c = new char[53];
            Arrays.fill(c, '-');
            System.out.printf("%4s%17s%17s%15s%n%53s%n", "Year",
                    "$ at Year Start", "Interest Earned", "$ at Year End",
                    new String(c));
            for (int i = 1; i <= years; i++) {
                
                double start = amt;
                amt *= Math.pow(1 + rate / 400, 4);
                double interest = amt - start;
                System.out.printf("%4d%17.2f%17.2f%15.2f%n",
                        i, start, interest, amt);
            }
        } else{
            
            System.out.print(err);
        }
        
    }
    
    private static String formatFloat(double d) {
        
        if(d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
    
    /*
    run:
    Enter the initial investment: $ 5000
    Enter the number of years: 15
    Enter the annual interest rate [%]: 3.25
    Year  $ at Year Start  Interest Earned  $ at Year End
    -----------------------------------------------------
       1          5000.00           164.49        5164.49
       2          5164.49           169.90        5334.39
       3          5334.39           175.49        5509.89
       4          5509.89           181.27        5691.15
       5          5691.15           187.23        5878.38
       6          5878.38           193.39        6071.77
       7          6071.77           199.75        6271.52
       8          6271.52           206.32        6477.84
       9          6477.84           213.11        6690.95
      10          6690.95           220.12        6911.07
      11          6911.07           227.36        7138.43
      12          7138.43           234.84        7373.28
      13          7373.28           242.57        7615.84
      14          7615.84           250.55        7866.39
      15          7866.39           258.79        8125.18
    */
}
