package com.application.minesweeper.view.console.useraction;

import com.application.minesweeper.state.GameState;
import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameInProgressState;

public class UserActionInvalid implements IUserAction {

    @Override
    public GameState perform(Game game) {
        System.err.println("Please enter valid input values");
        return new GameInProgressState();
    }
}
