/*
 * Prescott Lau
 * September 30th
 * This class is the avatar class. It represents the user & moves with mouseDrag.
 */

package com.particle_engine_3;

import processing.core.PApplet;

public class Avatar extends Particle_Object{

    int health = 3; //health, determines when the game ends.

    Avatar(PApplet main_)
    {
        super(main_, 45, main_.color(255,165,0), 255);
        x = main.width/2;
        y = main_.height/2;
    }

    void setLocation(float x_, float y_)
    {
        x = x_;
        y = y_;
    }

    //if a collision happened, deduct health!
    void collision(Particle_Object object)
    {   
        // hit = isHit(object);
        // if (hit)
        // {
            // if(object instanceof Enemy)
            // {
            //     health--;
            //     System.out.println("Health = " + health);
            // }

            // if(object instanceof NPC)
            // {
            //     float randomValue = main.random(1, 2);
            //     object.xVel += randomValue;
            //     object.yVel += randomValue;
            // }
        // }
    }

    //getter for the health variable
    float getHealth()
    {
        return health;
    }
}
