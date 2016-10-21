/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter6.project4;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project6_4 {
    
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
    }
}
