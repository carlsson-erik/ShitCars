package shitcars;

import java.awt.geom.Point2D;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



/**
 *
 * @author carls
 */

public class ShitCars extends BasicGame{

    public final String gameName = "First";
    
    public ShitCars(String gameName){
        super(gameName);
    }
    
    
    

    
	@Override
	public void init(GameContainer gc) throws SlickException {
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	
        }

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Howdy!", 10, 10);
	}
        
        
        
    public void generateCars(Car car){
        
    }

	public static void main(String[] args) {
			try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new ShitCars("Shit Cars"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		} catch (SlickException ex) {
		
                }
		
	}
    
}
