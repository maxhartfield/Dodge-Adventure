import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Player extends JComponent{

     int totalCoins;
	 int speed;
	 Rectangle rect;
	 private int x;
	 private int y;
	 private int width;
     private int height;
    public Player(Rectangle rect, int speed)
    {
        totalCoins = 0;
        this.speed = speed;
      this.rect = rect;	
      x = (int)rect.getX();
      y = (int)rect.getY();	
    }

    public void changeSize(int width, int height)
    {
        this.width += width;
        this.height += height;
        rect.setSize(this.width, this.height);
    }
    public void draw(Graphics2D gr)
    {
    	gr.setColor(Color.RED);
    	gr.fill(rect);
    }	
    
    public void movePlayer(int x, int y)
    {
        this.x += x;
    	this.y += y;
    	rect.setLocation(this.x, this.y);
    }
}