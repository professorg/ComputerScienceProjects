/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.raycast;

import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class Raycast {      // Based on @link http://lodev.org/cgtutor/files/raycaster_flat.cpp
    
    public static int[][] map = {
        {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,1,0,0,0,0,4,4,4,0,0,0,8},
        {8,0,0,0,1,0,0,0,0,4,0,4,0,0,0,8},
        {8,0,0,0,1,1,0,0,0,4,4,4,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,1,2,1,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,5,4,3,2,1,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
        {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}
    };
    
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    
    public static void main(String[] args) {
        
        double posX = 8;    // Initial player pos
        double posY = 8;
        double dirX = -1;   // Initial look direction
        double dirY = 0;
        double planeX = 0;  // Camera plane
        double planeY = 0;
        
        double now = 0;     // Time now
        double then = 0;    // Time before
        
        BufferedImage img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        ImagePanel panel = new ImagePanel(img); // Swing stuff
        JFrame frame = new JFrame();
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Container pane = frame.getContentPane();
        frame.add(panel);
        frame.setVisible(true);
        
        while(true) {
            
            long stop = System.nanoTime() + 1000000 / 60;

            for (int x = 0; x < SCREEN_WIDTH; x++) {
                
                double cameraX = 2 * x / (double) SCREEN_WIDTH - 1;
                double rayPosX = posX;
                double rayPosY = posY;
                double rayDirX = dirX + planeX * cameraX;
                double rayDirY = dirY + planeY * cameraX;
                // Which tile are we in
                int mapX = (int) posX;
                int mapY = (int) posY;
                
                // Length to next side
                double sideDistX;
                double sideDistY;
                
                double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
                double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
                double perpWallDist;
                
                int stepX;
                int stepY;
                
                int hit = 0;
                int side = -1;
                if (rayDirX < 0) {
                    stepX = -1;
                    sideDistX = (rayPosX - mapX) * deltaDistX;
                } else {
                    stepX = 1;
                    sideDistX = (mapX + 1.0 - rayPosX) * deltaDistX;
                }
                if (rayDirY < 0) {
                    stepY = -1;
                    sideDistY = (rayPosY - mapY) * deltaDistY;
                } else {
                    stepY = 1;
                    sideDistY = (mapY + 1.0 - rayPosY) * deltaDistY;
                }
                
                while (hit == 0) {
                    // go to next square
                    if (sideDistX < sideDistY) {
                        sideDistX += deltaDistX;
                        mapX += stepX;
                        side = 0;
                    } else {
                        sideDistY += deltaDistY;
                        mapY += stepY;
                        side = 1;
                    }
                    if (map[mapX][mapY] > 0) hit = 1;
                }
                
                if (side == 0)  perpWallDist = (mapX - rayPosX + (1 - stepX) / 2) / rayDirX;
                else            perpWallDist = (mapY - rayPosY + (1 - stepY) / 2) / rayDirY;
                
                int lineHeight = (int) (SCREEN_HEIGHT / perpWallDist);
                
                int drawStart = -lineHeight / 2 + SCREEN_HEIGHT / 2;
                if (drawStart < 0) drawStart = 0;
                int drawEnd = lineHeight / 2 + SCREEN_HEIGHT / 2;
                if (drawEnd >= SCREEN_HEIGHT) drawEnd = SCREEN_HEIGHT - 1;
                
                Color color;
                switch (map[mapX][mapY]) {
                    case 1: color = Color.RED;      break;
                    case 2: color = Color.GREEN;    break;
                    case 3: color = Color.BLUE;     break;
                    case 4: color = Color.YELLOW;   break;
                    case 5: color = Color.CYAN;     break;
                    case 6: color = Color.MAGENTA;  break;
                    case 8: color = Color.BLACK;    break;
                    default:color = Color.WHITE;    break;
                    
                    
                }
                
                if (side == 1) {
                    int r = color.getRed() / 2;
                    int g = color.getGreen() / 2;
                    int b = color.getBlue() / 2;
                    color = new Color(r,g,b);
                }
                
                for (int i = drawStart; i <= drawEnd; i++) {
                    
                    img.setRGB(x, i, color.getRGB());
                }
                
                frame.repaint();
            }
            
            while (System.nanoTime() < stop);
        }
    }
}
