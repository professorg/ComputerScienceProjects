/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.raycast;

/**
 *
 * @author gvandomelen19
 */
public class Ray {
    
    public float x;
    public float y;
    public float angleX;
    public float angleY;
    private float distance;
    
    public Ray(float x, float y, float z, float angleX, float angleY) {
        
        this.x = x;
        this.y = y;
        this.distance = 0;
    }
    
    public void step(float dist) {
        
        this.distance += dist;
        this.x += dist * Math.cos(angleX);
        this.y += dist * Math.sin(angleY);
    }
}
