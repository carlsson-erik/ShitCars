/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;

/**
 *
 * @author carls
 */
public class Map {
    
    public static final float GRAVITY = 9.82f;
    
    public static ArrayList<Entity> entitys;
    
    public Map(){
        entitys = new ArrayList();
      
    }
    
    public void update(){
        for(Entity e : entitys){
            e.update();
        }
    }
    
    public void fixedUpdate(){
        for(Entity e : entitys){
            e.fixedUpdate();
        }
    }
    
    public void render(Graphics g){
        for(Entity e : entitys){
            e.render(g);
        }
    }
    
    
}
