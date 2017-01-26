/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.raycast;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class Raycast extends KeyAdapter {      // Based on @link http://lodev.org/cgtutor/files/raycaster_flat.cpp
    
    private static Map<Integer, Boolean> keys = new HashMap();
    
    public static int[][] map = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,1,0,0,0,0,4,4,4,0,0,0,1},
        {1,0,0,0,1,0,0,0,0,4,0,4,0,0,0,1},
        {1,0,0,0,1,1,0,0,0,4,4,4,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,5,4,3,2,1,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 800;
    
    public static void main(String[] args) {  
        
        double posX = 1.5;    // Initial player pos
        double posY = 1.5;
        double dirX = -1;   // Initial look direction
        double dirY = 0;
        double planeX = 0;  // Camera plane
        double planeY = 0.66;
        
        long now = System.nanoTime();     // Time now
        long then = now;    // Time before
        
        BufferedImage img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        ImagePanel panel = new ImagePanel(img); // Swing stuff
        JFrame frame = new JFrame();
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Container pane = frame.getContentPane();
        frame.add(panel);
        frame.setVisible(true);
        
        frame.addKeyListener(new Raycast());
        
        while(true) {
            
            // long stop = System.nanoTime() + 1000000 / 60;

            for (int x = 0; x < SCREEN_WIDTH; x++) {
                
                double cameraX = 2 * x / (double) SCREEN_WIDTH - 1;
                //System.out.println("CameraX: " + cameraX);
                //System.out.println("PlaneX: " + planeX);
                double rayPosX = posX;
                double rayPosY = posY;
                double rayDirX = dirX + planeX * cameraX;
                double rayDirY = dirY + planeY * cameraX;
                //System.out.println("RayDirX: " + rayDirX);
                //System.out.println("RayDirY: " + rayDirY);
                // Which tile are we in
                int mapX = (int) rayPosX;
                int mapY = (int) rayPosY;
                
                // Length to next side
                double sideDistX;
                double sideDistY;
                
                double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
                double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
                double perpWallDist;
                
                int stepX;
                int stepY;
                
                int hit = 0;
                int side = 0;
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
                
                // ////System.out.println("Perpendicular wall distance: " + perpWallDist);
                
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
                    case 7: color = Color.BLACK;    break;
                    default:color = Color.WHITE;    break;
                    
                    
                }
                
                if (side == 1) {
                    int r = color.getRed() / 2;
                    int g = color.getGreen() / 2;
                    int b = color.getBlue() / 2;
                    color = new Color(r,g,b);
                }
                                
                
                fillBlackLine(img, x);
                //vertLine(img, x, drawStart, drawEnd, color.getRGB());
                //////System.out.println("Start: " + drawStart);
                //////System.out.println("End: " + drawEnd);
                for (int i = drawStart; i <= drawEnd; i++) {
                   
                    img.setRGB(x, i, color.getRGB());
                    // ////System.out.println(i);
                }
                
            }
            
            then = now;
            now = System.nanoTime();
            double frameTime = (now - then) / 1000000000.0;    // delta t in seconds
            
            drawMinimap(img, 0, 0, 10.0, posX, posY, dirX, dirY);
                
            panel.repaint();
            
            double moveSpeed = frameTime * 5.0;
            double rotSpeed = frameTime * 3.0;
            
            if (keys.get(KeyEvent.VK_W) != null) {
                
                if (map[(int) (posX + dirX * moveSpeed)][(int) posY] == 0) posX += dirX * moveSpeed;
                if (map[(int) posX][(int) (posY + dirY * moveSpeed)] == 0) posY += dirY * moveSpeed;
            }
            if (keys.get(KeyEvent.VK_S) != null) {
                
                if (map[(int) (posX - dirX * moveSpeed)][(int) posY] == 0) posX -= dirX * moveSpeed;
                if (map[(int) posX][(int) (posY - dirY * moveSpeed)] == 0) posY -= dirY * moveSpeed;
            }
            if (keys.get(KeyEvent.VK_D) != null) {
                
                double oldDirX = dirX;
                dirX = dirX * Math.cos(-rotSpeed) - dirY * Math.sin(-rotSpeed);
                dirY = oldDirX * Math.sin(-rotSpeed) + dirY * Math.cos(-rotSpeed);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(-rotSpeed) - planeY * Math.sin(-rotSpeed);
                planeY = oldPlaneX * Math.sin(-rotSpeed) + planeY * Math.cos(-rotSpeed);
            }
            if (keys.get(KeyEvent.VK_A) != null) {
                
                double oldDirX = dirX;
                dirX = dirX * Math.cos(rotSpeed) - dirY * Math.sin(rotSpeed);
                dirY = oldDirX * Math.sin(rotSpeed) + dirY * Math.cos(rotSpeed);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(rotSpeed) - planeY * Math.sin(rotSpeed);
                planeY = oldPlaneX * Math.sin(rotSpeed) + planeY * Math.cos(rotSpeed);
            }
            if (keys.get(KeyEvent.VK_ESCAPE) != null) System.exit(0);
            
            ////System.out.printf("Pos: (%f,%f)%n", posX, posY);
            ////System.out.printf("Dir: (%f,%f)%n", dirX, dirY);
            
            // while (System.nanoTime() < stop);
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e) {
                continue;
            }
        }
        
    }
    
    private static void fillBlackLine(BufferedImage img, int x) {
        
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            
            img.setRGB(x, i, 0);
        }
    }
    
    private static void vertLine(BufferedImage img, int x, int drawStart, int drawEnd, int color) {
        
        for (int i = drawStart; i <= drawEnd; i++) {
            
            img.setRGB(x, i, color);
        }
    }
    
    private static void drawMinimap(BufferedImage img, int x, int y, double scale, double posX, double posY, double dirX, double dirY) {
        
        outer: for (int i = 0; i < map.length; i++) {
            
            inner: for (int j = 0; j < map[0].length; j++) {
                
                if ((int) (x + i * scale) >= SCREEN_WIDTH || (int) (x + i * scale) < 0) break outer;
                if ((int) (y + j * scale) >= SCREEN_HEIGHT || (int) (y + j * scale) < 0) break inner;
                Color color;
                switch (map[i][j]) {
                    case 1: color = Color.RED;      break;
                    case 2: color = Color.GREEN;    break;
                    case 3: color = Color.BLUE;     break;
                    case 4: color = Color.YELLOW;   break;
                    case 5: color = Color.CYAN;     break;
                    case 6: color = Color.MAGENTA;  break;
                    case 7: color = Color.BLACK;    break;
                    default:color = Color.WHITE;    break;
                }
                outerpix: for (int k = 0; k < Math.round(scale); k++) {
                    
                    innerpix: for (int l = 0; l < Math.round(scale); l++) {
                        
                        if ((int) (x + i * scale + k) >= SCREEN_WIDTH || (int) (x + i * scale + k) < 0) break innerpix;
                        if ((int) (y + j * scale + l) >= SCREEN_HEIGHT || (int) (y + j * scale + l) < 0) break outerpix;
                        img.setRGB((int) (x + i * scale + k), (int) (y + j * scale + l), color.getRGB());
                    }
                }
            }
        }
        pos: {
            if ((int) (x + posX * scale) >= SCREEN_WIDTH || (int) (x + posX * scale) < 0) break pos;
            if ((int) (y + posY * scale) >= SCREEN_HEIGHT || (int) (y + posY * scale) < 0) break pos;
            outer: for (int i = 0; i < Math.ceil(0.25 * scale); i++) {

                inner: for (int j = 0; j < Math.ceil(0.25 * scale); j++) {

                    if ((int) (x + posX * scale + i) >= SCREEN_WIDTH || (int) (x + posX * scale + i) < 0) break inner;
                    if ((int) (y + posY * scale + j) >= SCREEN_HEIGHT || (int) (y + posY * scale + j) < 0) break outer;
                    img.setRGB((int) (x + posX * scale + i), (int) (y + posY * scale + j), Color.GRAY.getRGB());
                }
            }
        }
        dir: {
            if ((int) (x + (posX + 0.125) * scale) >= SCREEN_WIDTH || (int) (x + (posX + 0.125) * scale) < 0) break dir;
            if ((int) (y + (posY + 0.125) * scale) >= SCREEN_HEIGHT || (int) (y + (posY + 0.125) * scale) < 0) break dir;
            for (int i = 0; i < scale; i++) {
                
                if ((int) (x + (posX + 0.125) * scale + dirX * i) >= SCREEN_WIDTH || (int) (x + (posX + 0.125) * scale + dirX * i) < 0) break dir;
                if ((int) (y + (posY + 0.125) * scale + dirY * i) >= SCREEN_HEIGHT || (int) (y + (posY + 0.125) * scale + dirY * i) < 0) break dir;
                img.setRGB((int) (x + (posX + 0.125) * scale + dirX * i), (int) (y + (posY + 0.125) * scale + dirY * i), Color.GRAY.getRGB());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        keys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        keys.remove(e.getKeyCode());
    }
}
