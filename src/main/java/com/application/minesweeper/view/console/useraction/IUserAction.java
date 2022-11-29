package com.application.minesweeper.view.console.useraction;

import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameState;

public interface IUserAction {

    GameState perform(Game game);

}
