/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author carls
 */
public abstract class RigidBody extends Entity{
    protected Point2D.Float velocity;
    protected boolean collidable,kinematic;
    protected Shape shape;
    
    
    public RigidBody(float x, float y, Shape shape){
        super(x,y);
        this.shape = shape;
        
    }
    
    @Override
    public void update(){
        if(enabled){
            
        }
    }
    
    @Override
    public void fixedUpdate(){
        if(enabled){
        velocity.y += Map.GRAVITY;
    }
    }
    
    @Override
    public void render(Graphics g){
            if (enabled) {
    g.draw(shape);
    }
    }
    
    public void collide(Shape s){
        
    }
}
