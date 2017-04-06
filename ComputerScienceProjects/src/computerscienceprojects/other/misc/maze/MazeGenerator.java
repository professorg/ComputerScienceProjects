/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author gvandomelen19
 */
public class MazeGenerator {
    
    public String generate(int w, int h) {
        
        String str = w + " " + h + " ";
        for (int i = 0; i < w*h; i++) {                 // Create string
            if (i % w == 0 || i % w == w-1) str += "#";
            else if ((i % w) % 2 == 0) str += ".";
            else str += "#";
        }
        int size = (w-1)/2 * (h-1)/2;                   // Number of vertices
        int numEdges = (w-1)*(h-1)*2 + w + h - 2;       // Number of edges
        int[] edges = new int[numEdges*4];
        for (int i = 0; i < numEdges; i++) {
            if (i < (w-1)*(h-1) + w - 1) {              // Edges stored in array
                edges[4*i + 0] = (i/w) + i;             // {..., vertex 1, vertex 2, ...}
                edges[4*i + 1] = (i/w) + i + 1;         //  Index:  ^even     ^odd
            } else {
                edges[4*i + 0] = i;
                edges[4*i + 1] = i + w;
            }
        }
        DisjointUnionSet dus = new DisjointUnionSet(size);  // Store vertices
        return str;
    }
    
}
