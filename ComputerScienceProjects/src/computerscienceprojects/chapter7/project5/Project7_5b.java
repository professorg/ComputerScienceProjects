/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project5;

/**
 *
 * @author gvandomelen19
 */
public class Project7_5b {
    
    public static void main(String[] args) {    // From Project 6.3
        
        Fraction f1 = new Fraction(3,36);
        System.out.println("f1 (3/36): " + f1);
        Fraction f2 = new Fraction(35,10);
        System.out.println("f2 (35/10): " + f2);
        
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
    }
}
