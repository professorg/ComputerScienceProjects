package computerscienceprojects.chapter6.rectangle;

// Represents a circle

import java.awt.*;

public class Rectangle {

   private int x, y, w, h;
   private Color color;

   public Rectangle(int x, int y, int w, int h, Color c){
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      color = c;
   }

   public void draw(Graphics g){
      Color oldColor = g.getColor();
      g.setColor(color);
      g.drawRect(x, y, w, h);
      g.setColor(oldColor);
   }

   public void fill(Graphics g){
      Color oldColor = g.getColor();
      g.setColor(color);
      g.fillRect(x, y, w, h);
      g.setColor(oldColor);
   }

   public boolean containsPoint(int x, int y){
       return (x >= this.x &&
               x <= this.x + w &&
               y >= this.y &&
               y <= this.y + h);
   }

   public void move(int xAmount, int yAmount){
      x += xAmount;
      y += yAmount;
   }
}



