/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This project uses Polymorphism to create a particle engine.
 * This is the Main file.
 */

package com.particle_engine_3;

import java.util.ArrayList;

import processing.core.PApplet;


public class Main extends PApplet {

    //Particle_Container container; //controls the particles
    ArrayList<GameController> controllers = new ArrayList<>();
    int gameplay = 0;
    int end = 1;
    int curController = 0;

    public static void main(String[] args) { //sets up processing
        PApplet.main("com.particle_engine_3.Main");
    }

    //sets up the size of the window
    public void settings()
    {
        size(800, 800);
        controllers.add(new Particle_Container(this) );
        controllers.add(new GameEndController(this) );
    }
    
    /*
     * This is the setup function
     */
    public void setup()
    {               
        
    } 

    /*
    * This is the main draw function.
    * Draws everything on the screen.
    */
    public void draw()
    {
        controllers.get(curController).draw();

        if(controllers.get(curController).switchController() > -1)
        {
            int nextControl = controllers.get(curController).switchController();
            controllers.get(curController).reset();
            curController = nextControl;
        }
    }

    /*
     * This is the mousePressed method. 
     * When the mouse is pressed, the objects move in the opposite direction.
     */
    public void mousePressed()
    {
        controllers.get(curController).mousePressed();
    }

    public void keyPressed()
    {
        controllers.get(curController).keyPressed();
    }
}