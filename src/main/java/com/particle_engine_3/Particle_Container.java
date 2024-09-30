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

    // ArrayList<Square> Squares;
    // int squareCount = 8;

    // ArrayList<Rectangle> Rectangles;
    // int rectCount = 5;

    // ArrayList<Circle> Circles;
    // int circleCount = 7;

    ArrayList<NPC> npc;

    ArrayList<Loot> loot;
    int loot_count = 3;

    ArrayList<Enemy> enemies;
    int enemy_count = 5;

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
        npc = new ArrayList();
        loot = new ArrayList();
        enemies = new ArrayList();

        // Squares = new ArrayList();
        // Rectangles = new ArrayList();
        // Circles = new ArrayList();

        

        // for(int i = 0; i < squareCount; i++)
        // {
        //     Squares.add( new Square(main) );
        // }
       
        // for(int i = 0; i < rectCount; i++)
        // {
        //     Rectangles.add( new Rectangle(main) );
        // }

        // for(int i = 0; i < circleCount; i++)
        // {
        //     Circles.add( new Circle(main) );
        // }

        for(int i = 0; i < loot_count; i++)
        {
            loot.add( new Loot(main) );
        }

       
        for(int i = 0; i < enemy_count; i++)
        {
            enemies.add( new Enemy(main) );
        }

        //add all the NPC
        npc.addAll(loot);
        npc.addAll(enemies);
        
        
        //add all the small particles to the big particle object ArrayList
        particle_Objects = new ArrayList();
        particle_Objects.add(avatar);
        particle_Objects.addAll(npc);
        // particle_Objects.addAll(Squares);
        // particle_Objects.addAll(Rectangles);
        // particle_Objects.addAll(Circles);
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

        //check to see if we need to end the game
        nextController = GameController.DO_NOT_CHANGE;

        if( avatar.getHealth() <= 0 )//if the player dies, player loses
        {
            nextController = GameController.GAME_END; //draws the end game screen
        }

        if( avatar.getCoins() >= 15 ) //if the player has more than 15 coins, player wins
        {
            nextController = GameController.GAME_WIN; //draws the win game screen
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
        for(int i = 0; i < npc.size(); i++)
        {
            avatar.collisions(npc.get(i));
            npc.get(i).collision(avatar);

            
            //     if (npc.get(i) != npc.get(j) && npc.get(i).collisions(npc.get(j)))
            //     {

            //     }
            }


            for(int i = 0; i < enemies.size(); i++)
            {
                for(int j = 0; j < enemies.size(); j++)
            {
                if (enemies.get(i) != enemies.get(j))
                {
                    enemies.get(i).collision(enemies.get(j));
                }
            }
        }

        

        // for(int i = 0; i < enemies.size(); i++)
        // {
        //     avatar.collisions(enemies.get(i));
        //     enemies.get(i).collision(avatar);
        // }

        // for(int i = 0; i < Circles.size(); i++)
        // {
        //     for(int j = 0; j < Circles.size(); j++)
        //     {
        //         if (Circles.get(i).isColliding(Circles.get(j)) && Circles.get(i) != Circles.get(j) )
        //         {
        //             Circles.get(i).reverseDir();
        //         }
        //     }
        // }
    }

    /*
     * This function handles all of the keys pressed functions!
     */
    // public void keyPressed() 
    // {
    //     if (main.keyPressed)
    //     {
    //         if( main.key == 'w' || main.key == 'W') //if 'W' is pressed, then do below...
    //         {
    //             for(int i = 0; i < Circles.size(); i++)
    //             {
    //                 Circles.get(i).makeBigger(); //changes the size of the circles to make them bigger.
    //             }
    //         }

    //         if( main.key == 'e' || main.key == 'E') //if 'E' is pressed, then do below...
    //         {
    //             for(int i = 0; i < Circles.size(); i++)
    //             {
    //                 Circles.get(i).makeSmaller(); //changes the size of the circles to make them smaller.
    //             }
    //         }

    //         if( main.key == 's' || main.key == 'S') //if 'S' is pressed, then do below...
    //         {
    //             for(int i = 0; i < Squares.size(); i++)
    //             {
    //                 Squares.get(i).stopVel(); //makes the Squares stop moving! 
    //             }
    //         }

    //         if( main.key == 'd' || main.key == 'D') //if 'D' is pressed, then do below...
    //         {
    //             for(int i = 0; i < Squares.size(); i++)
    //             {
    //                 Squares.get(i).resetVel(); //changes the velocity of the Squares back to what it had been when the object was initialized
    //             }
    //         }

    //         if( main.key == 'x' || main.key == 'X') //if 'X' is pressed, then do below...
    //         {
    //             for(int i = 0; i < Rectangles.size(); i++)
    //             {
    //                 Rectangles.get(i).resetAlpha(); //resets the alpha value of the Rectangle objects.
    //             }
    //         }

    //     }
    // }

    // /*
    //  * This is the mousePressed function
    //  * It calls all the subclasses mousePressed functions and sets all the objects to do whatever is in that function.
    //  */
    // public void mousePressed()
    // {
    //     // for(int i = 0; i < particle_Objects.size(); i++)
    //     // {
    //     //     particle_Objects.get(i).mousePressed();
    //     // }

    //     for(int i = 0; i < Circles.size(); i++)
    //     {
    //         Circles.get(i).mousePressed();
    //     }

    //     for(int i = 0; i < Squares.size(); i++)
    //     {
    //         Squares.get(i).mousePressed();
    //     }

    //     for(int i = 0; i < Rectangles.size(); i++)
    //     {
    //         Rectangles.get(i).mousePressed();
    //     }
    // }

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
