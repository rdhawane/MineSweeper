package com.application.minesweeper.util;

public enum GameDifficulty {
    EASY(0.1),
    MEDIUM(0.2),
    HARD(0.3);

    private final double percentage;

    GameDifficulty(final double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
