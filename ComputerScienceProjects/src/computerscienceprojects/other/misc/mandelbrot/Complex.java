/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.mandelbrot;

/**
 *
 * @author gvandomelen19
 */
public class Complex {
    
    private final double real;
    private final double imag;
    
    public Complex(double real, double imag) {
        
        this.real = real;
        this.imag = imag;
    }
    
    public Complex(double real) {
        
        this.real = real;
        this.imag = 0;
    }
    
    public Complex(Complex c) {
        
        this.real = c.getReal();
        this.imag = c.getImag();
    }
    
    public double getReal() {
    
        return real;
    }
    
    public double getImag() {
    
        return imag;
    }
    
    public Complex add(Complex other) {
        
        return new Complex(this.real + other.getReal(), this.imag + other.getImag());
    }
    
    public Complex subtract(Complex other) {
        
        return new Complex(this.real - other.getReal(), this.imag - other.getImag());
    }
    
    public Complex multiply(Complex other) {
        
        return new Complex(this.real * other.getReal(), this.imag * other.getImag());
    }
    
    public Complex divide(Complex other) {
        
        return new Complex(this.real / other.getReal(), this.imag / other.getImag());
    }
    
    public boolean equals(Complex other) {
        
        return Math.abs(this.real - other.getReal()) < 1E-15 && Math.abs(this.imag - other.getImag()) < 1E-15;
    }
    
    public int compareTo(Complex other) {
        
        if (Math.abs(norm(other) - norm(this)) < 1E-15) {
            
            return 0;
        }
        return norm(other) > norm(this) ?  -1 : 1;
    }
    
    public static double norm(Complex c) {
        
        return Math.sqrt(c.real * c.real + c.imag * c.imag);
    }
    
    @Override
    public String toString() {
        
        return this.real + (this.imag < 0 ? "" : "+") + this.imag;
    }
    
}
