/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other;

/**
 *
 * @author gvandomelen19
 */
public class Testing {

    public static void main(String[] args) {
        
        String str = "The thethe the the the It's the kind of the";
        String str2 = "This has no things spelled T-H-E";
        
        int count = 0;
        int index = 0;
        while(true) {
            
            if(str.indexOf("the", index) == -1) break;
            count++;
            index = str.indexOf("the", index) + 1;
        }
        System.out.println(count);
    }
}
