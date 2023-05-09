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


    }

    public static void main(String[] args) {
        launch(args);
    }

}
