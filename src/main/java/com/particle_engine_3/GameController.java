package com.particle_engine_3;

import processing.core.PApplet;

public abstract class GameController {
    PApplet main; //reference to the main class

    GameController(PApplet main_)
    {
        main = main_;
    }

    public abstract void draw();
    //public abstract void mouseDragged();
    public abstract void keyPressed();
    

}
