package minesweeper.view;

import com.application.minesweeper.model.Board;
import com.application.minesweeper.model.Game;
import com.application.minesweeper.state.GameInProgressState;
import com.application.minesweeper.util.GameDifficulty;
import com.application.minesweeper.view.console.useraction.IUserAction;
import com.application.minesweeper.view.console.useraction.UserActionFactory;
import com.application.minesweeper.view.console.useraction.UserActionHelp;
import com.application.minesweeper.view.console.useraction.UserActionInvalid;
import com.application.minesweeper.view.console.useraction.UserActionMark;
import com.application.minesweeper.view.console.useraction.UserActionOpen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserActionFactoryTest {

    @Test
    void shouldReturnUserActionHelpWhenUserEnterHelpCommand() {

        //GIVEN
        Game game = new Game();
        String input = "help";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 0, 0);

        //THEN
        assertTrue(userAction.perform(game) instanceof GameInProgressState);
        assertTrue(userAction instanceof UserActionHelp);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterTooManyParameters() {

        //GIVEN
        Game game = new Game();
        String input = "open 1 2 3";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction.perform(game) instanceof GameInProgressState);
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterNegativeRowParameter() {

        //GIVEN
        String input = "open -1 -1";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterNegativeColParameter() {

        //GIVEN
        String input = "open 1 -1";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterOutOfBoundsParameters() {

        //GIVEN
        String input = "open 8 8";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterTooFewParameters() {

        //GIVEN
        String input = "open 1";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnActionInvalidWhenUserEnterNonIntegerParameters() {

        //GIVEN
        String input = "open A B";

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 6, 6);

        //THEN
        assertTrue(userAction instanceof UserActionInvalid);
    }

    @Test
    void shouldReturnUserActionOpenWhenUserEnterOpenCommand() {

        //GIVEN
        String input = "open 1 2";
        Game game = new Game();
        Board board = new Board(3, 3, GameDifficulty.MEDIUM);
        game.setBoard(board);

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 3, 3);
        assertTrue(userAction instanceof UserActionOpen);
        UserActionOpen userActionOpen = (UserActionOpen) userAction;

        //THEN
        assertTrue(userAction.perform(game) instanceof GameInProgressState);
        assertEquals(1, userActionOpen.getRow());
        assertEquals(2, userActionOpen.getCol());
    }

    @Test
    void shouldReturnUserActionMarkWhenUserEnterMarkCommand() {

        //GIVEN
        String input = "mark 1 2";
        Game game = new Game();
        Board board = new Board(3, 3, GameDifficulty.MEDIUM);
        game.setBoard(board);

        //WHEN
        IUserAction userAction = UserActionFactory.getUserAction(input, 3, 3);
        assertTrue(userAction instanceof UserActionMark);
        UserActionMark userActionMark = (UserActionMark) userAction;

        //THEN
        assertTrue(userAction.perform(game) instanceof GameInProgressState);
        assertEquals(1, userActionMark.getRow());
        assertEquals(2, userActionMark.getCol());
    }

}
