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
public interface Shape {
    public double   area();
    // public void     draw();
    public double   getXPos();
    public double   getYPos();
    public void     move(double xLoc, double yLoc);
    public void     stretchBy(double factor);
    public String   toString();
}
