/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc;

import util.Noise;

/**
 *
 * @author gvandomelen19
 */
public class ASCIIGradient {
    
    public static final String CHARS = " .:;+=&xX$#";
    public static final double NOISE = 0.01;
    
    public static void main(String[] args) {
        
        double[][] rows = new double[40][100];
        Noise n = new Noise(Math.random());
        Noise m = new Noise(Math.random());
        
        for (int i = 0; i < rows.length; i++) {
            
            for (int j = 0; j < rows[0].length; j++) {
                
                rows[i][j] = clamp((((n.multiBetterOffset(i, j, 100, 0.05) + 1) + (m.multiBetterOffset(i, j, -100, 0.05) + 1))) / 3.0/* > 2.5 ? 2 : -2*/  + (Math.random() * NOISE) - 0.5);
            }
        }
        
        char[][] ascii = toASCII(rows);
        String s = char2dToString(ascii);
        
        System.out.println(s);
        
    }
    
    public static char[][] toASCII(double[][] rows) {
        
        char[][] out = new char[rows.length][rows[0].length];
        
        for (int i = 0; i < rows.length; i++) {
            
            for (int j = 0; j < rows[0].length; j++) {
                
                out[i][j] = CHARS.charAt((int)(rows[i][j] * (CHARS.length())));
            }
        }
        
        return out;
    }
    
    public static String char2dToString(char[][] rows) {
        
        String out = "";
        
        for (int i = 0; i < rows.length; i++) {
            
            for (int j = 0; j < rows[0].length; j++) {
                
                out+=rows[i][j];
            }
            out+="\n";
        }
        out = out.substring(0, out.length()-1);
        return out;
    }
    
    public static double clamp(double d) {
        
        if(d < 0.0) {
            return 0.0;
        }
        if(d > 1.0) {
            return 0.99;
        }
        return d;
    }
}
