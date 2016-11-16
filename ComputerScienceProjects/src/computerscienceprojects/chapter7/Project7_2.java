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
        int mode = -1;
        int max = 1;
        int min = 1;
        Scanner scanner = new Scanner(System.in);
        
        while(mode < 0 || mode > 3) {
            
            System.out.println("Choose a mode: ");
            System.out.println("1) Brain-dead");
            System.out.println("2) Pretty Smart");
            System.out.println("3) Einstein");
            System.out.print("> ");
            String str = scanner.nextLine();
            System.out.println();
            if(str.equals("1") || str.equalsIgnoreCase("Brain-dead")) {
                
                mode = 1;
                System.out.println("Running on Brain-dead mode...");
            }
            if(str.equals("2") || str.equalsIgnoreCase("Pretty Smart")) {
                
                mode = 2;
                System.out.println("Running on Pretty Smart mode...");
            }
            if(str.equals("3") || str.equalsIgnoreCase("Einstein")) {
                
                mode = 3;
                System.out.println("Running on Einstein mode...");
            }
        }
        
        max *= Math.pow(10, mode);
        System.out.println("Choose a number between 1 and " + max +".");
        System.out.print("Press enter to continue...");
        scanner.nextLine();
        System.out.println();
        int guess = -1;
        
        boolean running = true;
        
        while(running) {
            
            guesses++;
            switch(mode) {
                
                case 1:
                    
                    guess = randrange(1,10);
                    break;
                case 2:
                    
                    guess = randrange(min,max);
                    break;
                case 3:
                    
                    guess = (min + max) / 2;
                    break;
            }
            
            boolean understood = false;
            
            while(!understood) {
                
                System.out.println("I guess... " + guess);
                System.out.println("Am I:");
                System.out.println("1) Too High");
                System.out.println("2) Too Low");
                System.out.println("3) Perfect");
                System.out.print("> ");
                String str = scanner.nextLine();
                System.out.println();
                if(str.equals("1") || str.equalsIgnoreCase("Too High")) {

                    max = guess - 1;
                    understood = true;
                }
                else if(str.equals("2") || str.equalsIgnoreCase("Too Low")) {

                    min = guess + 1;
                    understood = true;
                }
                else if(str.equals("3") || str.equalsIgnoreCase("Perfect")) {
                    
                    System.out.println("Yay! I guessed correctly after " + guesses + " guesses.");
                    understood = true;
                    running = false;
                } else {
                    
                    System.out.println("Sorry, I don't understand.");
                }
            }
            
        }
        
    }
    
    private static int randrange(int a, int b) {
        
        int diff = Math.abs(b-a);
        return (int) (Math.random() * diff + Math.min(a, b));
    }
    
    /*
    run:
    Choose a mode: 
    1) Brain-dead
    2) Pretty Smart
    3) Einstein
    > 1

    Running on Brain-dead mode...
    Choose a number between 1 and 10.
    Press enter to continue...
    
    I guess... 9
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 7
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 8
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 1
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 1
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 4
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 3
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 3

    Yay! I guessed correctly after 7 guesses.
    
    
    run:
    Choose a mode: 
    1) Brain-dead
    2) Pretty Smart
    3) Einstein
    > 2

    Running on Pretty Smart mode...
    Choose a number between 1 and 100.
    Press enter to continue...
    
    I guess... 10
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 49
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 45
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 32
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 39
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 3

    Yay! I guessed correctly after 5 guesses.
    
    run:
    Choose a mode: 
    1) Brain-dead
    2) Pretty Smart
    3) Einstein
    > 3

    Running on Einstein mode...
    Choose a number between 1 and 1000.
    Press enter to continue...
    
    I guess... 500
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 250
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 375
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 1

    I guess... 312
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 343
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 359
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 367
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 2

    I guess... 371
    Am I:
    1) Too High
    2) Too Low
    3) Perfect
    > 3

    Yay! I guessed correctly after 8 guesses.
    */
}
