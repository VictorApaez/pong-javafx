package com.example.pong;

import javafx.scene.paint.Color;

public class Game {
    private final Ball ball;
    private final Paddle paddle1;
    private final Paddle paddle2;
    private final Wall topWall;
    private final Wall bottomWall;

    public Game() {
        ball = new Ball();
        ball.setPosition(300, 200);
        ball.setVelocity(4, -2);

        paddle1 = new Paddle();
        paddle1.setPosition(10, 100);

        paddle2 = new Paddle();
        paddle2.setPosition(550, 100);

        topWall = new Wall(0, 0, 600, 10, Color.WHITE);
        bottomWall = new Wall(0, 390, 600, 10, Color.RED);

    }

    public void update() {
// Update the ball position
        ball.update(paddle1, paddle2, topWall, bottomWall);
        paddle1.update(topWall, bottomWall);
        paddle2.update(topWall, bottomWall);
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle1(){
        return paddle1;
    }

    public Paddle getPaddle2(){
        return paddle2;
    }

    public Wall getBottomWall() {
        return bottomWall;
    }

    public Wall getTopWall() {
        return topWall;
    }
}
