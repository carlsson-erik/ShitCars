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
        cars.add(new Car(230,200,new Rectangle(0,0,50,50)));
        cars.get(0).addWheelCollider(new WheelCollider(25,40,20,100,cars.get(0)));
        cars.add(new Car(230,300,new Rectangle(0,0,50,50)));
        cars.add(new Car(100,100,new Circle(0,0,20)));
        cars.add(new Car(0,200,new Circle(0,0,20)));
        cars.add(new Car(30,100,new Circle(0,0,20)));
        
        
        
        for(int i = 0; i < 30 ; i++){
            for(int n = 0; n < 50 ; n++){
       //     cars.add(new Car(n*5,20 + i*5,new Rectangle(0,0,4,4)));
        }
        }
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
