package com.example.pong;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;

public class InputHandler implements EventHandler<KeyEvent> {

    private final Paddle leftPaddle;
    private final Paddle rightPaddle;

    private boolean isWPressed;
    private boolean isSPressed;
    private boolean isUpPressed;
    private boolean isDownPressed;

    public InputHandler(Paddle leftPaddle, Paddle rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;

        isWPressed = false;
        isSPressed = false;
        isUpPressed = false;
        isDownPressed = false;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        if (event.getEventType().equals(KEY_PRESSED)) {
            handleKeyPressed(code);
        } else if (event.getEventType().equals(KEY_RELEASED)) {
            handleKeyReleased(code);
        }
    }

    private void handleKeyPressed(KeyCode code) {
        switch (code) {
            case W:
                leftPaddle.setVelocity(-4);
                isWPressed = true;
                break;
            case S:
                leftPaddle.setVelocity(4);
                isSPressed = true;
                break;
            case UP:
                rightPaddle.setVelocity(-4);
                isUpPressed = true;
                break;
            case DOWN:
                rightPaddle.setVelocity(4);
                isDownPressed = true;
                break;
            default:
                break;
        }
    }

    private void handleKeyReleased(KeyCode code) {
        switch (code) {
            case W:
                isWPressed = false;
                if (!isSPressed) {
                    leftPaddle.setVelocity(0);
                }
                break;
            case S:
                isSPressed = false;
                if (!isWPressed) {
                    leftPaddle.setVelocity(0);
                }
                break;
            case UP:
                isUpPressed = false;
                if (!isDownPressed) {
                    rightPaddle.setVelocity(0);
                }
                break;
            case DOWN:
                isDownPressed = false;
                if (!isUpPressed) {
                    rightPaddle.setVelocity(0);
                }
                break;
            default:
                break;
        }
    }
}

