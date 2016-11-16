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
        System.out.println("I'm thinking of a number between 1 and 100. ");
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
    
    /*
    run:
    I'm thinking of a number between 1 and 100.
    50
    No, the number is more. Guess again. 
    75
    No, the number is less. Guess again. 
    63
    No, the number is more. Guess again. 
    69
    No, the number is more. Guess again. 
    72
    Correct! You guessed the number after 5 guesses.
    
    run:
    I'm thinking of a number between 1 and 100. 
    50
    No, the number is less. Guess again. 
    25
    No, the number is more. Guess again. 
    38
    No, the number is more. Guess again. 
    44
    No, the number is less. Guess again. 
    41
    No, the number is more. Guess again. 
    42
    Correct! You guessed the number after 6 guesses.
    */
}
