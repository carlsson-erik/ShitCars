/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/**
 *
 * @author carls
 */
public class WheelCollider extends Entity{

    private Ranger ranger;
    private Circle wheel;
    public WheelCollider(float x, float y,float radius,Entity parent) {
        super(x, y);
        this.parent = parent;
        ranger = new Ranger(0,0,100);
        ranger.parent = this;
        wheel = new Circle(x,y,radius);
    }
    
    public void update(){
        if(enabled){
            wheel.setLocation(x, y);
        }
    }
    
    public void fixedUpdate(){
        
    }
    
    public void render(Graphics g){
        
    }
    
    
    
}
