import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.*;


public class GameViewer extends JComponent{

	private static final int WIDTH = 1500;
	private static final int HEIGHT = 800;
	
	boolean level1Flag = true;
	boolean level2Flag = false;
	boolean level3Flag = false;
	boolean level4Flag = false;
	boolean level5Flag = false;
	boolean level6Flag = false;
	boolean level7Flag = false;
	
	int count;
	int deaths;
	int totalCoins;
	Player p;
	Obstacle o1, o2, o3;
	HashSet<Point> removedCoins = new HashSet<>();
	HashMap<Obstacle, String> movingO = new HashMap<>();
	HashMap<Obstacle, Boolean> onScreen = new HashMap<>();
	public GameViewer(Player p) {
    	this.p = p;
		count = 0;
		o1 = new Obstacle(new Rectangle(490, 550, 25, 25), 75);
		o2 = new Obstacle(new Rectangle(1000, 200, 100, 100), 30);
		o3 = new Obstacle(new Rectangle(1050, 390, 50, 10), 10);
		movingO.put(o1, "DOWN");
		onScreen.put(o1, true);
		movingO.put(o2, "LEFT");
		onScreen.put(o2, false);
		movingO.put(o3, "LEFT");
		onScreen.put(o3, false);
		totalCoins = 0;
		deaths = 0;
   }
   

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for(int x = 0; x < WIDTH; x += 40)
		{
			for(int y = 0; y < HEIGHT; y += 40)
			{
				if(!removedCoins.contains(new Point(x, y)) && !level7Flag)
					new Coin(x, y).draw(g2);
			}
		}
		if(level1Flag)
			level1(g2);
		else if(level2Flag)
			level2(g2);
		else if(level3Flag)
			level3(g2);
		else if(level4Flag)
			level4(g2);
		else if(level5Flag)
			level5(g2);
		else if(level6Flag)
			level6(g2);
		else if(level7Flag)
			level7(g2);


	}
	public void movement()
	{
		Obstacle.boundingRect = new ArrayList<>();
		if(count < 1)
		{
			for(Obstacle o : movingO.keySet())
			{
				if(onScreen.get(o))
				{
					ActionListener listener = new TimerListener(this, o, movingO.get(o));
					Timer t = new Timer(o.speed, listener);
					t.start();
				}
			}
			count++;
		}
	}
	public void advancePlayer(int x, int y)
   {
    	p.movePlayer(x, y);
    	repaint();
   }
	public void advanceObstacle(Obstacle o, int x, int y)
	{
		o.moveObstacle(x, y);
		repaint();
	}
   public void removeCoin(Point point)
   {
    	removedCoins.add(point);
    	repaint();
   }

   public void reset()
   {
	   p = new Player(new Rectangle(50, HEIGHT / 2 - 50 / 2, 35, 35), 7);
	   Obstacle.boundingRect = new ArrayList<>();
	   for(Obstacle o : movingO.keySet())
		   resetObstacle(o);
	   removedCoins = new HashSet<>();
	   Coin.boundingRect = new ArrayList<>();
	   repaint();
   }

   public void resetObstacle(Obstacle o)
   {
	   o.reset();
	   repaint();
   }
   public void level1(Graphics2D g2)
    {
		movement();
		helper(0, 0, 50, 800, g2);
		helper(0, 0, 1500, 350, g2);
		helper(0, 450, 400, 350, g2);
		helper(500, 350, 350, 100, g2);
		helper(400, 550, 1100, 250, g2);
		helper(950, 450, 550, 350, g2);
		p.draw(g2);
    }

	public void level2(Graphics2D g2)
	{
		onScreen.put(o1, true);
		movement();
		Obstacle.boundingRect.add(o1.rect);
		helper(0, 0, 50, 800, g2);
		helper(0,0,400,350, g2);
		helper(0, 450, 280, 1000, g2);
		helper(400, 0, 200, 550, g2);
		helper(280, 700, 440, 1000, g2);
		helper(720, 250, 300, 1000, g2);
		helper(600, 0, 500, 50, g2);
		helper(1100, 0, 400, 500, g2);
		helper(1020, 600, 80, 1000, g2);
		helper(1100, 740, 400, 400, g2);
		helper(1160, 400, 500, 200, g2);



		o1.draw(g2, Color.BLUE);
		p.draw(g2);
	}

	public void level3(Graphics2D g2)
	{
		onScreen.put(o1, false);
		movement();
		helper(0, 0, 50, 800, g2);
		helper(0,0,500,350, g2);
		helper(0, 450, 550, 1000, g2);
		helper(0, 720, 1500, 50, g2);
		helper(550, 100, 50, 700, g2);
		helper(0, 0, 1500, 50, g2);
		helper(650, 0, 50, 670, g2);
		helper(850, 200,650, 600, g2);
		p.draw(g2);
	}
	public void level4(Graphics2D g2)
	{
		onScreen.put(o2, true);
		movement();
		Obstacle.boundingRect.add(o2.rect);
		helper(0, 0, 1500, 50, g2);
		helper(0, 720, 1500, 70, g2);
		helper(0, 0, 50, 800, g2);
		helper(0, 0, 350, 350, g2);
		helper(0, 450, 1000, 350, g2);
		helper(350, 0, 100, 300, g2);
		helper(420, 350, 120, 300, g2);
		helper(540, 100, 120, 500, g2);
		helper(1100, 0, 500, 500, g2);
		o2.draw(g2, Color.BLUE);
		p.draw(g2);
	}
	
	public void level5(Graphics2D g2)
	{
		onScreen.put(o2, false);
		onScreen.put(o3, true);
		movement();
		Obstacle.boundingRect.add(o3.rect);
		helper(0, 0, 1500, 50, g2);
		helper(0, 720, 1500, 70, g2);
		helper(0, 0, 50, 800, g2);
		helper(0, 440, 1000, 350, g2);
		helper(0, 0, 1000, 350, g2);
		helper(1100, 100, 200, 570, g2);
		helper(1350, 0, 200, 350, g2);
		helper(1350, 400, 200, 400, g2);
		o3.draw(g2, Color.BLUE);
		p.draw(g2);
	}
	
	public void level6(Graphics2D g2)
	{
		onScreen.put(o3, false);
		movement();
		helper(0, 0, 1500, 50, g2);
		helper(0, 720, 1500, 70, g2);
		helper(0, 0, 50, 500, g2);
		helper(0,0, 600, 350, g2);
		helper(0, 450, 300, 350, g2);
		helper(400, 250, 200, 350, g2);
		helper(670, 450, 470, 500, g2);
		helper(600, 325, 270, 75, g2);
		helper(650, 100, 500, 150 , g2);
		helper(950, 100, 50, 350, g2);
		helper(1220, 50, 500, 500, g2);
		helper(1070, 300, 170, 100, g2);
		p.draw(g2);
		
	}
	
	public void level7(Graphics2D g2)
	{
		movement();
		helper(0, 0, 1500, 50, g2);
		helper(0, 720, 1500, 70, g2);
		helper(0, 0, 50, 800, g2);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 50);
		g2.setFont(f);
		g2.setColor(Color.GREEN);
		g2.drawString("Congrats, you win! Play Again -->", 200, HEIGHT / 2);
		g2.drawString("Total Deaths: " + deaths + " Total Coins: " + totalCoins, 200, HEIGHT / 2 + 100);
		p.draw(g2);
	}

    
    private void helper(int x, int y, int length, int width, Graphics2D g2)
    {
			Obstacle r1 = new Obstacle(new Rectangle(x, y, length, width));
			r1.draw(g2, Color.BLACK);
    }
}