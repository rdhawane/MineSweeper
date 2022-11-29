package com.application.minesweeper.view.console.useraction;

import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameState;
import lombok.Getter;

@Getter
public final class UserActionMark implements IUserAction {

    private final int row;
    private final int col;

    public UserActionMark(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public GameState perform(Game game) {
        return game.getBoard().markCellAsMine(row, col);
    }
}
