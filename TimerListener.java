import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    private Obstacle o;
    private GameViewer game;
    private int x;
    private int y;

    public TimerListener(GameViewer game, Obstacle o, String dir)
    {
        this.game = game;
        this.o = o;
        x = 0;
        y = 0;
        if(dir.equals("DOWN"))
            y = 10;
        if(dir.equals("UP"))
            y = -10;
        if(dir.equals("LEFT"))
            x = -10;
        if(dir.equals("RIGHT"))
            x = 10;
    }
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < Obstacle.boundingRect.size(); i++)
        {
            if(Obstacle.boundingRect.get(i).equals(o.rect))
                continue;
            if(o.rect.intersects(Obstacle.boundingRect.get(i)))
            {
                game.resetObstacle(o);
            }
        }
        game.advanceObstacle(o, x, y);
    }
}
