package com.application.minesweeper.model;

import com.application.minesweeper.state.GameInProgressState;
import com.application.minesweeper.state.GameLostState;
import com.application.minesweeper.state.GameState;
import com.application.minesweeper.state.GameWonState;
import com.application.minesweeper.util.GameDifficulty;
import com.application.minesweeper.util.IconEnum;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@NoArgsConstructor
public class Board {
    private static final Random random = new Random();
    private int rows;
    private int columns;
    private Cell[][] cells;
    private int unexposedCellsRemaining;

    public Board(int rows, int columns, GameDifficulty difficultyLevel) {
        this.rows = rows;
        this.columns = columns;
        int minesCount = getMines(rows * columns, difficultyLevel);
        Cell[] bombs = new Cell[minesCount];

        initializeBoard(minesCount, bombs);
        setNumberedCells(bombs);

        unexposedCellsRemaining = rows * columns - minesCount;
    }

    private void initializeBoard(int minesCount, Cell[] bombs) {
        this.cells = new Cell[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                cells[r][c] = new Cell(r, c);
            }
        }
        this.cells = addMinesInBoard(cells, minesCount, bombs);
    }

    private Cell[][] addMinesInBoard(Cell[][] board, final int minesCount, Cell[] bombs) {
        int numberOfMinesSet = 0;
        while (numberOfMinesSet < minesCount) {
            int rowMines = random.nextInt(board.length);
            int colMines = random.nextInt(board[0].length);
            if (!board[rowMines][colMines].isMineInside()) {
                board[rowMines][colMines].setMineInside(true);
                bombs[numberOfMinesSet] = cells[rowMines][colMines];
                numberOfMinesSet++;
            }
        }
        return board;
    }

    private void setNumberedCells(Cell[] bombs) {
        // set all the numbered cells depending on how the bombs are placed on the board
        int[][] directions = { // Offsets of 8 surrounding cells
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        for (Cell bomb : bombs) {
            int row = bomb.getRow();
            int col = bomb.getColumn();
            for (int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r >= 0 && r < rows && c >= 0 && c < columns) {
                    cells[r][c].setNumber(cells[r][c].getNumber() + 1);
                }
            }
        }
    }

    public GameState exposeCell(int row, int col) {
        Cell cell = getCell(row, col);
        if (cell.isMineInside()) {
            return new GameLostState();
        }
        if (!cell.isOpened()) {
            cell.setOpened(true);
            if (cell.isBlank()) {
                expandBlank(cell);
            }
            unexposedCellsRemaining--;
            if (unexposedCellsRemaining == 0) {
                return new GameWonState();
            }
        }
        return new GameInProgressState();
    }

    public GameState markCellAsMine(int row, int col) {
        Cell cell = getCell(row, col);
        cell.setMarkedAsMineByUser(true);
        return new GameInProgressState();
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    private void expandBlank(Cell cell) {

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        Queue<Cell> toExplore = new LinkedList<>();
        toExplore.add(cell);

        while (!toExplore.isEmpty()) {
            Cell current = toExplore.remove();

            for (int[] direction : directions) {
                int r = current.getRow() + direction[0];
                int c = current.getColumn() + direction[1];

                if (r >= 0 && r < rows && c >= 0 && c < columns) {
                    Cell neighbor = cells[r][c];

                    if (neighbor.isBlank() && !neighbor.isOpened()) {
                        neighbor.setOpened(true);
                        unexposedCellsRemaining--;
                        toExplore.add(neighbor);
                    }
                }
            }
        }
    }

    public void printBoard() {
        printHeader();

        for (int row = 0; row < rows; row++) {
            String index = String.format("%1$2s", row);
            System.out.print(index + " |");
            for (int col = 0; col < columns; col++) {
                System.out.print(getIcon(row, col));
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printHeader() {
        String headerCols = "   |";
        String headerLine = "---|";
        for (int i = 0; i < columns; i++) {
            String index = String.format("%1$2s", i);
            headerCols = headerCols.concat(index + " ");
            headerLine = headerLine.concat("---");
        }
        System.out.println(headerCols);
        System.out.println(headerLine);
    }

    private String getIcon(final int row, final int col) {
        Cell cell = getCell(row, col);
        if (cell.isMarkedAsMineByUser()) {
            return IconEnum.ICON_IS_MARKED_AS_BOMB.getIcon();
        }
        if (!cell.isOpened()) {
            return IconEnum.ICON_NOT_VISITED.getIcon();
        }
        if (cell.isMineInside()) {
            return IconEnum.ICON_IS_BOMB.getIcon();
        }
        int neighbourCount = cell.getNumber();
        if (neighbourCount == 0) {
            return "   ";
        } else {
            return " " + neighbourCount + " ";
        }
    }

    private int getMines(final int cells, final GameDifficulty difficulty) {
        return (int) (difficulty.getPercentage() * cells);
    }

    public void setUnexposedCellsRemaining(int cellCount) {
        this.unexposedCellsRemaining = cellCount;
    }

}