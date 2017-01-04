/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter10;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project10_2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[10];
        
        for (int i = 1; i <= 10; i++) {
            
            System.out.printf("Please enter an integer (%d): ", i);
            double d = scanner.nextDouble();
            arr[i-1] = d;
        }
        
        double avg = averageDoubleArray(arr);
        System.out.printf("Average: %f%n", avg);
        System.out.println("Numbers greater than average:");
        for (int i = 0; i < 10; i++) {
            
            if(arr[i] > avg) System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    
    private static double averageDoubleArray(double[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            
            sum += arr[i];
        }
        return sum / arr.length;
    }
    /*
    run:
    Please enter an integer (1): -57.2346
    Please enter an integer (2): 3624.78356
    Please enter an integer (3): -6342.5234
    Please enter an integer (4): -5423.845
    Please enter an integer (5): 7835.956
    Please enter an integer (6): 523.1
    Please enter an integer (7): -724.74
    Please enter an integer (8): 7427.2
    Please enter an integer (9): 62.727
    Please enter an integer (10): .1617
    Average: 692.000000
    Numbers greater than average:
    3624.78356 7835.956 7427.2 
    */
}
