/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Testing {
    
    public static void main(String[] args) {
        
        int value = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);
        final int SENTINEL = -999;
        while(value != SENTINEL) {
            s += value + " ";
            
            value = scanner.nextInt();
        }
        System.out.println(s);
    }
}
