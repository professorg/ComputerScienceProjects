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
public class MazeClient {
    
    public static void main(String[] args) {
        
        String maze;
        MazeSolver solver;
        for (int i = 0; i < 100; i++) {
            maze = MazeGenerator.generate(500, 500);
            solver = new MazeSolver(maze);
            solver.solve();
        }
    }
}
