/*
 * Prescott Lau
 * September 30th
 * This class controls the gameplay and everything related to it.
 */
package com.particle_engine_3;

import processing.core.PApplet;

public abstract class GameController {
    PApplet main; //reference to the main class
    int nextController = -1;

    GameController(PApplet main_)
    {
        main = main_;
    }

    public abstract void draw();
    public abstract void mouseDragged();
    public abstract void mousePressed();
    public abstract void keyPressed();

    public int switchController()
    {
        return nextController;
    }

    //resets the next controller
    public void reset()
    {
        nextController = -1; 
    }
}
