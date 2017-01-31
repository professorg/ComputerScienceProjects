/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.mandelbrot;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author gvandomelen19
 */
public class Mandelbrot extends KeyAdapter {

    public static final int SCREEN_WIDTH = 1600;
    public static final int SCREEN_HEIGHT = 900;
    public static final int MAX_ITERATIONS = 100;
    public static final double DIVERGE = 2.0;

    private static Map<Integer, Boolean> keys = new HashMap();

    public static void main(String[] args) {

        BufferedImage img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);

        ImagePanel panel = new ImagePanel(img);
        JFrame frame = new JFrame();
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setVisible(true);

        frame.addKeyListener(new Mandelbrot());

        double centerX = 0;
        double centerY = 0;
        double zoom = 1;

        loop:
        while (true) {
            
            //long stop = System.nanoTime() + 1000000000 / 60;
            fillBlack:
            for (int x = 0; x < SCREEN_WIDTH; x++) {

                for (int y = 0; y < SCREEN_HEIGHT; y++) {

                    img.setRGB(x, y, 0);
                }
            }
            draw:
            {

                for (int x = 0; x < SCREEN_WIDTH; x++) {

                    for (int y = 0; y < SCREEN_HEIGHT; y++) {
                        
                        Complex c = new Complex(centerX + (x - SCREEN_WIDTH / 2) / zoom, centerY + (y - SCREEN_HEIGHT / 2) / zoom);
                        Complex z = new Complex(0);
                        for (int i = 0; i < MAX_ITERATIONS; i++) {
                            Color color = new Color(Color.HSBtoRGB((float) i / MAX_ITERATIONS, 1.0f, 1.0f));
                            if (Complex.norm(z) > DIVERGE) {
                                img.setRGB(x, y, color.getRGB());
                                break;
                            } else {
                                
                                double real = z.getReal();
                                double imag = z.getImag();
                                z = new Complex(real * real - imag * imag + c.getReal(), 2.0 * real * imag + c.getImag());
                            }
                        }
                        
                    }
                }

                panel.repaint();
            }
            keys:
            while (true) {

                if (keys.get(KeyEvent.VK_EQUALS) != null) {
                    zoom *= 2;
                    break;
                }
                if (keys.get(KeyEvent.VK_MINUS) != null) {
                    zoom /= 2;
                    break;
                }
                if (keys.get(KeyEvent.VK_D) != null) {
                    centerX += SCREEN_WIDTH / 2 / zoom;
                    break;
                }
                if (keys.get(KeyEvent.VK_A) != null) {
                    centerX -= SCREEN_WIDTH / 2 / zoom;
                    break;
                }
                if (keys.get(KeyEvent.VK_S) != null) {
                    centerY += SCREEN_HEIGHT / 2 / zoom;
                    break;
                }
                if (keys.get(KeyEvent.VK_W) != null) {
                    centerY -= SCREEN_HEIGHT / 2 / zoom;
                    break;
                }
                if (keys.get(KeyEvent.VK_ESCAPE) != null) {
                    System.exit(0);
                }
            }
            try {
                //while (System.nanoTime() < stop);
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.exit(0);
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
