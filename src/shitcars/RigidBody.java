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
public abstract class RigidBody extends Entity {

    protected Point2D.Float velocity;
    protected boolean collidable, kinematic;
    protected Shape shape;

    public RigidBody(float x, float y, Shape shape) {
        super(x, y);
        this.shape = shape;
        collidable = true;
        kinematic = false;
        velocity = new Point2D.Float();
        velocity.x = 0;
        velocity.y = 0;

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
                velocity.y += Map.GRAVITY;
                collide();
                localX += velocity.x;
                localY += velocity.y;
                }
            }

        }
    }

    @Override
    public void render(Graphics g) {

        if (enabled) {
            g.draw(shape);

        }
    }

    public void collide() {
        for (Entity e : Map.entitys) {
            if (e instanceof RigidBody) {
                if (e != this) {
                    shape.setX(x + velocity.x);
                    if (shape.intersects(((RigidBody)e).shape)) {
                        shape.setX(x);
                        velocity.x = 0;
                    }
                    shape.setY(y + velocity.y);
                    if (shape.intersects(((RigidBody)e).shape)) {
                        shape.setY(y);
                        velocity.y = 0;
                    }
                }
            }
        }
    }
    
    public void setKinematic(boolean k){
        kinematic = k;
    }
}
