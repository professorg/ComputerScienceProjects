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
public abstract class AbstractPerson {
    
    private String name;
    private int age;
    
    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public abstract void eat();
}
