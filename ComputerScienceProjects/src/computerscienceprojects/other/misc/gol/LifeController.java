/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.gol;

import java.util.Scanner;

/**
 *
 * @author gvandomelen19
 */
public class LifeController {

    // 0 - die, 1 - sustain, 2 - born
    public static int[] RULES = {0, 0, 1, 2, 0, 0, 0, 0};

    private Cell[][] grid;
    private int generation;
    private boolean textOutput;

    public LifeController(int sizeX, int sizeY) {

        this.grid = new Cell[sizeX + 2][sizeY + 2];
    }

    public void start() {

        // Populate grid with dead cells.
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new Cell(false);
            }
        }
        
        boolean populating = true;
        Scanner scanner = new Scanner(System.in);
        while (populating) {
            
            System.out.print("Toggle point at: ");
            String s = scanner.nextLine();
            String[] strs = s.replace(" ", "").replace("\t", "").split(",");  // Sanitize and split
            if (strs.length < 2) {
                System.out.println("Enter points in the form x,y");
                continue;
            }
            try {
                int[] coords = {Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
            } catch (ArrayIndexOutOfBoundsException e) {
                
                System.out.println("Points must be integers in the form x,y");
                continue;
            }
        }
        scanner.close();

        // Game loop
        while (true) {

            long stop = System.currentTimeMillis() + 1000 / 60;
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
            System.out.print(this);
            while (System.currentTimeMillis() < stop);  // Lock at 60 per second
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
