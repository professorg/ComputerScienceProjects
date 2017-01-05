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
public class Player {
    
    public Vec3 position, velocity;
    public double angle, yaw;
    public int sector;
    
    public Player(Vec3 pos) {
        
        this.position = pos;
        this.velocity = new Vec3(0);
    }
    
    public Player move(double dx, double dy) {
        
        this.position = this.position.add(new Vec3(dx, dy, 0));
        return this;
    }
    
}
