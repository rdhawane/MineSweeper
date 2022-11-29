package com.application.minesweeper.state;

import com.application.minesweeper.model.Game;

public class GameWonState implements GameState {
    @Override
    public void updateBoardAsPerState(Game game) {
        game.getBoard().printBoard();
        System.out.println("***************************");
        System.out.println("Congratulation. You've won!");
        System.out.println("***************************");
        System.out.println();
    }
}
