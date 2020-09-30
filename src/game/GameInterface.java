package game;

import game.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameInterface {
    private HashMap<Integer, Image> picturesBlack;
    private HashMap<Integer, Image> picturesWhite;
    private HashMap<Integer, Image> dices;
    private GameBoard gameBoard;
    private Integer triangleNumberFirst;
    private Integer triangleNumberLast;
    private ArrayList<Integer> step;
    private int count = 0;
    private boolean isWhite = true;
    private int tempStep = 0;
    private String turn = "White turn";
    private boolean isEquals;
    private boolean isTurnFromHead = false;

    @FXML
    private FlowPane upperPart;

    @FXML
    private FlowPane upperLeft;

    @FXML
    private FlowPane lowerRight;

    @FXML
    private ImageView tr12;

    @FXML
    private ImageView tr11;

    @FXML
    private ImageView tr10;

    @FXML
    private ImageView tr9;

    @FXML
    private ImageView tr8;

    @FXML
    private ImageView tr7;

    @FXML
    private ImageView tr6;

    @FXML
    private ImageView tr5;

    @FXML
    private ImageView tr4;

    @FXML
    private ImageView tr3;

    @FXML
    private ImageView tr2;

    @FXML
    private ImageView tr1;

    @FXML
    private FlowPane lowerPart;

    @FXML
    private ImageView tr13;

    @FXML
    private ImageView tr14;

    @FXML
    private ImageView tr15;

    @FXML
    private ImageView tr16;

    @FXML
    private ImageView tr17;

    @FXML
    private ImageView tr18;

    @FXML
    private ImageView tr19;

    @FXML
    private ImageView tr20;

    @FXML
    private ImageView tr21;

    @FXML
    private ImageView tr22;

    @FXML
    private ImageView tr23;

    @FXML
    private ImageView tr24;

    @FXML
    private Button diceRoller;

    @FXML
    private ImageView diceOne;

    @FXML
    private ImageView diceTwo;

    @FXML
    private Label diceValue;

    @FXML
    public void rollDice() {
        step = gameBoard.rollDice();
        diceValue.setText("Your dices are: \n" + step.get(0) + ", " + step.get(1) + "\n" + turn);
        diceOne.setImage(dices.get(step.get(0)));
        diceTwo.setImage(dices.get(step.get(1)));
        diceRoller.setDisable(true);
        tempStep = step.size();
        isEquals = step.get(0).equals(step.get(1)) && (step.get(0).equals(3) || step.get(0).equals(4) || step.get(0).equals(6));
    }

    public GameInterface() throws FileNotFoundException {
        gameBoard = new GameBoard();
        setMapDice();
        setMapImages();
    }

    public void draw() {
        tr1.setImage(setTheImage(gameBoard.getTriangle(0)));
        tr2.setImage(setTheImage(gameBoard.getTriangle(1)));
        tr3.setImage(setTheImage(gameBoard.getTriangle(2)));
        tr4.setImage(setTheImage(gameBoard.getTriangle(3)));
        tr5.setImage(setTheImage(gameBoard.getTriangle(4)));
        tr6.setImage(setTheImage(gameBoard.getTriangle(5)));
        tr7.setImage(setTheImage(gameBoard.getTriangle(6)));
        tr8.setImage(setTheImage(gameBoard.getTriangle(7)));
        tr9.setImage(setTheImage(gameBoard.getTriangle(8)));
        tr10.setImage(setTheImage(gameBoard.getTriangle(9)));
        tr11.setImage(setTheImage(gameBoard.getTriangle(10)));
        tr12.setImage(setTheImage(gameBoard.getTriangle(11)));
        tr13.setImage(setTheImage(gameBoard.getTriangle(12)));
        tr14.setImage(setTheImage(gameBoard.getTriangle(13)));
        tr15.setImage(setTheImage(gameBoard.getTriangle(14)));
        tr16.setImage(setTheImage(gameBoard.getTriangle(15)));
        tr17.setImage(setTheImage(gameBoard.getTriangle(16)));
        tr18.setImage(setTheImage(gameBoard.getTriangle(17)));
        tr19.setImage(setTheImage(gameBoard.getTriangle(18)));
        tr20.setImage(setTheImage(gameBoard.getTriangle(19)));
        tr21.setImage(setTheImage(gameBoard.getTriangle(20)));
        tr22.setImage(setTheImage(gameBoard.getTriangle(21)));
        tr23.setImage(setTheImage(gameBoard.getTriangle(22)));
        tr24.setImage(setTheImage(gameBoard.getTriangle(23)));
        tr13.setRotate(180);
        tr14.setRotate(180);
        tr15.setRotate(180);
        tr16.setRotate(180);
        tr17.setRotate(180);
        tr18.setRotate(180);
        tr19.setRotate(180);
        tr20.setRotate(180);
        tr21.setRotate(180);
        tr22.setRotate(180);
        tr23.setRotate(180);
        tr24.setRotate(180);

    }

    public Image setTheImage(Triangle tr) {
        if (tr.isBlack()) {
            return picturesBlack.get(tr.getAmount());
        } else {
            return picturesWhite.get(tr.getAmount());
        }
    }

    private void setMapDice() throws FileNotFoundException {
        dices = new HashMap<>();
        dices.put(1, new Image(new FileInputStream("src/game/resources/diceSide1.jpg")));
        dices.put(2, new Image(new FileInputStream("src/game/resources/diceSide2.jpg")));
        dices.put(3, new Image(new FileInputStream("src/game/resources/diceSide3.jpg")));
        dices.put(4, new Image(new FileInputStream("src/game/resources/diceSide4.jpg")));
        dices.put(5, new Image(new FileInputStream("src/game/resources/diceSide5.jpg")));
        dices.put(6, new Image(new FileInputStream("src/game/resources/diceSide6.jpg")));
    }

    private void setMapImages() throws FileNotFoundException {
        picturesBlack = new HashMap<>();
        picturesBlack.put(0, new Image(new FileInputStream("src/game/resources/checkSetBlack0.png")));
        picturesBlack.put(1, new Image(new FileInputStream("src/game/resources/checkSetBlack1.png")));
        picturesBlack.put(2, new Image(new FileInputStream("src/game/resources/checkSetBlack2.png")));
        picturesBlack.put(3, new Image(new FileInputStream("src/game/resources/checkSetBlack3.png")));
        picturesBlack.put(4, new Image(new FileInputStream("src/game/resources/checkSetBlack4.png")));
        picturesBlack.put(5, new Image(new FileInputStream("src/game/resources/checkSetBlack5.png")));
        picturesBlack.put(6, new Image(new FileInputStream("src/game/resources/checkSetBlack6.png")));
        picturesBlack.put(7, new Image(new FileInputStream("src/game/resources/checkSetBlack7.png")));
        picturesBlack.put(8, new Image(new FileInputStream("src/game/resources/checkSetBlack8.png")));
        picturesBlack.put(9, new Image(new FileInputStream("src/game/resources/checkSetBlack9.png")));
        picturesBlack.put(10, new Image(new FileInputStream("src/game/resources/checkSetBlack10.png")));
        picturesBlack.put(11, new Image(new FileInputStream("src/game/resources/checkSetBlack11.png")));
        picturesBlack.put(12, new Image(new FileInputStream("src/game/resources/checkSetBlack12.png")));
        picturesBlack.put(13, new Image(new FileInputStream("src/game/resources/checkSetBlack13.png")));
        picturesBlack.put(14, new Image(new FileInputStream("src/game/resources/checkSetBlack14.png")));
        picturesBlack.put(15, new Image(new FileInputStream("src/game/resources/checkSetBlack15.png")));

        picturesWhite = new HashMap<>();
        picturesWhite.put(0, new Image(new FileInputStream("src/game/resources/checkSetWhite0.png")));
        picturesWhite.put(1, new Image(new FileInputStream("src/game/resources/checkSetWhite1.png")));
        picturesWhite.put(2, new Image(new FileInputStream("src/game/resources/checkSetWhite2.png")));
        picturesWhite.put(3, new Image(new FileInputStream("src/game/resources/checkSetWhite3.png")));
        picturesWhite.put(4, new Image(new FileInputStream("src/game/resources/checkSetWhite4.png")));
        picturesWhite.put(5, new Image(new FileInputStream("src/game/resources/checkSetWhite5.png")));
        picturesWhite.put(6, new Image(new FileInputStream("src/game/resources/checkSetWhite6.png")));
        picturesWhite.put(7, new Image(new FileInputStream("src/game/resources/checkSetWhite7.png")));
        picturesWhite.put(8, new Image(new FileInputStream("src/game/resources/checkSetWhite8.png")));
        picturesWhite.put(9, new Image(new FileInputStream("src/game/resources/checkSetWhite9.png")));
        picturesWhite.put(10, new Image(new FileInputStream("src/game/resources/checkSetWhite10.png")));
        picturesWhite.put(11, new Image(new FileInputStream("src/game/resources/checkSetWhite11.png")));
        picturesWhite.put(12, new Image(new FileInputStream("src/game/resources/checkSetWhite12.png")));
        picturesWhite.put(13, new Image(new FileInputStream("src/game/resources/checkSetWhite13.png")));
        picturesWhite.put(14, new Image(new FileInputStream("src/game/resources/checkSetWhite14.png")));
        picturesWhite.put(15, new Image(new FileInputStream("src/game/resources/checkSetWhite15.png")));
    }

    private void setValue(int num) {
        if (count < tempStep && canMove()) {
            boolean isOk = false;
            if (triangleNumberFirst == null) {
                triangleNumberFirst = num;
                //подсвечивать ход
            } else {
                triangleNumberLast = num;
                for (int i = 0; i < step.size(); i++) {
                    if (triangleNumberLast == 1000 && gameBoard.canThrowAway(isWhite)) {
                        if (24 - triangleNumberFirst <= step.get(i) && isWhite || !isWhite && triangleNumberFirst > 5 && triangleNumberFirst < 12) {
                            isOk = true;
                            step.remove(i);
                            break;
                        }
                    }
                    if (triangleNumberLast - triangleNumberFirst == step.get(i) || !isWhite &&
                            (24 - triangleNumberFirst + triangleNumberLast == step.get(i))) {
                        isOk = true;
                        if (isTurnFromHead && (triangleNumberFirst == 0 && isWhite || triangleNumberFirst == 12 && !isWhite) && !isEquals) {
                            isOk = false;
                            break;
                        }
                        step.remove(i);
                        break;
                    }
                }

                if (isOk && gameBoard.step(isWhite, triangleNumberFirst, triangleNumberLast)) {
                    count++;
                    if (triangleNumberFirst == 0 && isWhite || triangleNumberFirst == 12 && !isWhite)
                        isTurnFromHead = true;
                }

                triangleNumberLast = null;
                triangleNumberFirst = null;

                if (count == tempStep) {
                    isTurnFromHead = false;
                    count = 0;
                    isWhite = !isWhite;
                    if (isWhite) {
                        turn = "White turn";
                    } else {
                        turn = "Black turn";
                    }
                    switch (gameBoard.isWinGame()) {
                        case 0:
                            diceRoller.setDisable(false);
                            step.clear();
                            break;
                        case 1:
                            diceRoller.setText("Black wins");
                            break;
                        case 2:
                            diceRoller.setText("White wins");
                            break;
                    }
                }
            }
        }
        draw();
    }

    private boolean canMove() {
        for (int element : step) {
            for (int i = 0; i < 24; i++) {
                if (isWhite) {
                    if (!gameBoard.getTriangle(i + element).isBlack()) {
                        return true;
                    }
                } else {
                    if (gameBoard.getTriangle(i + element).isWhite()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @FXML
    void setValue1(MouseEvent event) {
        setValue(0);
    }

    @FXML
    void setValue2(MouseEvent event) {
        setValue(1);
    }

    @FXML
    void setValue3(MouseEvent event) {
        setValue(2);
    }

    @FXML
    void setValue4(MouseEvent event) {
        setValue(3);
    }

    @FXML
    void setValue5(MouseEvent event) {
        setValue(4);
    }

    @FXML
    void setValue6(MouseEvent event) {
        setValue(5);
    }

    @FXML
    void setValue7(MouseEvent event) {
        setValue(6);
    }

    @FXML
    void setValue8(MouseEvent event) {
        setValue(7);
    }

    @FXML
    void setValue9(MouseEvent event) {
        setValue(8);
    }

    @FXML
    void setValue10(MouseEvent event) {
        setValue(9);
    }

    @FXML
    void setValue11(MouseEvent event) {
        setValue(10);
    }

    @FXML
    void setValue12(MouseEvent event) {
        setValue(11);
    }

    @FXML
    void setValue13(MouseEvent event) {
        setValue(12);
    }

    @FXML
    void setValue14(MouseEvent event) {
        setValue(13);
    }

    @FXML
    void setValue15(MouseEvent event) {
        setValue(14);
    }

    @FXML
    void setValue16(MouseEvent event) {
        setValue(15);
    }

    @FXML
    void setValue17(MouseEvent event) {
        setValue(16);
    }

    @FXML
    void setValue18(MouseEvent event) {
        setValue(17);
    }

    @FXML
    void setValue19(MouseEvent event) {
        setValue(18);
    }

    @FXML
    void setValue20(MouseEvent event) {
        setValue(19);
    }

    @FXML
    void setValue21(MouseEvent event) {
        setValue(20);
    }

    @FXML
    void setValue22(MouseEvent event) {
        setValue(21);
    }

    @FXML
    void setValue23(MouseEvent event) {
        setValue(22);
    }

    @FXML
    void setValue24(MouseEvent event) {
        setValue(23);
    }

    @FXML
    private void outThrow(MouseEvent event) {
        setValue(1000);
    }
}
