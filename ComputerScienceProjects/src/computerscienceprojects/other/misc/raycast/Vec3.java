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
public class Vec3 {
    
    public double x, y, z;
    
    public Vec3(double x, double y, double z) {
        
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vec3(Vec3 from) {
        
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }
    
    public Vec3(double n) {
        
        this(n,n,n);
    }
    
    /**
     * Vector addition
     * @param other Added vector
     * @return New added vector
     */
    public Vec3 add(Vec3 other) {
        
        return new Vec3(this.x + other.x, this.y + other.y, this.z + other.z);
    }
    
    /**
     * Vector multiply by scalar.
     * @param n Multiplied scalar
     * @return New multiplied array
     */
    public Vec3 multiply(double n) {
        
        return new Vec3(this.x * n, this.y * n, this.z * n);
    }
    
    /**
     * Element-wise multiply.
     * @param other Multiplied Vec3
     * @return New multiplied vector
     */
    public Vec3 multiply(Vec3 other) {
        
        return new Vec3(this.x * other.x, this.y * other.y, this.z * other.z);
    }
    
    /**
     * Vector dot product.
     * @param other Multiplied Vec3
     * @return Dot product of vectors
     */
    public double dot(Vec3 other) {
        
        return this.x*other.x + this.y*other.y + this.z*other.z;
    }
    
    /**
     * Vector cross product.
     * @param other Multiplied Vec3
     * @return Cross product vector
     */
    public Vec3 cross(Vec3 other) {
        
        return new Vec3(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
    }
    
}
