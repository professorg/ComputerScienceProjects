/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project4;

import java.util.Random;

/**
 *
 * @author gvandomelen19
 */
public class Dice {
    
    int val = 0;
    Random r;
    
    public Dice(String seed) {
        
        r = new Random(seed.hashCode());
    }
    
    public Dice() {
        
        r = new Random();
    }
    
    public int getValue() {
        
        return val;
    }
    
    public int roll() {
        
        val = r.nextInt(6) + 1;
        return val;
    }
}
