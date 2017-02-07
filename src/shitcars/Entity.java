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
public class Entity {
    
    protected float localX,localY,x,y;
    protected Entity parent;
    
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void update(){
        
    }
    
    public void fixedUpdate(){
        if(parent !=null){
            x = localX + parent.x;
            y = localY + parent.y;
        }else{
            x = localX;
            y = localY;
        }
        
    }
    
    public void render(Graphics g){
        
    }
    
    
    
}
