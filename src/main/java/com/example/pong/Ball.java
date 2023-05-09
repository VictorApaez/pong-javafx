package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Circle {

    private double dx;
    private double dy;
    private double deltaTime = 1.2;

    public Ball() {
        super(10, Color.WHITE);
        dx = 5;
        dy = 5;
    }

    public void update(Paddle paddle1, Paddle paddle2, Wall topWall, Wall bottomWall) {
        setCenterX(getCenterX() + dx * deltaTime);
        setCenterY(getCenterY() + dy * deltaTime);

        // Top/Bottom wall collision
        if (getCenterY() - getRadius() < topWall.getHeight()) {
            dy = -dy;
            System.out.println("Ball collided with top wall.");
        } else if (getCenterY() + getRadius() > bottomWall.getY()) {
            dy = -dy;
            System.out.println("Ball collided with bottom wall.");
        }

        // Paddle Collision
        if (getBoundsInParent().intersects(paddle1.getBoundsInParent())) {
            dx = -dx;
            System.out.println("Ball collided with left paddle.");
        } else if (getBoundsInParent().intersects(paddle2.getBoundsInParent())) {
            dx = -dx;
            System.out.println("Ball collided with right paddle.");
        }
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
