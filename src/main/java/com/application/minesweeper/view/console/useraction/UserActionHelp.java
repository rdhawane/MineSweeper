package com.application.minesweeper.view.console.useraction;

import com.application.minesweeper.state.GameState;
import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameInProgressState;

public final class UserActionHelp implements IUserAction {

    @Override
    public GameState perform(Game game) {
        System.out.println("The following commands are available:");
        System.out.println(" - open <row> <col>     Use to open an unvisited cell");
        System.out.println(" - o <row> <col>        Use to open an unvisited cell");
        System.out.println(" - mark <row> <col>     Use to mark an unvisited cell as a mine");
        System.out.println(" - m <row> <col>     Use to mark an unvisited cell as a mine");
        System.out.println(" - exit");
        System.out.println();
        return new GameInProgressState();
    }
}
