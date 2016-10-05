/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter4;

/**
 *
 * @author gvandomelen19
 */
public class CustomMath {

    public static void main(String[] args) {

        System.out.println(pow(4,1.5));
    }

    public static double pow(double base, double exp) {

        if (exp < 0) {
            return 1 / pow(base, -exp);
        }
        if ((double) (int) exp == exp) {
            
            double out = 1;
            for (int i = 0; i < exp; i++) {

                out *= base;
            }
            return out;
        } else {
            
            double out = pow(base, (int) exp);
            
            for (int i = 0; i < 8; i++) {
                
                if(((int)((exp - (int) exp) * pow(2,i+1)) & 1) == 1) {
                    
                    double tmp = base;
                    
                    for (int j = 0; j < i+1; j++) {
                        
                        base = sqrt(base);
                    }
                    out *= base;
                }
            }
            
            return out;
        }
    }

    public static double sqrt(double n) {

        double n1 = n;
        double n2 = n1 / n;

        for (int i = 0; i < 32; i++) {

            n2 = n / n1;
            n1 = (n1 + n2) / 2;
        }

        return n1;
    }
    
    /*public static double max(double a, double b) {
        
        
    }
    
    public static int max(int a, int b) {
        
        
    }*/
}
