import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class DATester extends JComponent{
	private static final int WIDTH = 1500;
	private static final int HEIGHT = 800;
	private static final int X_START = 50;
	private static final int Y_START = HEIGHT / 2 - 50 / 2;
	private static final int SIDE_LENGTH = 35;
	private static final int SPEED = 7;
	
    public static void main(String[] args) {
		
		JFrame frame = new JFrame("Dodge Adventure");
		GameViewer game = new  GameViewer(new Player(new Rectangle(X_START, Y_START, SIDE_LENGTH, SIDE_LENGTH), SPEED));
		PlayerMovement pm = new PlayerMovement(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(new DATester());
		frame.add(pm);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }
    
}