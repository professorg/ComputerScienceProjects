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
        
        String maze = "6 6 "
                + "#S#..#"
                + "#...##"
                + "..#..."
                + ".#..#."
                + "###.#."
                + "#...#G";
        MazeSolver solver = new MazeSolver(maze);
        solver.solve();
        maze = "6 6 "
                + "###..#"
                + "#..S##"
                + "..#..."
                + ".#..#."
                + "###.#."
                + "G#..#.";
        solver = new MazeSolver(maze);
        solver.solve();
        maze = "6 6 "
                + "G....."
                + "......"
                + "......"
                + "......"
                + "......"
                + ".....S";
        solver = new MazeSolver(maze);
        solver.solve();
        
        maze = MazeGenerator.generate(7, 5);
        solver = new MazeSolver(maze);
        System.out.println(solver.toString(solver.maze));
    }
}
