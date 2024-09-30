/*
 * Prescott Lau
 * September 30th
 * This class extends the gameController class and controls the End Screen.
 */
package com.particle_engine_3;

import processing.core.PApplet;

public class GameEndController extends GameController {
    GameEndController(PApplet main_)
    {
        super(main_);
    }

    public void draw()
    {
        main.background(0);
        main.fill(255);
        main.textSize(35);
        main.text("Game Over!", (main.width/2)-125, (main.height/2)-150);
        main.text("Press spacebar to restart!", (main.width/2)-225, (main.height/2)+25);

    }
    public void mousePressed()
    {

    }

    public void mouseDragged()
    {

    }

    public void keyPressed()
    {
        if (main.keyPressed)
        {
            if( main.key == ' ') //if spacebar is pressed, then do below...
            {
                nextController = 0; //go back to gameplay!
            }
        }  
    } 

}
