/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This project uses Polymorphism to create a particle engine.
 * This is the Main file.
 * 
 * Instructions: 
 *      Drag your mouse around the screen to move the green ball (your avatar). 
 *      Do not get hit by the Red balls - or else you will lose 1 health point!
 *      - Be careful, you only have 3 health points to start with!
 *      
 *      If you touch a yellow ball, you get 1 coin.
 *      You want to win the game by getting 25 coins before you run out of lives!
 *      You can also lose the game if you get -5 coins!
 * 
 *      If you are in a gambling mood, touch the blue balls and you can gamble on what happens!
 *      (more information explaining this in the Power_Up class, & also in the Avatar class where the code is).
 *      
 *      Good Luck and Have fun!
 */

package com.particle_engine_3;

import java.util.ArrayList;

import processing.core.PApplet;


public class Main extends PApplet {

    ArrayList<GameController> controllers = new ArrayList<>();
    
    int curController = GameController.GAME_PLAY;

    public static void main(String[] args) { //sets up processing
        PApplet.main("com.particle_engine_3.Main");
    }

    //sets up the size of the window
    public void settings()
    {
        size(800, 800);
        controllers.add(new Particle_Container(this) );
        controllers.add(new GameEndController(this) );
        controllers.add(new GameWinController(this) );
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

        if(controllers.get(curController).switchController() > GameController.DO_NOT_CHANGE)
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

    public void mouseDragged()
    {
        controllers.get(curController).mouseDragged();
    }
}