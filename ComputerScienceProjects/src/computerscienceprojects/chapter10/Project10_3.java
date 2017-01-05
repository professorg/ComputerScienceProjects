/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter10;

import java.util.Scanner;

/**
 *
 * @author grant
 */
public class Project10_3 {
    
    public static void main(String[] args) {
        
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            
            System.out.printf("Please enter an integer (%d): ", i);
            arr[i-1] = scanner.nextInt();
        }
        System.out.printf("Mode: %d%n", modeOfIntArray(arr));
    }
    
    private static int modeOfIntArray(int[] arr) {
        
        int[] uniqueVals = new int[arr.length];
        int numUnique = 0;
        int[] frequency = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            
            boolean unique = true;
            for (int j = 0; j < numUnique; j++) {
                
                if (arr[i] == uniqueVals[j]) {
                    
                    frequency[j]++;
                    unique = false;
                    break;
                }
            }
            if(unique) {
                
                uniqueVals[numUnique] = arr[i];
                frequency[numUnique++] = 1;
            }
        }
        int mode = uniqueVals[0];
        int modeFreq = frequency[0];
        int count = 1;
        for (int i = 1; i < numUnique; i++) {
            
            if (frequency[i] == modeFreq) count++;
            if (frequency[i] > modeFreq) {
                
                mode = uniqueVals[i];
                modeFreq = frequency[i];
                count = 1;
            }
        }
        if(count > 1) throw new java.lang.IllegalStateException();
        return mode;
    }
    /*
    run:
    Please enter an integer (1): 3
    Please enter an integer (2): 7
    Please enter an integer (3): 5
    Please enter an integer (4): 3
    Please enter an integer (5): 7
    Please enter an integer (6): 7
    Please enter an integer (7): 9
    Please enter an integer (8): 23
    Please enter an integer (9): 5
    Please enter an integer (10): 1
    Mode: 7
    
    run:
    Please enter an integer (1): 0
    Please enter an integer (2): 1
    Please enter an integer (3): 2
    Please enter an integer (4): 2
    Please enter an integer (5): 4
    Please enter an integer (6): 5
    Please enter an integer (7): 6
    Please enter an integer (8): 6
    Please enter an integer (9): 8
    Please enter an integer (10): 9
    Exception in thread "main" java.lang.IllegalStateException
            at computerscienceprojects.chapter10.Project10_3.modeOfIntArray(Project10_3.java:65)
            at computerscienceprojects.chapter10.Project10_3.main(Project10_3.java:26)
    C:\Users\grant\AppData\Local\NetBeans\Cache\8.1\executor-snippets\run.xml:53: Java returned: 1
    */
}
