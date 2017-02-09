/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.docsengineershierarchy;

/**
 *
 * @author gvandomelen19
 */
public class Main {

    public static void main(String[] args) {
        
        Doctor d = new Doctor("Gerald", 40, 6, 400);
        Engineer e = new Engineer("Phteven", 32, 5, 12);    // That's Stee-ven with a ph
        AbstractProfessional theBestWorker = d.getYearsInProfession() > e.getYearsInProfession() ? d : e;
        System.out.printf("I, %s, am the best worker. I have worked %d years.%n", theBestWorker.getName(), theBestWorker.getYearsInProfession());
    }

}
