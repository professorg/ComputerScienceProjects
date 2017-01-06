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
public class Exact extends Number {
    
    String str;
    
    public enum Const {
        
        e  (Math.E) ,
        pi (Math.PI);
        
        double value;
        Const (double d) {
    
            value = d;
        }
    }
    
    public Exact(String str) {
        
        this.str = str;
    }
    
    public Exact(double d) {
        
        this.str = d + "";
    }
    
    public Exact(int n) {
        
        this.str = n + "";
    }
    
    public Exact(float f) {
        
        this.str = f + "";
    }
    
    public Exact(short n) {
        
        this.str = n + "";
    }
    
    public Exact(long n) {
        
        this.str = n + "";
    }
    
    public Exact(Exact other) {
        
        this.str = other.str;
    }
    
    public Exact simplify() {
        
        // Try to simplify
        return this;
    }
    
    private void validate() {
        
        // Validate string
    }

    @Override
    public int intValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double doubleValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        
        return str;
    }
}
