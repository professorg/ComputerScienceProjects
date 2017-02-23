/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter11.project4;

/**
 *
 * @author grant
 */
abstract public class AbstractShape implements Shape {
    
    protected double xPos;
    protected double yPos;
    
    public AbstractShape() {
        xPos = 0;
        yPos = 0;
    }
    
    public AbstractShape(double xLoc, double yLoc) {
        xPos = xLoc;
        yPos = yLoc;
    }
    
    abstract public double area();
    
    abstract public void draw(Pen p);
    
    public final double getXPos() {
        return xPos;
    }
    
    public final double getYPos() {
        return yPos;
    }
    
    public void move(double xLoc, double yLoc) {
        xPos = xLoc;
        yPos = yLoc;
    }
    
    abstract public void stretchBy(double factor);
    
    public String toString() {
        String str = "(x,Y) Position: (" + xPos + "," + yPos + ")\n" + "Area: " + area();
        return str;
    }
}
