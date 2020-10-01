package game.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void step() {
        GameBoard actualWhite = new GameBoard();
        assertTrue(actualWhite.step(true, 0, 1));
        GameBoard expectedWhite = new GameBoard();
        expectedWhite.getTriangle(0).removeChecker();
        expectedWhite.getTriangle(1).addChecker(Color.WHITE);
        assertEquals(expectedWhite.getTriangle(0), actualWhite.getTriangle(0));
        assertEquals(expectedWhite.getTriangle(1), actualWhite.getTriangle(1));

        GameBoard actualBlack = new GameBoard();
        assertTrue(actualBlack.step(false, 12, 13));
        GameBoard expectedBlack = new GameBoard();
        expectedBlack.getTriangle(12).removeChecker();
        expectedBlack.getTriangle(13).addChecker(Color.BLACK);
        assertEquals(expectedBlack.getTriangle(12), actualBlack.getTriangle(12));
        assertEquals(expectedBlack.getTriangle(13), actualBlack.getTriangle(13));

        GameBoard actualBlack2 = new GameBoard();
        assertFalse(actualBlack2.step(false, 0, 1));

        GameBoard actualWhite2 = new GameBoard();
        assertFalse(actualWhite2.step(true, 12, 13));

        GameBoard actualWhite3 = new GameBoard();
        actualWhite3.getTriangle(0).setTriangle(0,Color.EMPTY);
        actualWhite3.getTriangle(23).setTriangle(1, Color.WHITE);
        actualWhite3.step(true, 23, 1000);
        GameBoard expectedWhite3 = new GameBoard();
        expectedWhite3.getTriangle(23).setTriangle(0, Color.EMPTY);
        assertEquals(actualWhite3.getTriangle(23), expectedWhite3.getTriangle(23));

        GameBoard actualBlack3 = new GameBoard();
        actualBlack3.getTriangle(12).setTriangle(0,Color.EMPTY);
        actualBlack3.getTriangle(11).setTriangle(1, Color.BLACK);
        actualBlack3.step(true, 11, 1000);
        GameBoard expectedBlack3 = new GameBoard();
        expectedWhite3.getTriangle(11).setTriangle(0, Color.EMPTY);
        assertEquals(actualBlack3.getTriangle(11), expectedBlack3.getTriangle(11));
    }

    @Test
    void isWinGame() {
        GameBoard test = new GameBoard();
        test.setOutCounterBlack(15);
        assertEquals(1, test.isWinGame());
        test.setOutCounterBlack(0);
        test.setOutCounterWhite(15);
        assertEquals(2, test.isWinGame());
        test.setOutCounterWhite(0);
        assertEquals(0, test.isWinGame());
    }

    @Test
    void rollDice() {
        GameBoard test = new GameBoard();
        ArrayList<Integer> steps = test.rollDice();
        if (steps.get(0).equals(steps.get(1))) {
            assertEquals(steps.get(2), steps.get(3));
            assertEquals(steps.get(1), steps.get(2));
        } else {
            assertEquals(2, steps.size());
        }
    }

    @Test
    void canThrowAway() {
        GameBoard test = new GameBoard();
        test.getTriangle(0).setTriangle(0, Color.EMPTY);
        test.getTriangle(12).setTriangle(0, Color.EMPTY);
        test.getTriangle(23).setTriangle(14,Color.WHITE);
        test.getTriangle(22).setTriangle(1,Color.WHITE);
        assertTrue(test.canThrowAway(true));

        test.getTriangle(23).setTriangle(0, Color.EMPTY);
        test.getTriangle(11).setTriangle(14, Color.BLACK);
        test.getTriangle(10).setTriangle(1, Color.BLACK);
        assertTrue(test.canThrowAway(false));

        test.getTriangle(22).setTriangle(0,Color.WHITE);
        test.getTriangle(1).setTriangle(1,Color.WHITE);
        test.getTriangle(10).setTriangle(0, Color.BLACK);
        test.getTriangle(13).setTriangle(1, Color.BLACK);
        assertFalse(test.canThrowAway(true));
        assertFalse(test.canThrowAway(false));
    }
}