package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private double dx;
    private double dy;

    public Ball() {
        super(10, Color.WHITE);
        dx = 5;
        dy = 5;
    }

    public void update() {
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
