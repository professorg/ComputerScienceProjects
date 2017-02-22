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
public class Doctor extends AbstractProfessional implements Worker {
    
    private int numPatients;
    
    public Doctor(String name, int age, int yrsInProfession, int numPatients) {
        super(name, age, yrsInProfession);
        this.numPatients = numPatients;
    }

    @Override
    public void getTraining() {
        System.out.println("I'm a doctor, so I train in Hawaii.");
    }

    @Override
    public void eat() {
        System.out.println("*eats an apple*");
    }

    @Override
    public void work() {
        treatPatients();
    }

    @Override
    public void takeABreak() {
        System.out.println("*naps on the exam table*");
    }
    
    public void treatPatients() {
        System.out.println("I have now treated " + (++numPatients) + " patients!");
    }
    
    public int getNumPatients() { return numPatients; }
    
}
