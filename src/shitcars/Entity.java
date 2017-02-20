/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import org.newdawn.slick.Graphics;

/**
 *
 * @author carls
 */
public abstract class Entity {

    protected float localX, localY, x, y;
    protected Entity parent;
    protected boolean enabled;

    public Entity(float x, float y) {
        localX = x;
        localY = y;
        enabled = true;
    }

    public void update() {
        if (enabled) {
            if (parent != null) {

                if (parent instanceof RigidBody) {
                    x = (float) (Math.cos(Math.toRadians(((RigidBody) parent).angle))) * (localX - ((RigidBody) parent).defaultShape.getCenterX()) + parent.x + ((RigidBody) parent).defaultShape.getCenterX();

                    if ((localX - ((RigidBody) parent).defaultShape.getCenterX()) > 0) {
                        y = (float) (Math.sin(Math.toRadians(((RigidBody) parent).angle))) * (localY - ((RigidBody) parent).defaultShape.getCenterY()) + parent.y + ((RigidBody) parent).defaultShape.getCenterY();
                    } else {
                        y = (float) (Math.sin(Math.toRadians(((RigidBody) parent).angle))) * -(localY - ((RigidBody) parent).defaultShape.getCenterY()) + parent.y + ((RigidBody) parent).defaultShape.getCenterY();
                    }

                } else {

                    x = localX + parent.x;
                    y = localY + parent.y;
                }

            } else {
                x = localX;
                y = localY;
            }
        }
    }

    public void fixedUpdate() {

    }

    public void render(Graphics g) {
        if (enabled) {

        }
    }

}
