import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.*;
import java.util.List;

public class Coin extends JComponent{

	 private Ellipse2D elli;

	 static List<Rectangle> boundingRect = new ArrayList<>();
	 private static final int SIDE_LENGTH = 10;


    
    public Coin(int x, int y) {
    	elli = new Ellipse2D.Double(x, y, SIDE_LENGTH, SIDE_LENGTH);
		boundingRect.add(elli.getBounds());
    }
    
    public void draw(Graphics2D gr)
    {
		gr.setColor(Color.YELLOW);
        gr.fill(elli);
    }	
    

    

}