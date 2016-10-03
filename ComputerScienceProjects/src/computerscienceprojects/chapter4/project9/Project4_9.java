/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4.project9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project4_9 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner reader = new Scanner(new File("src/computerscienceprojects/chapter4/project9/exponent_list.txt"));
        while(reader.hasNext()) {
            
            int base = reader.nextInt();
            int exp = reader.nextInt();
            System.out.println(base + "^" + exp + "=" + (int)Math.pow(base,exp));
        }
    }
    /*
    run:
    2^3=8
    4^2=16
    5^1=5
    3^4=81
    BUILD SUCCESSFUL (total time: 1 second)
    
    run:
    10^20=2147483647
    3^6=729
    2^16=65536
    5^2=25
    10^3=1000
    BUILD SUCCESSFUL (total time: 1 second)
    
    exponent_list contents:
        10 20
        3 6
        2 16
        5 2
        10 3
    */
}
