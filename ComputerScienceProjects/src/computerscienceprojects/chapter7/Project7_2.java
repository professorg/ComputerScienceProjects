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
public class Project7_2 {
    
    public static void main(String[] args) {
        
        int guesses = 0;
        int answer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for the computer to guess. ");
        while(true) {
            
            answer = scanner.nextInt();
            if(answer >= 1 && answer <= 100) break;
            System.out.print("Number must be between 1 and 100. ");
        }
        while(true){
            
            guesses++;
            int guess = scanner.nextInt();
            if(answer == guess) break;
            if(answer < guess) System.out.print("No, the number is less. ");
            else System.out.print("No, the number is more. ");
            System.out.println("Guess again. ");
        }
        System.out.println("Correct! You guessed the number after " + guesses
                + " guesses.");
        
    }
}
