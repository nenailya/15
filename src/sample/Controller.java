package sample;

import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static sample.SolverKt.dodo;
import static sample.smth.*;

public class Controller {
    public ImageView cell000;
    @FXML
    GridPane gridPane;

    public void winMessage() {
        for(Node n : gridPane.getChildren()){
            ImageView img = (ImageView) n;
            img.setImage(images.get(777));
        }
    }

    public void cell000(MouseEvent mouseEvent) {}
    public void  start(MouseEvent mouseEvent) { startState(); updateUI();}
    public void  cell1(MouseEvent mouseEvent) { fooForEachCell(0, 0);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell2(MouseEvent mouseEvent) { fooForEachCell(0, 1);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell3(MouseEvent mouseEvent) { fooForEachCell(0, 2);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell4(MouseEvent mouseEvent) { fooForEachCell(0, 3);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell5(MouseEvent mouseEvent) { fooForEachCell(1, 0);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell6(MouseEvent mouseEvent) { fooForEachCell(1, 1);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell7(MouseEvent mouseEvent) { fooForEachCell(1, 2);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell8(MouseEvent mouseEvent) { fooForEachCell(1, 3);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell9(MouseEvent mouseEvent) { fooForEachCell(2, 0);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell10(MouseEvent mouseEvent) { fooForEachCell(2, 1);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell11(MouseEvent mouseEvent) { fooForEachCell(2, 2);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell12(MouseEvent mouseEvent) { fooForEachCell(2, 3);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell13(MouseEvent mouseEvent) { fooForEachCell(3, 0);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell14(MouseEvent mouseEvent) { fooForEachCell(3, 1);updateUI(); if (checkWin(array)) winMessage(); }
    public void cell15(MouseEvent mouseEvent) { fooForEachCell(3, 2);updateUI(); if (checkWin(array)) winMessage(); }
    public void  cell0(MouseEvent mouseEvent) { fooForEachCell(3, 3);updateUI(); if (checkWin(array)) winMessage(); }
    public void  help(MouseEvent mouseEvent) { System.out.println(dodo()); }

    public void startState(){
        Random i = new Random();
        int m = i.nextInt();
        fooForEachCell(3,2);
        fooForEachCell(2,2);
        for (int j = 0; j < m; j++){
            fooForEachCell(i.nextInt(3), i.nextInt(3));
        }

    }

    public boolean checkWin(int[][] array) {
        int[][] test = new int[4][4];
        var m = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                test[i][j] = m;
                m++;
            }
        }
        test[3][3] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != array[i][j]) return false;
            }
        }
        return true;
    }

    public void updateUI() {
        for(Node n : gridPane.getChildren()){
            ImageView img = (ImageView) n;
            img.setImage(images.get(smth.array[GridPane.getRowIndex(n)][GridPane.getColumnIndex(n)]));
        }
    }

    public Controller() {
        try {
            images.put(0, new Image(new FileInputStream("src/sample/images/0.png")));
            images.put(1, new Image(new FileInputStream("src/sample/images/1.png")));
            images.put(2, new Image(new FileInputStream("src/sample/images/2.png")));
            images.put(3, new Image(new FileInputStream("src/sample/images/3.png")));
            images.put(4, new Image(new FileInputStream("src/sample/images/4.png")));
            images.put(5, new Image(new FileInputStream("src/sample/images/5.png")));
            images.put(6, new Image(new FileInputStream("src/sample/images/6.png")));
            images.put(7, new Image(new FileInputStream("src/sample/images/7.png")));
            images.put(8, new Image(new FileInputStream("src/sample/images/8.png")));
            images.put(9, new Image(new FileInputStream("src/sample/images/9.png")));
            images.put(10, new Image(new FileInputStream("src/sample/images/10.png")));
            images.put(11, new Image(new FileInputStream("src/sample/images/11.png")));
            images.put(12, new Image(new FileInputStream("src/sample/images/12.png")));
            images.put(13, new Image(new FileInputStream("src/sample/images/13.png")));
            images.put(14, new Image(new FileInputStream("src/sample/images/14.png")));
            images.put(15, new Image(new FileInputStream("src/sample/images/15.png")));
            images.put(777, new Image(new FileInputStream("src/sample/images/777.jpg")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Map<Integer, Image> images = new HashMap<>();

}
