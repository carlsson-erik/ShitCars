/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author carls
 */
public class Ranger extends Entity {

    private float length, distance;

    private Rectangle ray;
    private ArrayList<Entity> ignoreEntitys;
    private float resolution;
    private boolean hit;

    public Ranger(float x, float y, float length) {
        super(x, y);
        this.length = length;
        resolution = 1;
        distance = 0;
        ignoreEntitys = new ArrayList();
        ray = new Rectangle(x, y, 1, length);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void fixedUpdate() {
        if (enabled) {
            ray.setLocation(x, y);
            
             float distance = length;
            for (Entity e : Map.entitys) {
                if (e instanceof RigidBody) {
                    if (e.enabled) {
                        
                        if (!ignoreEntitys.contains(e)) {
                            if (ray.intersects(((RigidBody) e).shape)) {
                                float temp = checkDistance(((RigidBody) e).shape, 0);
                                if(temp < distance){
                                    distance = temp;
                                    
                                }
                                

                            }else if(ray.contains(((RigidBody)e).shape)){
                            distance = 0;
                        }
                            
                       }
                    }
                }
            }
            this.distance = distance;
            if(distance != length){
                hit = true;
            }else{
                hit = false;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        ray.setLocation(x + Map.viewX, y + Map.viewY);
        g.draw(ray);
    }

    public float checkDistance(Shape s, int i) {
        ray.setHeight(resolution * i);
        if (!ray.intersects(s)) {
            return checkDistance(s, i + 1);
        } else {
            ray.setHeight(length);
            return resolution * i;
        }
    }
    
    public void ignoreEntity(Entity e){
        ignoreEntitys.add(e);
    }

    /**
     * @param length the length to set
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * @return the length
     */
    public float getLength() {
        return length;
    }

    /**
     * @return the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @return the hit
     */
    public boolean isHit() {
        return hit;
    }

}
