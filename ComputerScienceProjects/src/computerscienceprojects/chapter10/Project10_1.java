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
public class Project10_1 {
    
    public static void main(String[] args) {
        
        int[] evenList = new int[10];
        int evenIndex = 0;
        int[] oddList = new int[10];
        int oddIndex = 0;
        int[] negativeList = new int[10];
        int negativeIndex = 0;
        
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            
            System.out.printf("Please enter an integer (%d): ", i);
            int n = scanner.nextInt();
            if(n < 0) negativeList[negativeIndex++] = n;
            if((n % 2 + 2) % 2 == 0) evenList[evenIndex++] = n;
            if((n % 2 + 2) % 2 == 1) oddList[oddIndex++] = n;
        }
        
        System.out.println("Even List:");
        printIntArray(evenList, evenIndex-1);
        System.out.println("Odd List:");
        printIntArray(oddList, oddIndex-1);
        System.out.println("Negative List:");
        printIntArray(negativeList, negativeIndex-1);
    }
    
    private static void printIntArray(int[] arr, int toIndex) {
        
        System.out.print("[");
        for (int i = 0; i < toIndex; i++) {
            
            System.out.print(arr[i] + (i < toIndex - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
    
    /*
    run:
    Please enter an integer (1): 25
    Please enter an integer (2): 7
    Please enter an integer (3): 25
    Please enter an integer (4): 15
    Please enter an integer (5): -6
    Please enter an integer (6): -74
    Please enter an integer (7): 15
    Please enter an integer (8): -6784
    Please enter an integer (9): 51
    Please enter an integer (10): -7373
    Even List:
    [-6, -74]
    Odd List:
    [25, 7, 25, 15, 15, 51]
    Negative List:
    [-6, -74, -6784]
    */
}
