/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter2;

/**
 *
 * @author grant
 */
public class Project2_4 {
    
    public static void main(String[] args) {
        
        System.out.println(yearToMinutes(1));
    }
    
    public static int yearToMinutes(int years){
        
        return years * 365 * 24 * 60;
    }
    
    /*
     run-single:
     525600
     BUILD SUCCESSFUL (total time: 0 seconds)
     */
}
