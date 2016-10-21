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
public class Fraction {
    
    private int numerator;
    private int denominator;

    
    // Constructor
    
    public Fraction(int numerator, int denominator) {
        
        this.numerator = numerator;
        this.denominator = denominator;
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
    
    @Override
    public String toString() {
        
        return numerator + "/" + denominator;
    }
    
    /*
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
    */
    
    /*
        run:
        f1: 5/3
        f2: 3/4
        5/3 + 3/4 = 29/12
        5/3 - 3/4 = 11/12
        5/3 * 3/4 = 15/12
        5/3 / 3/4 = 20/9
        BUILD SUCCESSFUL (total time: 1 second)
    */
    
}
