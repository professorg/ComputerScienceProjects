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
public class Triangle extends AbstractShape {
    
    private double x2, y2, x3, y3;
    private double scale;
    
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.scale = 1;
    }

    @Override
    public double area() {
        return 0.5 * Math.abs(xPos * y2 - x2 * yPos + x2 * y3 - x3 * y2 + x3 * yPos - xPos * y3);
    }

    @Override
    public void move(double xLoc, double yLoc) {
        double dx = xPos - xLoc;
        double dy = yPos - yLoc;
        super.move(xLoc, yLoc);
        x2 += dx;
        y2 += dy;
        x3 += dx;
        y3 += dy;
    }

    @Override
    public void stretchBy(double factor) {
        double dx2 = xPos - x2;
        double dy2 = yPos - y2;
        double dx3 = xPos - x3;
        double dy3 = yPos - y3;
        dx2 *= factor;
        dy2 *= factor;
        dx3 *= factor;
        dy3 *= factor;
        x2 = xPos + dx2;
        y2 = yPos + dy2;
        x3 = xPos + dx3;
        y3 = yPos + dy3;
    }

    @Override
    public void draw(Pen p) {
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.move(x2, y2);
        p.move(x3, y3);
    }
    
    @Override
    public String toString() {
        String str = String.format("(X,Y) Points: (%f,%f), (%f,%f), (%f,%f)%nArea: %f", xPos, yPos, x2, y2, x3, y3, area());
        return str;
    }
    
}
