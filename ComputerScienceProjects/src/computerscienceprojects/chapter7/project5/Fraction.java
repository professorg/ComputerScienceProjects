/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project5;

import computerscienceprojects.chapter6.project3.*;

/**
 *
 * @author gvandomelen19
 */
public class Fraction {
    
    private int numerator;
    private int denominator;

    
    // Constructor
    
    public Fraction(int numerator, int denominator) {
        
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }
    
    public Fraction(Fraction f) {
        
        this(f.getNumerator(), f.getDenominator());
    }
    
    
    // Getters

    public int getNumerator() {
        
        return numerator;
    }

    public int getDenominator() {
        
        return denominator;
    }
    
    
    // Other Methods
    
    public Fraction add(Fraction f) {
        
        int num = numerator * f.getDenominator() + f.getNumerator() * denominator;
        int denom = denominator * f.getDenominator();
        return new Fraction(num,denom);
    }
    
    public Fraction subtract(Fraction f) {
        
        int num = numerator * f.getDenominator() - f.getNumerator() * denominator;
        int denom = denominator * f.getDenominator();
        return new Fraction(num,denom);
    }
    
    public Fraction multiply(Fraction f) {
        
        int num = numerator * f.getNumerator();
        int denom = denominator * f.getDenominator();
        return new Fraction(num,denom);
    }
    
    public Fraction divide(Fraction f) {
        
        int num = numerator * f.getDenominator();
        int denom = denominator * f.getNumerator();
        return new Fraction(num,denom);
    }
    
    private void reduce() {
        
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }
    
    private static int findGCD(int n1, int n2) {
        
        while(!(n2 == 0)) {
            
            if(n1 < n2) {
                
                int tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        
        return n1;
    }
    
    @Override
    public String toString() {
        
        return numerator + "/" + denominator;
    }
    
    /*
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
    
    run:
    f1 (3/36): 1/12
    f2 (35/10): 7/2
    1/12 + 7/2 = 43/12
    1/12 - 7/2 = -41/12
    1/12 * 7/2 = 7/24
    1/12 / 7/2 = 1/42
    */
    
}
