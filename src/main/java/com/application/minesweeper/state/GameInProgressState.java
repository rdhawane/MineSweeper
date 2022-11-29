package com.application.minesweeper.state;

import com.application.minesweeper.model.Game;

public class GameInProgressState implements GameState {

    @Override
    public void updateBoardAsPerState(Game game) {
        game.getBoard().printBoard();
    }
}
