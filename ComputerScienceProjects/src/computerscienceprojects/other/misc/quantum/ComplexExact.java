/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.quantum;

/**
 *
 * @author gvandomelen19
 */
public class ComplexExact {
    
    Exact real;
    Exact imaginary;
    
    public ComplexExact(Exact real, Exact imaginary) {
        
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public Exact realPart() {
        
        return new Exact(real);
    }
    
    public Exact imaginaryPart() {
        
        return new Exact(imaginary);
    }
    
    public ComplexExact complexRealPart() {
        
        return new ComplexExact(this.real, new Exact("0"));
    }
    
    public ComplexExact complexImaginaryPart() {
        
        return new ComplexExact(new Exact("0"), this.imaginary);
    }
    
}
