/*
 * Prescott Lau
 * Particle Engine 2 Assignment
 * September 18th, 2024
 * This file is Superclass for all the particle objects.
 */

package com.particle_engine_2;

import processing.core.PApplet;

public class Particle_Object {
    PApplet main; //processing functionality

    float x,y; //location
    int color; //color of the Particle Object
    float xVel, yVel; //velocity of the Particle Object
    float size; //size of the Particle Object
    int alphaValue; //value that changes the Particle Objects opacity. 
    float pVelX, pVelY; //previous velocity (used to reset velocity of Square objects)

    //initializes everything
    Particle_Object(PApplet main_, float size_, int color_, int a)
    {
        main = main_;
        size = size_;
        color = color_;
        alphaValue = a;
    }    

    /*
    *  This method gives each particle an x,y, and velocity.
    */
    void spawn()
    {
        x = main.random(main.width);
        y = main.random(main.height);

        xVel = main.random(-10,10);
        yVel = main.random(-10,10);

        pVelX = xVel;
        pVelY = yVel;
    }

    /*
    *  This method reverses the direction of the particles.
    */
    public void reverseDir() 
    {
        xVel *= -1;
        yVel *= -1;
    }

    /*
    *  This method makes the object move, and checks to see if the object goes off the screen.
    */
    void move()
    {
        y += yVel; // equation to make the ball move in the Y axis and in the correct direction.
        x += xVel; // equation to make the ball move in the X axis and in the correct direction.

        if(y > (main.height - size/2)) //if the value of the ball on the Y axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            yVel = yVel * -1;
        }

        if(y < 0) //if the value of the ball on the Y axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            yVel = yVel * -1;
        }

        if(x > (main.width - size/2)) //if the value of the ball on the X axis is greater than
        {                   //the right of the screen value, then the ball will change directions.
            xVel = xVel * -1;
        }

        if(x < (0 + size/2)) //if the value of the ball on the X axis is greater than
        {        //the left of the screen value then, the ball will change directions.
            xVel = xVel * -1;
        }
    }

    /*
    *  This is the getter method to get the value of an object's X value 
    */
    float getX()
    {
        return x;
    }

    /*
    *  This is the getter method to get the value of an object's Y value 
    */
    float getY()
    {
        return y;
    }

    /*
    *  This is the getter method to get the value of an object's size. 
    */
    float getSize()
    {
        return size;
    }

    /*
    *  This is a method to see if two circles are colliding with one another.
    */
    boolean isColliding(Circle object)
    {
        float distance = PApplet.dist(x, y, object.getX(), object.getY());
        return (distance < (size/2 + object.getSize()/2));
    }

    //Below are the keyboard functions for all of the objects.
    /*
     * This function is used to make the Circles bigger.
     * It is called when the user presses the W key on the keyboard.
     */
    void makeBigger()
    {
        size = size + 1;
    }

     /*
     * This function is used to make the Circles bigger.
     * It is called when the user presses the E key on the keyboard.
     */
    void makeSmaller()
    {
        size = size - 1;
    }

    /*
     * This function is used to make the Squares stop moving. 
     * It is called when the user presses the S key on the keyboard.
     */
    void stopVel()
    {
        
        xVel = 0;
        yVel = 0;
    }

    /*
     * This function is used to make the Squares start moving again. 
     * It is called when the user presses the D key on the keyboard.
     */
    void resetVel()
    {
        xVel = pVelX;
        yVel = pVelY;
    }

    /*
     * This function is used to reset the Alpha value of the Rectangles — transparency!
     * It is called when the user presses the X key on the keyboard.
     */
    void resetAlpha()
    {
        alphaValue = 255;
    }
}
