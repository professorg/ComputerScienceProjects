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
    
    /*
        public static void main(String[] args) {
        
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        
        Scanner reader = new Scanner(System.in);
        System.out.print("How much money do you have? ");
        int money = reader.nextInt();
        int max = money;
        int rolls = 0;
        int maxroll = 0;
        
        while(money > 0) {
            
            rolls++;
            
            if(d1.roll() + d2.roll() == 7) {
                money += 4;
            } else {
                money -= 1;
            }
            
            if(money > max) {
                
                max = money;
                maxroll = rolls;
            }
        }
        
        System.out.println("You ran out of money after " + rolls + " rolls.");
        System.out.println("You had the most money after " + maxroll
                + " rolls when you had $" + max);
    */
    
    /*
    run:
    How much money do you have? 200
    You ran out of money after 2160 rolls.
    You had the most money after 27 rolls when you had $223
    BUILD SUCCESSFUL (total time: 1 second)
    */
}
