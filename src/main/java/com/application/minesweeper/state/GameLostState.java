package com.application.minesweeper.state;

import com.application.minesweeper.model.Cell;
import com.application.minesweeper.model.Game;

public class GameLostState implements GameState {
    @Override
    public void updateBoardAsPerState(Game game) {
        for (int row = 0; row < game.getBoardRows(); row++) {
            for (int col = 0; col < game.getBoardColumns(); col++) {
                Cell cell = game.getBoard().getCell(row, col);
                if (cell.isMineInside()) {
                    cell.setOpened(true);
                }
            }
        }
        game.getBoard().printBoard();
        System.out.println("*******************");
        System.out.println("Sorry. You've lost!");
        System.out.println("*******************");
        System.out.println();
    }
}