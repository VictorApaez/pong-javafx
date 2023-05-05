package com.example.pong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: Create and initialize the game objects, such as the ball, paddles, and scoreboard.
        // TODO: Create an instance of the Game class and add the game objects to it.
        // TODO: Create an instance of the Renderer class and set it up to render the game graphics.
        // TODO: Create an instance of the InputHandler class and set it up to handle user input.

        // Set up the stage and show it
        primaryStage.setTitle("Pong");

        // Initialize game
        Game game = new Game();

// Create a Group object and add objects
        Group root = new Group();
        root.getChildren().addAll(game.getBall(), game.getPaddle1(), game.getPaddle2(), game.getBottomWall(), game.getTopWall());

// Set up the scene with the Group object
        Scene scene = new Scene(root, 600, 400, Color.BLACK);
        scene.setOnKeyPressed(new InputHandler(game.getPaddle1(), game.getPaddle2()));

        // BINDING
        game.getPaddle2().xProperty().bind(scene.widthProperty().subtract(game.getPaddle2().getWidth() + 10));
        // Bind the walls to the width of the scene
        game.getTopWall().widthProperty().bind(scene.widthProperty());
        game.getBottomWall().widthProperty().bind(scene.widthProperty());

        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> {
                    game.update();
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
