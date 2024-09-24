/*
 * Prescott Lau
 * Particle Engine 2 Assignment
 * September 18th, 2024
 * This file controls the particles!
 */
package com.particle_engine_2;

import java.util.ArrayList;

import processing.core.PApplet;

public class Particle_Container {
    PApplet main; //the main class, which has all the processing functionality.

    /*
     * Below are all the ArrayLists for each of the different objects.
     */
    ArrayList<Square> Squares;
    int squareCount = 8;

    ArrayList<Rectangle> Rectangles;
    int rectCount = 5;

    ArrayList<Circle> Circles;
    int circleCount = 7;

    public Particle_Container(PApplet main_) 
    {
        main = main_;
        init(); //initialize all the objects
    }

/*
 * This function initializes all the objects in the code.
 */
    public void init()
    {    
        Squares = new ArrayList();
        Rectangles = new ArrayList();
        Circles = new ArrayList();

        for(int i = 0; i < squareCount; i++)
        {
            Squares.add( new Square(main) );
        }
       
        for(int i = 0; i < rectCount; i++)
        {
            Rectangles.add( new Rectangle(main) );
        }

        for(int i = 0; i < circleCount; i++)
        {
            Circles.add( new Circle(main) );
        }

    }

    /*
     * This is the draw function, it calls other functions to make the code cleaner and easier to read.
     */
    public void draw()
    {
        main.background(0); //draw the background
        display(); //display all objects
        collisions(); //check collisions btwn circles
        keys(); //checks all the keyboard functions.
    }

    /*
     * This is the function that draws (displays) all the objects.
     */
    public void display()
    {
        main.rectMode(3);
        main.noStroke();
        for(int i = 0; i < Squares.size(); i++)
        {
            Squares.get(i).draw();
            
        }

        for(int i = 0; i < Rectangles.size(); i++)
        {
            Rectangles.get(i).draw();
        }

        for(int i = 0; i < Circles.size(); i++)
        {
            Circles.get(i).draw();
        }

    }
    
    /*
     * This is the collision function for all of the Circles.
     * If the boolean of "isColliding" = true & if the circle in the first loop is NOT the same as the one in the second loop, then make the circles reverse direction.
     */
    public void collisions()
    {
        for(int i = 0; i < Circles.size(); i++)
        {
            for(int j = 0; j < Circles.size(); j++)
            {
                if (Circles.get(i).isColliding(Circles.get(j)) && Circles.get(i) != Circles.get(j) )
                {
                    Circles.get(i).reverseDir();
                }
            }
        }
    }

    /*
     * This function handles all of the keys pressed functions!
     */
    void keys() 
    {
        if (main.keyPressed)
        {
            if( main.key == 'w' || main.key == 'W') //if 'W' is pressed, then do below...
            {
                for(int i = 0; i < Circles.size(); i++)
                {
                    Circles.get(i).makeBigger(); //changes the size of the circles to make them bigger.
                }
            }

            if( main.key == 'e' || main.key == 'E') //if 'E' is pressed, then do below...
            {
                for(int i = 0; i < Circles.size(); i++)
                {
                    Circles.get(i).makeSmaller(); //changes the size of the circles to make them smaller.
                }
            }

            if( main.key == 's' || main.key == 'S') //if 'S' is pressed, then do below...
            {
                for(int i = 0; i < Squares.size(); i++)
                {
                    Squares.get(i).stopVel(); //makes the Squares stop moving! 
                }
            }

            if( main.key == 'd' || main.key == 'D') //if 'D' is pressed, then do below...
            {
                for(int i = 0; i < Squares.size(); i++)
                {
                    Squares.get(i).resetVel(); //changes the velocity of the Squares back to what it had been when the object was initialized
                }
            }

            if( main.key == 'x' || main.key == 'X') //if 'X' is pressed, then do below...
            {
                for(int i = 0; i < Rectangles.size(); i++)
                {
                    Rectangles.get(i).resetAlpha(); //resets the alpha value of the Rectangle objects.
                }
            }

        }
    }

    /*
     * This is the mousePressed function
     * It calls all the subclasses mousePressed functions and sets all the objects to do whatever is in that function.
     */
    void mousePressed()
    {
        for(int i = 0; i < Circles.size(); i++)
        {
            Circles.get(i).mousePressed();
        }

        for(int i = 0; i < Squares.size(); i++)
        {
            Squares.get(i).mousePressed();
        }

        for(int i = 0; i < Rectangles.size(); i++)
        {
            Rectangles.get(i).mousePressed();
        }
    }

}
