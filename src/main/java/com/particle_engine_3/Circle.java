/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This file inherits the superclass and draws a circle!
 */

package com.particle_engine_3;

import processing.core.PApplet;

public class Circle extends Particle_Object {
    //This is the constructor for all the Circle objects, it calls the superclass.
    Circle(PApplet main_)
    {
        super(main_, 45, main_.color(main_.random(255),main_.random(255),main_.random(255)), 255);
        super.spawn();
    }

    /*
     * This is the draw function for all the Circle objects
     * It draws all the Circles.
     */
    void draw()
    {
        display();
        super.move();
    }

    void display()
    {
        super.display();
        main.ellipse(x, y, size, size);
    }

    /*
     * This is the mousePressed function for all the Circle objects
     * It makes the balls move faster based on a random number.
     */
    void mousePressed()
    {
        float randomValue = main.random(1, 2);
        xVel += randomValue;
        yVel += randomValue;
    }
}
