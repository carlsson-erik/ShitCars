package shitcars;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author carls
 */
public class ShitCars extends BasicGame {

    public final String gameName = "First";
    private long lastTick;
    private Input input;
    private final long FTPS = 30;
    private Map map;

    public ShitCars(String gameName) {
        super(gameName);
        lastTick = System.currentTimeMillis();
        
        map = new Map();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        input = gc.getInput();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        

        
        
        
        if (System.currentTimeMillis() > lastTick + 1000 / FTPS) {
        if(input.isKeyDown(Input.KEY_W)){
            map.getCars().get(0).velocity.y += -1;
        }
        if(input.isKeyDown(Input.KEY_S)){
            map.getCars().get(0).velocity.y += 1;
            
        }
        if(input.isKeyDown(Input.KEY_A)){
            map.getCars().get(0).velocity.x += -1;
            
        }
        if(input.isKeyDown(Input.KEY_D)){
            map.getCars().get(0).velocity.x += 1;
            
        }
            map.fixedUpdate();

            lastTick = System.currentTimeMillis();
        }

        map.update();
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        map.render(g);
    }

    public void generateCars(Car car) {

    }
    
    

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new ShitCars("Shit Cars"));
            appgc.setDisplayMode(640, 480, false);
            appgc.setTargetFrameRate(60);
            
            appgc.start();
        } catch (SlickException ex) {

        }

    }

}
