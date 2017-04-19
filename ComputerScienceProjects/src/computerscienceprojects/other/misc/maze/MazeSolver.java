/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.maze;

import computerscienceprojects.other.misc.raycast.ImagePanel;
import static computerscienceprojects.util.TerminalColors.*;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class MazeSolver {

    public char[][] maze;
    private int length;
    private int width;
    private static long ID;
    private static final boolean COLOR = true;
    private static final String DIR = "mazes/";
    private static final String FILE = "maze";
    private static final String EXT = ".png";
    private static final int MODE = 1;

    public MazeSolver(String maze) {    // <num> <num> <maze>

        this.maze = fromString(maze);
        this.length = this.maze.length;
        this.width = this.maze[0].length;
        ID++;
    }

    private char[][] fromString(String s) {

        int l = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        s = s.substring(s.indexOf(" ") + 1);
        int w = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        s = s.substring(s.indexOf(" ") + 1);
        char[][] maze = new char[l][w];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                maze[i][j] = s.charAt(j + w * i);
            }
        }
        return maze;
    }
    
    public void show(char[][] maze) {
        
        BufferedImage img = new BufferedImage(width, length, TYPE_INT_RGB);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                switch (maze[i][j]) {
                    case '+':
                        img.setRGB(i, j, 0x00FF00);
                        break;
                    case 'x':
                        img.setRGB(i, j, 0xFF0000);
                        break;
                    case '#':
                        img.setRGB(i, j, 0x000000);
                        break;
                    case '.':
                        img.setRGB(i, j, 0xFFFFFF);
                        break;
                    case 'S':
                        img.setRGB(i, j, 0xFFFF00);
                        break;
                    case 'G':
                        img.setRGB(i, j, 0xFF00FF);
                        break;
                    default:
                        img.setRGB(i, j, 0xFFFFFF);
                        break;
                }
            }
        }
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ImagePanel(img));
        frame.setResizable(false);
        frame.setSize(width, length);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void save(char[][] maze, boolean solved) {

        BufferedImage img = new BufferedImage(width, length, TYPE_INT_RGB);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                switch (maze[i][j]) {
                    case '+':
                        img.setRGB(i, j, 0x00FF00);
                        break;
                    case 'x':
                        img.setRGB(i, j, 0xFF0000);
                        break;
                    case '#':
                        img.setRGB(i, j, 0x000000);
                        break;
                    case '.':
                        img.setRGB(i, j, 0xFFFFFF);
                        break;
                    case 'S':
                        img.setRGB(i, j, 0xFFFF00);
                        break;
                    case 'G':
                        img.setRGB(i, j, 0xFF00FF);
                        break;
                    default:
                        img.setRGB(i, j, 0xFFFFFF);
                        break;
                }
            }
        }
        try {
            File outputFile = new File(DIR+ (solved ? "solved/" : "unsolved/") +FILE+EXT);
            File dir = new File(DIR + (solved ? "solved/" : "unsolved/"));
            if (!dir.exists()) dir.mkdirs();
            if (outputFile.exists()) {
                outputFile.renameTo(new File(DIR + (solved ? "solved/" : "unsolved/") + FILE + "_" + ID + EXT));
            }
            ImageIO.write(img, "png", outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(char[][] maze) {

        String s = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (COLOR) {
                    switch (maze[i][j]) {
                        case '+':
                            s += BG_GREEN.getCol() + maze[i][j] + RESET.getCol();
                            break;
                        case 'x':
                            s += BG_RED.getCol() + maze[i][j] + RESET.getCol();
                            break;
                        case '#':
                            s += BG_BLUE.getCol() + maze[i][j] + RESET.getCol();
                            break;
                        default:
                            s += maze[i][j];
                            break;
                    }
                } else {
                    s += maze[i][j];
                }
            }
            s += '\n';
        }
        return s;
    }

    public void printString(char[][] maze) {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (COLOR) {
                    switch (maze[i][j]) {
                        case '+':
                            System.out.print(BG_GREEN.getCol() + maze[i][j] + RESET.getCol());
                            break;
                        case 'x':
                            System.out.print(BG_RED.getCol() + maze[i][j] + RESET.getCol());
                            break;
                        case '#':
                            System.out.print(BG_BLUE.getCol() + maze[i][j] + RESET.getCol());
                            break;
                        default:
                            System.out.print(maze[i][j]);
                            break;
                    }
                } else {
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println("");
        }
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
            if (x >= 0) {
                break;
            }
        }
        save(this.maze, false);
        System.out.print("Solving...");
        findPath(x, y);
        System.out.println("Done");
        maze[y][x] = 'S';
        System.out.print("Writing...");
//        switch (MODE) {
//            case 0:
//                printString(this.maze);
//                break;
//            case 1:
//                save(this.maze, true);
//                break;
//        }
        System.out.println("Done");
        //printString(this.maze);
        //System.out.println(toString(this.maze));
    }

    private boolean findPath(int x, int y) {

        if (x >= width || y >= length || x < 0 || y < 0) {
            return false;
        }
        if (this.maze[y][x] == 'G') {
            return true;
        }
        if (this.maze[y][x] != '.' && this.maze[y][x] != 'S') {
            return false;
        }
        this.maze[y][x] = '+';
        if (findPath(x, y + 1)) {
            return true;
        }
        if (findPath(x + 1, y)) {
            return true;
        }
        if (findPath(x, y - 1)) {
            return true;
        }
        if (findPath(x - 1, y)) {
            return true;
        }
        this.maze[y][x] = 'x';
        return false;
    }

}
