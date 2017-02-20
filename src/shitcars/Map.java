/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shitcars;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author carls
 */
public class Map {
    
    public static final float GRAVITY = 0.2f;
    public static final float ANGULAR_FORCE = 0.05f;
    public static final float ANGULAR_DRAG = 0.2f;
    
        float[] points = {0,0,70,30,100,50,30,50};
    float[] triangle = {0,0,400,0,400,-100};
    float[] triangle1 = {0,0,-400,0,-400,-100};
    public static ArrayList<Entity> entitys;
    private ArrayList<Car> cars;
    private int bestScore;
    
    public static float viewX,viewY;
    
    
    public Map(){
        entitys = new ArrayList();
        cars = new ArrayList();
        

        
        
        
        for(int i = 0; i < 5 ; i++){
            
               cars.add(new Car(230,200 - 200 * i,new Polygon(points)));
        cars.get(i).addWheelCollider(new WheelCollider(100,90,20,50,cars.get(i)));
        cars.get(i).addWheelCollider(new WheelCollider(0,90,20,50,cars.get(i)));
        
        }
        generateMap();
        
        
        for(Car c : cars){
            entitys.add(c);
        }
        
    }
    
    public void generateMap(){
       entitys.add(new Platform(0,400,new Rectangle(0,0,40000,20)));
       entitys.add(new Platform(400,400,new Rectangle(0,0,400,20)));
        cars.add(new Car(300,300,new Polygon(triangle)));
        
    }
    
    public void update(){
        for(Entity e : entitys){
            e.update();
        }
        
        Car firstCar = cars.get(0);
        for(Car c : cars){
            if(c.x > firstCar.x){
                firstCar = c;
                bestScore = c.getScore();
            }
        }
        viewX = -firstCar.x + 300;
        viewY = -firstCar.y + 100;
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
        g.drawString("Best Score: " + bestScore, 50,50);
    }

    /**
     * @return the cars
     */
    public ArrayList<Car> getCars() {
        return cars;
    }
    
    
    
}
