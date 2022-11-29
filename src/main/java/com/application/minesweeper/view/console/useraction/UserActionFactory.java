package com.application.minesweeper.view.console.useraction;


public class UserActionFactory {

    public static IUserAction getUserAction(final String input, final int rows, final int columns) {

        if (input.equals("exit")) {
            System.exit(0);
        }
        if (input.equals("help")) {
            return new UserActionHelp();
        }

        return getActionWithRowAndCol(input, rows, columns);
    }

    private static IUserAction getActionWithRowAndCol(final String input, final int rows, final int columns) {
        String[] inputArray = input.split("\\s+");
        if (inputArray.length != 3) {
            return new UserActionInvalid();
        }
        int row;
        int col;
        try {
            row = Integer.parseInt(inputArray[1]);
            col = Integer.parseInt(inputArray[2]);
        } catch (NumberFormatException e) {
            return new UserActionInvalid();
        }

        if (row < 0 || row >= rows) {
            return new UserActionInvalid();
        }

        if (col < 0 || col >= columns) {
            return new UserActionInvalid();
        }

        if (inputArray[0].equalsIgnoreCase("open") || inputArray[0].equalsIgnoreCase("o")) {
            return new UserActionOpen(row, col);
        }
        if (inputArray[0].equalsIgnoreCase("mark") || inputArray[0].equalsIgnoreCase("m")) {
            return new UserActionMark(row, col);
        }
        return null;
    }

}
