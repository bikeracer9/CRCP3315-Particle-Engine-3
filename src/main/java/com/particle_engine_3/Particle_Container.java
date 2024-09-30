/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This file controls the particles!
 */

package com.particle_engine_3;

import java.util.ArrayList;

import processing.core.PApplet;

public class Particle_Container extends GameController {
    //PApplet main; //the main class, which has all the processing functionality.

    /*
     * Below are all the ArrayLists for each of the different objects.
     */

    Avatar avatar;
    //ArrayList<NPC> NPC;

    ArrayList<Square> Squares;
    int squareCount = 8;

    ArrayList<Rectangle> Rectangles;
    int rectCount = 5;

    ArrayList<Circle> Circles;
    int circleCount = 7;

    ArrayList<Particle_Object> particle_Objects;

    public Particle_Container(PApplet main_) 
    {
        super(main_);
        init(); //initialize all the objects
    }

/*
 * This function initializes all the objects in the code.
 */
    public void init()
    {    
        avatar = new Avatar(main);
        Squares = new ArrayList();
        Rectangles = new ArrayList();
        Circles = new ArrayList();

        particle_Objects = new ArrayList();

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

        //add all the small particles to the big particle object ArrayList
        particle_Objects.addAll(Squares);
        particle_Objects.addAll(Rectangles);
        particle_Objects.addAll(Circles);
    }

    /*
     * This is the draw function, it calls other functions to make the code cleaner and easier to read.
     */
    public void draw()
    {
        main.background(0); //draw the background
        display(); //display all objects
        move(); //move the objects
        collisions(); //check collisions btwn circles
        keyPressed(); //checks all the keyboard functions.

        //check to see if we need to end the game
        nextController = -1;
        if( avatar.getHealth() <= 0 )
        {
            nextController = 1; //switch out
        }
    }

    /*
     * This is the function that draws (displays) all the objects.
     */
    public void display()
    {
        main.rectMode(3);
        main.noStroke();
        for(int i = 0; i < particle_Objects.size(); i++)
        {
            particle_Objects.get(i).display();
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
    public void keyPressed() 
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
    public void mousePressed()
    {
        // for(int i = 0; i < particle_Objects.size(); i++)
        // {
        //     particle_Objects.get(i).mousePressed();
        // }

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

    public void move()
    {
        for(int i = 0; i < particle_Objects.size(); i++)
        {
            particle_Objects.get(i).move();
        }
    }

    //change the location of the avatar, hooked up w mouseDragged in main.
    public void setAvatarLocation(float x, float y)
    {
        avatar.setLocation(x, y);
    }
    //move avatar when mouse is dragged.
    public void mouseDragged()
    {
        setAvatarLocation(main.mouseX, main.mouseY);
    }

    public void reset()
    {
        super.reset();
        init();

    }

}
