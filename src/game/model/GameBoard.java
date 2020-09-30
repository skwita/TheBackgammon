package game.model;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    private final Triangle[] board = new Triangle[24];
    private int outCounterBlack = 0;
    private int outCounterWhite = 0;

    public GameBoard() {
        for (int i = 0; i < 24; i++) {
            board[i] = new Triangle(i);
        }
    }

    public boolean step(boolean isWhite, int initialPosition, int endPosition) {
        Color current;
        if (isWhite){
            current = Color.WHITE;
        } else current = Color.BLACK;
        if (endPosition == 1000) {
            board[initialPosition].removeChecker();
            outCounterWhite++;
            return true;
        }
        if (!current.equals(board[initialPosition].getColor())) return false;
        if (!current.equals(board[endPosition].getColor()) && board[endPosition].getColor() != Color.EMPTY) return false;
        board[initialPosition].removeChecker();

            if (isWhite) {
                board[endPosition].addChecker(Color.WHITE);
            } else {
                board[endPosition].addChecker(Color.BLACK);
            }
        return true;
    }


    public int isWinGame() {
        if (outCounterBlack == 15) {
            System.out.println("Black wins");
            return 1;
        } else if (outCounterWhite == 15) {
            System.out.println("White wins");
            return 2;
        }
        return 0;
    }

    public ArrayList<Integer> rollDice() {
        ArrayList<Integer> steps = new ArrayList<>();
        Random random = new Random();
        int firstDice = random.nextInt(6) + 1;
        int secondDice = random.nextInt(6) + 1;
        if (firstDice == secondDice) {
            for (int i = 0; i < 4; i++) {
                steps.add(firstDice);
            }
        } else {
            steps.add(firstDice);
            steps.add(secondDice);
        }
        return steps;
    }

    public game.model.Triangle getTriangle(int num) {
        return board[num];
    }
}