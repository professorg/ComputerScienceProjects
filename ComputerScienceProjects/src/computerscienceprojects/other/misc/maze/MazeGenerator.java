/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.maze;

/**
 *
 * @author gvandomelen19
 */
public class MazeGenerator {
    
    public static String generate(int vW, int vH) {
        
        int w = vW*2+1;
        int h = vH*2+1;
        int headerlen = (h + " " + w + " ").length();
        StringBuilder str = new StringBuilder(h + " " + w + " ");
        for (int i = 0; i < w*h; i++) {     // Create string
            if (i % w == 0 || i % w == w-1 || i / w == 0 || i / w == h - 1) str.append('#');
            else if ((i % w) % 2 == 1 && (i / w) % 2 == 1) str.append('.');
            else str.append('#');
        }
        int size = vW * vH;     // Number of vertices
        int numEdges = (vW-1)*(vH-1)*2 + vW + vH - 2;       // Number of edges
        int[] edges = new int[numEdges*2];
        int threshold = vH*(vW-1);
        int percent = numEdges/100-1;
        for (int i = 0; i < numEdges; i++) {
            if (i % percent == 0) System.out.print("\rGenerating vertices..." + i/percent + "%");
            if (i < threshold) {        // Edges stored in array
                edges[2*i + 0] = (i/(vW-1)) + i;        // {..., vertex 1, vertex 2, ...}
                edges[2*i + 1] = (i/(vW-1)) + i + 1;    //  Index:  ^even     ^odd
            } else {
                edges[2*i + 0] = i - threshold;
                edges[2*i + 1] = i + vW - threshold;
            }
            // System.out.println(edges[2*i+0] + ", " + edges[2*i+1]);
        }
        System.out.println("...Done");
        // printBlockArr(edges,2);
        // System.out.println("-----");
        blockRandomize(edges, 2);   // Put edges in random order,
                                    // but keep each pair of vertices together
        // printBlockArr(edges,2);
        DisjointUnionSet dus = new DisjointUnionSet(size);  // Store vertices
        percent = numEdges*2/100-1;
        for (int i = 0; i < numEdges*2; i+=2) {
            if (i % percent == 0) System.out.print("\rGenerating edges..." + i/percent + "%");
            // System.out.println(edges[i] + ", " + edges[i+1]);
            if (!dus.union(edges[i], edges[i+1])) {     // Edges not already unioned
                int x,y;
                if (edges[i] + 1 == edges[i+1]) {       // Horizontal union
                    x = 2*(edges[i]%vW)+2;
                    y = 2*(edges[i]/vW)+1;
                } else {                                // Vertical union
                    x = 2*(edges[i]%vW)+1;
                    y = 2*(edges[i]/vW)+2;
                }
                int index = x + w*y + (w + " " + h + " ").length();
                str.setCharAt(index, '.');
            }
        }
        System.out.println("...Done");
        str.setCharAt(headerlen+1, 'S');
        str.setCharAt(headerlen+(w-2)+w*(h-1), 'G');
        return str.toString();
    }
    
    private static void swap(int[] arr, int a, int b) {
        
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    private static void blockSwap(int[] arr, int a, int b, int n) {
        
        for (int i = 0; i < n; i++) {
            swap(arr, a+i, b+i);
        }
    }
    
    private static void blockRandomize(int[] arr, int n) {
        
        for (int i = 0; i < arr.length/n; i++) {
            int r = (int) (Math.random() * (arr.length / n - i));
            blockSwap(arr, n*i, n*(i+r), n);
        }
    }
    
    private static void printBlockArr(int[] arr, int n) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i % n == n-1) System.out.println("");
        }
    }
    
}
