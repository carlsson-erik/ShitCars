/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author carls
 */
public class Ranger extends Entity{

    private float length;
    private Rectangle rect;
    private ArrayList<Entity> ignoreEntitys;
    
    public Ranger(float x, float y, float length) {
        super(x, y);
        this.length = length;
        rect = new Rectangle(x,y,1,length);
    }
    
    @Override
    public void update(){
        
    }
    
    @Override
    public void fixedUpdate(){
        if(enabled){
            rect.setLocation(x, y);
            for(Entity e : Map.entitys){
                if(!ignoreEntitys.contains(e)){
                    
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g){
        g.draw(rect);
    }
    
}
