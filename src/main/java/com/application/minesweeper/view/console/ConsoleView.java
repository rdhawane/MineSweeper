package com.application.minesweeper.view.console;

import com.application.minesweeper.state.GameLostState;
import com.application.minesweeper.view.common.GameView;
import com.application.minesweeper.model.Board;
import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameState;
import com.application.minesweeper.state.GameWonState;
import com.application.minesweeper.util.GameDifficulty;
import com.application.minesweeper.view.console.useraction.IUserAction;
import com.application.minesweeper.view.console.useraction.UserActionFactory;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleView implements GameView {

    private final Scanner inputScanner;
    private Game game;
    private int rows;
    private int columns;

    private GameDifficulty difficultyLevel;
    public ConsoleView() {
        inputScanner = new Scanner(System.in);
        game = new Game();
    }

    @Override
    public void startGame() {
        gameInitialSetup();
        do {
            performUserActions();
        } while (playAgain());
        System.out.println("Goodbye!");
    }

    private void gameInitialSetup() {
        System.out.println();
        System.out.print("Enter count of rows (>3):");
        this.rows = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Enter count of columns (>3):");
        this.columns = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Please type game difficulty level in Capital Letters from below option \n EASY \n MEDIUM \n HARD\n");
        System.out.println();
        difficultyLevel = GameDifficulty.valueOf(inputScanner.nextLine());
        createGameBoard();
    }

    private void createGameBoard(){
        game = Game.builder()
                .board(new Board(rows, columns, difficultyLevel))
                .boardRows(rows)
                .boardColumns(columns)
                .build();
        game.getBoard().printBoard();
    }

    private boolean playAgain() {
        String playAgain = getStringFromUser("Play again (y/n)? ", new String[] { "y", "n" });
        if("y".equals(playAgain)){
            createGameBoard();
            return true;
        }
        return false;
    }

    private String getStringFromUser(final String prompt, final String[] validInputs) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = inputScanner.nextLine();
            if (Arrays.asList(validInputs).contains(input)) {
                break;
            }
        }
        return input;
    }

    private void performUserActions() {
        IUserAction userAction;
        while (true) {
            userAction = getUserAction();
            GameState gameState = userAction.perform(game);
            if (gameState instanceof GameWonState || gameState instanceof GameLostState) {
                gameState.updateBoardAsPerState(game);
                break;
            }
            gameState.updateBoardAsPerState(game);
        }
    }

    private IUserAction getUserAction() {
        System.out.print("Command: ");
        String userInput = inputScanner.nextLine();
        return UserActionFactory.getUserAction(userInput, rows, columns);
    }
}
