/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other;

/**
 *
 * @author gvandomelen19
 */
public class Testing {

    public static void main(String[] args) {
        
        int[] bids = {601};
        System.out.println(priceIsRight(bids, 600));
    }
    
    public static int priceIsRight(int[] bids, int price) {
        int closestIndex = -1;
        for(int i = 0; i < bids.length; i++) {
            if(bids[i] < price
               && (closestIndex < 0 || price - bids[i] <= price - bids[closestIndex])) closestIndex = i; 
        }
        return closestIndex > 0 ? bids[closestIndex] : -1;
    }
}
