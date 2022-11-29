package com.application.minesweeper;

import com.application.minesweeper.view.common.GameView;
import com.application.minesweeper.view.console.ConsoleView;
import com.application.minesweeper.view.gui.GUIView;

public class MineSweeperApplication {

    public static void main(String[] args) {
        GameView gameView = getView(true);
        gameView.startGame();
    }

    private static GameView getView(final boolean noGUI) {
        if (noGUI) {
            return new ConsoleView();
        } else {
            // ToDo to be implemented...
            return new GUIView();
        }
    }
}
