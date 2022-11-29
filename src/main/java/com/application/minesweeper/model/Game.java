package com.application.minesweeper.model;

import com.application.minesweeper.state.GameState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    GameState state;
    private Board board;
    private int boardRows;
    private int boardColumns;

}
