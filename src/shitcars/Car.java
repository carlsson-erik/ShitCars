/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author carls
 */
public class Car extends RigidBody{

    private ArrayList<WheelCollider> wheels;
    
    public Car(float x, float y, Shape shape) {
        super(x, y, shape);
        this.shape = shape;
    }
    
    public void addWheel(float x, float y, float radius){
        wheels.add(new WheelCollider(x,y,radius,this));
        
    }
    
}
