
package shitcars;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Erik
 */
public class Platform extends RigidBody{

    public Platform(float x, float y, Shape shape) {
        super(x, y, shape);
        kinematic = true;
    }
    
    @Override
    public void update(){
        super.update();
    }
    
    @Override
    public void fixedUpdate(){
        super.fixedUpdate();
        
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
    }
    
    
}
