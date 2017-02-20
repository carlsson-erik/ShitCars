/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;


/**
 *
 * @author carls
 */
public abstract class RigidBody extends Entity {

    protected Point2D.Float velocity;
    protected boolean collidable, kinematic;
    protected Shape shape,defaultShape;
    
    protected float mass,angle,angVel;

    public RigidBody(float x, float y, Shape shape) {
        super(x, y);
        this.shape = shape;
        defaultShape = shape;
        collidable = true;
        kinematic = false;
        velocity = new Point2D.Float();
        velocity.x = 0;
        velocity.y = 0;
        angle = 0;
        mass = 100;
            shape.setLocation(x, y);
        
            
    }

    @Override
    public void update() {
        if (enabled) {
            super.update();
            shape.setLocation(x, y);
            
        }
    }

    @Override
    public void fixedUpdate() {
        if (enabled) {
            
               
            if (!kinematic) {
                if(parent == null){
                velocity.y += Map.GRAVITY;// * Math.cos(Math.toRadians(angle));
                
                collide();
                localX += velocity.x;
                localY += velocity.y;
                angle += angVel;
                angVel *= Map.ANGULAR_DRAG;
                
                 shape = (Polygon)defaultShape.transform(Transform.createRotateTransform((float)Math.toRadians(angle), defaultShape.getCenterX(), defaultShape.getCenterY()));
                    
                }
            }
            
            
           
        }
    }

    @Override
    public void render(Graphics g) {

        if (enabled) {
            shape.setLocation(Map.viewX + x, Map.viewY + y);
            g.draw(shape);
            
        }
    }
    
    public void applyOffsetForce(float x, float y,float force,float angle){
        float velocity = force / mass;
        float xVel = (float)Math.cos(Math.toRadians(angle)) * force/mass;
        float yVel = (float)Math.sin(Math.toRadians(angle)) * force/mass;
        
        angVel -= (x - (defaultShape.getCenterX() + this.x)) * yVel * Map.ANGULAR_FORCE;
        
         this.velocity.y -= yVel;
        this.velocity.x += xVel;
    }

    public void collide() {
        for (Entity e : Map.entitys) {
            if(e.enabled){
            if (e instanceof RigidBody) {
                if (e != this) {
                    shape.setX(x + velocity.x);
                    ((RigidBody)e).shape.setX(((RigidBody)e).velocity.x + ((RigidBody)e).x);
                    if (shape.intersects(((RigidBody)e).shape)) {
                        shape.setX(x);
                        ((RigidBody)e).shape.setX(((RigidBody)e).x);
                        velocity.x = 0;
                    }
                    shape.setY(y + velocity.y);
                    ((RigidBody)e).shape.setY(((RigidBody)e).velocity.y + ((RigidBody)e).y);
                    if (shape.intersects(((RigidBody)e).shape)) {
                        shape.setY(y);
                        ((RigidBody)e).shape.setX(((RigidBody)e).y);
                        velocity.y = 0;
                    }
                }
            }
        }
        }
    }

    public void setKinematic(boolean k){
        kinematic = k;
    }

    /**
     * @return the angle
     */
    public float getAngle() {
        return angle;
    }
}
