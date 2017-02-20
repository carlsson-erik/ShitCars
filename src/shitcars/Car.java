/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author carls
 */
public class Car extends RigidBody{

    private ArrayList<WheelCollider> wheels;
    private int score;
    
    public Car(float x, float y, Shape shape) {
        super(x, y, shape);
        wheels = new ArrayList();
    }
    
    public void addWheelCollider(WheelCollider wheel){
        wheels.add(wheel);
        wheels.get(wheels.size()-1).parent = (Entity)this;
        
        
    }
    @Override
    public void update(){
        super.update();
        for(WheelCollider w : wheels){
            w.update();
            
        }
        if(x > score){
            score = (int)x;
        }
        
    }
    
    @Override
    public void fixedUpdate(){
        super.fixedUpdate();
        
        boolean anyWheelGrounded = false;
        for(WheelCollider w : wheels){
            w.fixedUpdate();
            
            if(w.isGrounded()){
                anyWheelGrounded = true;
            this.applyOffsetForce(w.x,w.y,(w.distance() * (velocity.y + 2)/3) * 8,90);
            this.applyOffsetForce(w.x, w.y + w.distance(), -velocity.x*4,0);
            this.applyOffsetForce(w.x,w.y + w.distance(),30,0);
            }
            
            
        }
        if(anyWheelGrounded){
            
            velocity.x += Map.GRAVITY * Math.sin(Math.toRadians(angle));
        }
        
        
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
        for(WheelCollider w : wheels){
            w.render(g);
            
        }
    }

    /**
     * @return the wheels
     */
    public ArrayList<WheelCollider> getWheels() {
        return wheels;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
}
