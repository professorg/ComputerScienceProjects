/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project5;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class Project7_8 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence...");
        String s = "";
        String seperators = " ,.;/()+-'\"";
        boolean sep = false;
        while(s.equals("")) {
            
            System.out.print("> ");
            s = scanner.nextLine();
        }
        
        int words = 0;
        int letters = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if(seperators.contains(s.charAt(i) + "")) {
                
                if(!sep) words++;
                sep = true;
            } else {
                
                sep = false;
                letters++;
            }
        }
        if(!sep) words++;
        
        System.out.println("The sentence has " + words + " word(s),");
        System.out.println(letters + " letter(s), and on average,  ");
        System.out.println(letters / words + " letter(s) per word. ");
    }
}
