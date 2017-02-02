/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.gol;

/**
 *
 * @author gvandomelen19
 */
public class Cell {
    
    private boolean isAlive;
    private boolean isAliveNext;
    
    public Cell(boolean alive) {
        
        this.isAlive = alive;
    }
    
    public Cell() {
        
        this(false);
    }
    
    public boolean getAlive() {
        
        return this.isAlive;
    }
    
    public void setAliveNext(boolean alive) {
        
        this.isAliveNext = alive;
    }
    
    public boolean update() {
        
        this.isAlive = this.isAliveNext;
        return this.isAlive;
    }
    
}
