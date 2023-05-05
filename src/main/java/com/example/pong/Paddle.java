package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {

    private double dy;

    public Paddle() {
        super(10, 60, Color.WHITE);
        dy = 0;
    }

    public void update(Wall topWall, Wall bottomWall) {
        setY(getY() + dy);
        if (getY() < topWall.getHeight()) {
            setY(topWall.getHeight());
        }

        // check for collision with bottom wall
        if (getY() + getHeight() > bottomWall.getY()) {
            setY(bottomWall.getY() - getHeight());
        }
    }

    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setVelocity(double dy) {
        this.dy = dy;
    }

    public double getVelocity() {
        return dy;
    }
}
