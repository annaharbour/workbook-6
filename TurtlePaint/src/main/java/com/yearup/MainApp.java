package com.yearup;

import com.yearup.models.Turtle;
import com.yearup.models.World;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);

        int width = 200;
        int height = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
//        double widthSquared = Math.pow(width, 2);
//        double heightSquared = Math.pow(height, 2);
//        double hypotenuse = Math.sqrt(widthSquared + heightSquared);
//
        turtle.setPenWidth(3);
        turtle.setColor(Color.GREEN);
//
//        turtle.turnRight(45);
//        turtle.forward(hypotenuse);
//
//        turtle.penUp();
//        turtle.goTo(100, 100);
//        turtle.turnRight(90);
//
//        turtle.penDown();
//        turtle.forward(hypotenuse);
        turtle.penUp();
        turtle.goTo(0, 0);
        turtle.penDown();
        for (int i = 0; i < 4; i++) {
            turtle.forward(40); // Move forward by 100 units
            turtle.turnRight(90); // Turn 90 degrees to the right
        }
    }
}
