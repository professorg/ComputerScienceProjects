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
public abstract class AbstractProfessional extends AbstractPerson {
    
    private int yearsInProfession;
    
    public AbstractProfessional(String name, int age, int yearsInProfession) {
        super(name, age);
        this.yearsInProfession = yearsInProfession;
    }
    
    public int getYearsInProfession() { return yearsInProfession; }
    
    public abstract void getTraining();
}
