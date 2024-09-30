/*
 * Prescott Lau
 * September 30th
 * This class is the avatar class. It represents the user & moves with mouseDrag.
 */

package com.particle_engine_3;

import processing.core.PApplet;

public class Avatar extends Particle_Object{

    int health = 3; //health, determines when the game ends (loses).
    int coins = 0; //coins - determines when the game ends (wins!)

    Avatar(PApplet main_)
    {
        super(main_, 35, main_.color(0,0,255), 255);
        x = main.width/2;
        y = main_.height/2;
    }

    //display the object
    void display()
    {
        super.display();
        main.ellipse(x, y, size, size);
    }

    void setLocation(float x_, float y_)
    {
        x = x_;
        y = y_;
    }

    //if a collision happened, deduct health!
    void collisions(Particle_Object object)
    {   
        hit = isHit(object);
        if (hit)
        {
            if(object instanceof Enemy)
            {
                health--;
                System.out.println("Health = " + health);
            }

            if(object instanceof NPC)
            {
                coins++;
                System.out.println("Coins =" + coins);
                // float randomValue = main.random(1, 2);
                // object.xVel += randomValue;
                // object.yVel += randomValue;
            }
        }
    }
    

    //getter for the health variable
    float getHealth()
    {
        return health;
    }

    //getter for coins!
    float getCoins()
    {
        return coins;
    }
}
