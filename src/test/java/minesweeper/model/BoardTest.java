package minesweeper.model;

import com.application.minesweeper.model.Board;
import com.application.minesweeper.model.Cell;
import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameInProgressState;
import com.application.minesweeper.state.GameLostState;
import com.application.minesweeper.state.GameState;
import com.application.minesweeper.state.GameWonState;
import com.application.minesweeper.util.GameDifficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    private static Board board;

    @BeforeEach
    public void boardSetup() {
        board = new Board(6, 6, GameDifficulty.MEDIUM);
    }

    @Test
    void shouldReturnGameLostWhenUserOpenMineCell() {

        Game game = new Game();
        Cell cell = board.getCell(1, 1);
        cell.setMineInside(true);
        game.setBoard(board);
        GameState gameState = board.exposeCell(1, 1);
        gameState.updateBoardAsPerState(game);
        assertTrue(gameState instanceof GameLostState);
    }

    @Test
    void shouldReturnGameWonWhenUserOpenAllCellsWithoutMines() {

        Game game = new Game();
        Cell cell = board.getCell(3, 3);
        cell.setMineInside(false);
        cell.setNumber(1);
        board.setUnexposedCellsRemaining(1);
        game.setBoard(board);
        GameState gameState = board.exposeCell(3, 3);
        gameState.updateBoardAsPerState(game);
        assertTrue(gameState instanceof GameWonState);
    }

    @Test
    void shouldReturnGameInProgressStateWhenAllCellsWithoutMinesAreNotOpen() {

        Game game = new Game();
        Cell cell = board.getCell(0, 4);
        cell.setMineInside(false);
        cell.setNumber(0);
        game.setBoard(board);
        GameState gameState = board.exposeCell(0, 4);
        gameState.updateBoardAsPerState(game);
        assertTrue(gameState instanceof GameInProgressState);
    }

    @Test
    void shouldMarkCellAsMineWhenUserEnterMarkAction() {

        assertTrue(board.markCellAsMine(5, 1) instanceof GameInProgressState);
    }
}
