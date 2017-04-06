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
public class MazeSolver {
    
    private char[][] maze;
    private int length;
    private int width;
    
    public MazeSolver(String maze) {    // <num> <num> <maze>
        
        this.maze = fromString(maze);
        this.length = this.maze.length;
        this.width = this.maze[0].length;
    }
    
    private char[][] fromString(String s) {
        
        int l = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        s = s.substring(s.indexOf(" ")+1);
        int w = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        s = s.substring(s.indexOf(" ")+1);
        char[][] maze = new char[l][w];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                maze[i][j] = s.charAt(j + w*i);
            }
        }
        return maze;
    }
    
    public String toString(char[][] maze) {
        
        String s = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                s += maze[i][j];
            }
            s += '\n';
        }
        return s;
    }
    
    public void solve() {
        
        int x = -1;
        int y = -1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 'S') {
                    x = j;
                    y = i;
                }
            }
            if (x >= 0) break;
        }
        findPath(x, y);
        maze[y][x] = 'S';
        System.out.println(toString(this.maze));
    }
    
    private boolean findPath(int x, int y) {
        
        if (x >= width || y >= length || x < 0 || y < 0) return false;
        if (this.maze[y][x] == 'G') return true;
        if (this.maze[y][x] != '.' && this.maze[y][x] != 'S') return false;
        this.maze[y][x] = '+';
        if (findPath(x, y+1)) return true;
        if (findPath(x+1, y)) return true;
        if (findPath(x, y-1)) return true;
        if (findPath(x-1, y)) return true;
        this.maze[y][x] = 'x';
        return false;
    }
    
}
