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
public class Engineer extends AbstractProfessional implements Worker {
    
    private int numBridgesDesigned;
    
    public Engineer(String name, int age, int yearsInProfession, int numBridgesDesigned) {
        super(name, age, yearsInProfession);
        this.numBridgesDesigned = numBridgesDesigned;
    }

    @Override
    public void getTraining() {
        System.out.println("I'm an engineer, so I train in Cupertino.");
    }

    @Override
    public void eat() {
        System.out.println("*eats takeout*");
    }

    @Override
    public void work() {
        buildBridges();
    }

    @Override
    public void takeABreak() {
        System.out.println("*plays with a Hoberman sphere*");
    }
    
    public void buildBridges() {
        System.out.println("I have now designed " + (++numBridgesDesigned) + " bridges.");
    }
    
    public int getNumBridgesDesigned() { return numBridgesDesigned; }
    
}
