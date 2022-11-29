package com.application.minesweeper.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {

    private int row;
    private int column;
    private boolean isOpened;
    private boolean isMineInside;
    private boolean isMarkedAsMineByUser;

    private boolean isBlank;

    private int number;

    public Cell(int r, int c) {
        row = r;
        column = c;
    }

    public boolean isBlank() {
        return number == 0;
    }
}
