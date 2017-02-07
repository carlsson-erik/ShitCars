/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author carls
 */
public class Map {
    
    public static final float GRAVITY = 0.1f;
    
    public static ArrayList<Entity> entitys;
    private ArrayList<Car> cars;
    
    public Map(){
        entitys = new ArrayList();
        cars = new ArrayList();
        cars.add(new Car(200,300,new Rectangle(0,0,50,50)));
        cars.add(new Car(200,100,new Rectangle(0,0,50,50)));
        cars.add(new Car(100,100,new Circle(0,0,20)));
        
        generateMap();
        
        
        for(Car c : cars){
            entitys.add(c);
        }
        
    }
    
    public void generateMap(){
        entitys.add(new Platform(0,400,new Rectangle(0,0,300,20)));
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

    /**
     * @return the cars
     */
    public ArrayList<Car> getCars() {
        return cars;
    }
    
    
    
}
