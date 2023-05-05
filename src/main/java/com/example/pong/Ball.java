package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private double dx;
    private double dy;

    public Ball() {
        super(10, Color.WHITE); // Create a white circle with a radius of 10 pixels
        dx = 5; // Set the initial horizontal velocity of the ball
        dy = 5; // Set the initial vertical velocity of the ball
    }

    public void update() {
        // Update the position of the ball based on its velocity
        setCenterX(getCenterX() + dx);
        setCenterY(getCenterY() + dy);

        // TODO: Detect and handle collisions with the walls and paddles
    }

    public void setPosition(double x, double y) {
        setCenterX(x);
        setCenterY(y);
    }

    public void setVelocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getVelocityX() {
        return dx;
    }

    public double getVelocityY() {
        return dy;
    }
}
