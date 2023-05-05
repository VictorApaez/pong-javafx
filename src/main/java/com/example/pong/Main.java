package com.example.pong;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: Create and initialize the game objects, such as the ball, paddles, and scoreboard.
        // TODO: Create an instance of the Game class and add the game objects to it.
        // TODO: Create an instance of the Renderer class and set it up to render the game graphics.
        // TODO: Create an instance of the InputHandler class and set it up to handle user input.

        // Set up the stage and show it
        primaryStage.setTitle("Pong");
        // Create the ball object
        Ball ball = new Ball();
        ball.setPosition(300, 200);

// Create a Group object and add the ball to it
        Group root = new Group();
        root.getChildren().add(ball);

// Set up the scene with the Group object
        Scene scene = new Scene(root, 600, 400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
