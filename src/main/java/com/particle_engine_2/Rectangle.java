/*
 * Prescott Lau
 * Particle Engine 2 Assignment
 * September 19th, 2024
 * This file inherits the superclass (the particle object) and draws a rectangle with a ellipse inside of it!
 */

 package com.particle_engine_2; 

 import processing.core.PApplet;
 
 public class Rectangle extends Particle_Object {
     
    Rectangle(PApplet main_)
     {
         super(main_, 45, main_.color(main_.random(255),main_.random(255),main_.random(255)), 255);
         
         super.spawn();
     }

     /*
     * This is the draw function for all the Rectangle objects
     * It draws all the Rectangles.
     */
     void draw()
     {
        main.rectMode(3);
        main.fill(color, alphaValue);
        main.rect(x, y, size*2, size);
        main.ellipse(x, y, size*2/3, size*2);
        super.move();
     }

     /*
     * This is the mousePressed function for all the Rectangle objects
     * It changes the alpha value (making the objects transparent) when the mouse is clicked.
     */
     void mousePressed()
     {
         alphaValue = alphaValue - 20;
     }
 }
 