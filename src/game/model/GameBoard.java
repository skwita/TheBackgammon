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

    public void setOutCounterBlack (int num) {this.outCounterBlack = num;}

    public void setOutCounterWhite (int num) {this.outCounterWhite = num;}

    public Triangle getTriangle(int num) {return board[num];}

    public boolean step(boolean isWhite, int initialPosition, int endPosition) {
        Color current;
        if (isWhite){
            current = Color.WHITE;
        } else current = Color.BLACK;
        if (endPosition == 1000) {
            board[initialPosition].removeChecker();
            if (current == Color.BLACK){
                outCounterBlack++;
            } else {
                outCounterWhite++;
            }
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

    public boolean canThrowAway(boolean isWhite){
        int count = 0;
        if (isWhite) {
            for (int i = 18; i < 24; i++){
                if (board[i].getColor().equals(Color.WHITE)) {
                    count += board[i].getAmount();
                }
            }
            return count + outCounterWhite == 15;
        } else {
            for (int i = 6; i < 12; i++){
                if (board[i].getColor().equals(Color.BLACK)){
                    count += board[i].getAmount();
                }
            }
            return count + outCounterBlack == 15;
        }
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
}