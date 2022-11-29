package com.application.minesweeper.state;

import com.application.minesweeper.model.Game;

public interface GameState {

    void updateBoardAsPerState(Game game);
}
