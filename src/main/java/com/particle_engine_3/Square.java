/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This file inherits the superclass (the particle object) and draws a square!
 */

package com.particle_engine_3;

import processing.core.PApplet;

public class Square extends Particle_Object {
    //This is the Square Constructor, which calls the superclass
    Square(PApplet main_)
    {
        super(main_, 45, main_.color(main_.random(255),main_.random(255),main_.random(255)), 255);
        super.spawn();
    
    }
    
    void setLocation(float x_, float y_)
    {
        x = x_;
        y = y_;
    }

    /*
     * This is the draw function for all the Squares objects
     * It draws all the Squares.
     */
    void draw()
    {
        display();    
        super.move();
    }

    void display()
    {
        super.display();
        main.rect(x, y, size, size);
    }

    /*
     * This is the mousePressed function for all the Squares objects
     * It changes the color of the Squares, whenever the mouse is pressed.
     */
    void mousePressed()
    {
        color = main.color(main.random(255),main.random(255), main.random(255)); 
    }

}
