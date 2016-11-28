/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7.project9;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gvandomelen19
 */
public class Project7_9 {

    public static final String PATH = "src\\computerscienceprojects\\chapter7\\project9";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please enter a file name or \'exit\' to stop:");
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                break;
            }
            File file = new File(PATH + "\\" + str);

            System.out.println("Please enter a word to search:");
            str = scanner.nextLine().toLowerCase();

            String s = "";

            int start = 0;
            int first = -1;
            int count = 1;

            try {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {

                    s += fileReader.nextLine() + "\n";
                    s = s.toLowerCase();
                }
                if (s.contains(str)) {
                    
                    first = s.indexOf(str);
                    start = s.indexOf(str) + 1;
                }
                while (s.indexOf(str, start) >= 0) {
                    
                    count++;
                    start = s.indexOf(str, start) + 1;
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
                break;
            }
            
            if(first >= 0) System.out.println("\"" + str + "\"" + " first appears at index "
                    + first + ". It appears " + count + " times.");
            else System.out.println("\"" + str + "\"" + " does not appear in this file.");
            
        }
    }
    /*
    run:
    Please enter a file name or 'exit' to stop:
    thanks.txt
    Please enter a word to search:
    thanksgiving
    "thanksgiving" first appears at index 0. It appears 3 times.
    Please enter a file name or 'exit' to stop:
    BirdLoverInTheWest.txt
    Please enter a word to search:
    bird
    "bird" first appears at index 34. It appears 455 times.
    Please enter a file name or 'exit' to stop:
    exit
    */
}
