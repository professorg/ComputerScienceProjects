/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project3;

/**
 *
 * @author gvandomelen19
 */
public class Project6_3 {
    
    public static void main(String[] args) {
        
        Fraction f1 = new Fraction(5,3);
        System.out.println("f1: " + f1);
        Fraction f2 = new Fraction(3,4);
        System.out.println("f2: " + f2);
        
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
    }
}
