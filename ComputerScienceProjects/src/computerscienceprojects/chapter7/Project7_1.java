/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project7_1 {
    
    public static void main(String[] args) {
        
        int guesses = 0;
        int random = (int)(Math.random()*100.0 + 1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("I'm thinking of a number between 1 and 100. ");
        while(true){
            
            guesses++;
            int guess = scanner.nextInt();
            if(random == guess) break;
            if(random < guess) System.out.print("No, the number is less. ");
            else System.out.print("No, the number is more. ");
            System.out.println("Guess again. ");
        }
        System.out.println("Correct! You guessed the number after " + guesses
                + " guesses.");
        
    }
}
