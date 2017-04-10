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
        
        StringBuilder str = new StringBuilder(w + " " + h + " ");
        for (int i = 0; i < w*h; i++) {             // Create string
            if (i % w == 0 || i % w == w-1) str.append('#');
            else if ((i % w) % 2 == 0) str.append('.');
            else str.append('#');
        }
        int size = (w-1)/2 * (h-1)/2;               // Number of vertices
        int numEdges = (w-1)*(h-1)*2 + w + h - 2;   // Number of edges
        int[] edges = new int[numEdges*4];
        for (int i = 0; i < numEdges; i++) {
            if (i < (w-1)*(h-1) + w - 1) {          // Edges stored in array
                edges[4*i + 0] = (i/w) + i;         // {..., vertex 1, vertex 2, ...}
                edges[4*i + 1] = (i/w) + i + 1;     //  Index:  ^even     ^odd
            } else {
                edges[4*i + 0] = i;
                edges[4*i + 1] = i + w;
            }
        }
        blockRandomize(edges, 2);   // Put edges in random order,
                                    // but keep each pair of vertices together
        DisjointUnionSet dus = new DisjointUnionSet(size);  // Store vertices
        for (int i = 0; i < edges.length/2; i+=2) {
            if (!dus.union(i, i+1)) {   // Edges not already unioned
            }
        }
        return str.toString();
    }
    
    private static void swap(int[] arr, int a, int b) {
        
        int tmp = arr[a];
        arr[a] = b;
        arr[b] = tmp;
    }
    
    private static void blockSwap(int[] arr, int a, int b, int n) {
        
        for (int i = 0; i < n; i++) {
            swap(arr, a+i, b+i);
        }
    }
    
    private static void blockRandomize(int[] arr, int n) {
        
        for (int i = arr.length/n-1; i >=0; i++) {
            int r = (int)(Math.random() * i);
            blockSwap(arr, i, r, n);
        }
    }
    
}
