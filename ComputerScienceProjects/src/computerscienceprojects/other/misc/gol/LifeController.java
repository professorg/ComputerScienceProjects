/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.gol;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class LifeController {

    // 0 - die, 1 - sustain, 2 - born
    public static int[] RULES = {0, 0, 1, 2, 0, 0, 0, 0, 0};

    private Cell[][] grid;
    private int generation;
    private boolean textOutput;

    public LifeController(int sizeX, int sizeY) {

        this.grid = new Cell[sizeY + 2][sizeX + 2];
    }

    public void start() {

        // Populate grid with dead cells.
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Cell();
            }
        }
        
        boolean populating = true;
        Scanner scanner = new Scanner(System.in);
        while (populating) {
            
            System.out.print(toString());
            System.out.print("Toggle point at: ");
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("quit") || s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("")) {
                populating = false;
                continue;
            } else if (s.split(" ").length > 0 && s.split(" ")[0].equalsIgnoreCase("random")) {
                try {
                    if (s.split(" ").length > 1) {
                        double threshold = Double.parseDouble(s.split(" ")[1]);
                        random(threshold);
                    } else {
                        random(0.5);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Random threshold must be a double.");
                }
            }
            String[] strs = s.replace(" ", "").replace("\t", "").split(",");  // Sanitize and split
            if (strs.length < 2) {
                System.out.println("Enter points in the form x,y");
                continue;
            }
            try {
                int[] coords = {Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
                if (coords[0] <= 0 || coords[1] <= 0 || coords[0] > grid[0].length - 2 || coords[1] > grid.length - 2) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                Cell c = grid[coords[1]][coords[0]];
                c.setAliveNext(!c.getAlive());
                c.update();
            } catch (NumberFormatException e) {
                System.out.println("Points must be integers in the form x,y");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Points must be between (1,1) and (" + (grid[0].length - 2) + "," + (grid.length - 2) + ")");
                continue;
            }
        }
        scanner.close();

        // Game loop
        while (true) {

            long stop = System.nanoTime() + 1000000000;
            for (int row = 1; row < grid.length - 1; row++) {
                for (int col = 1; col < grid[row].length - 1; col++) {
                    switch (RULES[getNeighbors(row, col)]) {
                        case 0:
                            grid[row][col].setAliveNext(false);
                            break;
                        case 1:
                            /* Do Nothing */ break;
                        case 2:
                            grid[row][col].setAliveNext(true);
                            break;
                    }
                }
            }
            for (Cell[] row : grid) {
                for (Cell cell : row) {
                    cell.update();
                }
            }
            System.out.println("\nGeneration " + generation + "\n" + this);
            ++generation;
            while (System.nanoTime() < stop);  // Lock at 1 per second
        }
    }

    private int getNeighbors(int x, int y) {

        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                neighbors += grid[x + i][y + j].getAlive() ? 1 : 0;
            }
        }
        return neighbors;
    }
    
    private void random(double threshold) {
        Random r = new Random();
        for (int row = 1; row < grid.length-1; row++) {
            for (int col = 1; col < grid[row].length - 1; col++) {
                grid[row][col].setAliveNext(r.nextDouble() <= threshold);
                grid[row][col].update();
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int row = 1; row < grid.length - 1; row++) {
            for (int col = 1; col < grid[row].length - 1; col++) {
                if (grid[row][col].getAlive())  str += "#";
                else                            str += "-";
            }
            str += "\n";
        }
        return str;
    }
}
