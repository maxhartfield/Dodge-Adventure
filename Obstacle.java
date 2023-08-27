import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;


public class Obstacle extends JComponent{

     int speed;
     Rectangle rect;
     private int x;
     private int y;

     private int startX;
     private int startY;
     static List<Rectangle> boundingRect = new ArrayList<>();


    public Obstacle(Rectangle rect, int speed) {
    	this.rect = rect;
        this.speed = speed;
        startX = (int)(rect.getX());
        x = startX;
        startY = (int)(rect.getY());
        y = startY;
        boundingRect.add(rect);
    }
    public Obstacle(Rectangle rect) {
        this.rect = rect;
        this.speed = 0;
        startX = (int)(rect.getX());
        x = startX;
        startY = (int)(rect.getY());
        y = startY;
        boundingRect.add(rect);
    }


    public void changeSize(int width, int height)
    {
        rect.setSize(width, height);

    }
    public void draw(Graphics2D gr, Color clr)
    {
        gr.setColor(clr);
        gr.fill(rect);

    }
    public void moveObstacle(int x, int y)
    {

        this.x += x;
        this.y += y;
        boundingRect.remove(rect);
        rect.setLocation(this.x, this.y);
        boundingRect.add(rect);

    }

    public void reset()
    {
        x = startX;
        y = startY;
        moveObstacle(0, 0);
    }

}