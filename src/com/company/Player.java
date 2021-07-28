package com.company;


import java.util.Scanner;

public class Player {
    private Board board;
    private int counter=0;

    public Player(Board board) {
        this.board = board;
    }
    public boolean defense(){
        int firstRow = 0, secondRow = 0, thirdRow = 0, firstColumn = 0, secondColumn = 0, thirdColumn = 0, diagonalRight = 0, diagonalLeft = 0;

        for (int i = 0; i < 3; i++) {
            firstRow = firstRow + board.get(0,i);
            secondRow = secondRow + board.get(1,i);
            thirdRow = thirdRow + board.get(2,i);
            firstColumn = firstColumn + board.get(i,0);
            secondColumn = secondColumn + board.get(i,1);
            thirdColumn = thirdColumn + board.get(i,2);
            diagonalRight = diagonalRight + board.get(i,i);
            diagonalLeft = diagonalLeft + board.get(i,2-i);
        }

        if (firstRow==-2) {
            for (int i=0;i<3;i++){
                if(board.get(0,i)==0){
                    board.putCross(0,i);
                    return true;
                }
            }
        }
        if (secondRow==-2) {
            for (int i=0;i<3;i++){
                if(board.get(1,i)==0){
                    board.putCross(1,i);
                    return true;
                }
            }
        }
        if (thirdRow==-2) {
            for (int i=0;i<3;i++){
                if(board.get(2,i)==0){
                    board.putCross(2,i);
                    return true;
                }
            }
        }
        if (firstColumn==-2) {
            for (int i=0;i<3;i++){
                if(board.get(i,0)==0){
                    board.putCross(i,0);
                    return true;
                }
            }
        }
        if (secondColumn==-2) {
            for (int i=0;i<3;i++){
                if(board.get(i,1)==0){
                    board.putCross(i,1);
                    return true;
                }
            }
        }
        if (thirdColumn==-2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2)==0){
                    board.putCross(i,2);
                    return true;
                }
            }
        }
        if (diagonalRight==-2) {
            for (int i=0;i<3;i++){
                if(board.get(i,i)==0){
                    board.putCross(i,i);
                    return true;
                }
            }
        }
        if (diagonalLeft==-2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2-i)==0){
                    board.putCross(i,2-i);
                    return true;
                }
            }
        }
        return false;
    }
    public void attack(){
        int firstRow = 0, secondRow = 0, thirdRow = 0, firstColumn = 0, secondColumn = 0, thirdColumn = 0, diagonalRight = 0, diagonalLeft = 0;

        for (int i = 0; i < 3; i++) {
            firstRow = firstRow + board.get(0,i);
            secondRow = secondRow + board.get(1,i);
            thirdRow = thirdRow + board.get(2,i);
            firstColumn = firstColumn + board.get(i,0);
            secondColumn = secondColumn + board.get(i,1);
            thirdColumn = thirdColumn + board.get(i,2);
            diagonalRight = diagonalRight + board.get(i,i);
            diagonalLeft = diagonalLeft + board.get(i,2-i);
        }

        if (firstRow==2) {
            for (int i=0;i<3;i++){
                if(board.get(0,i)==0){
                    board.putCross(0,i);
                    return;
                }
            }
        }
        if (secondRow==2) {
            for (int i=0;i<3;i++){
                if(board.get(1,i)==0){
                    board.putCross(1,i);
                    return;
                }
            }
        }
        if (thirdRow==2) {
            for (int i=0;i<3;i++){
                if(board.get(2,i)==0){
                    board.putCross(2,i);
                    return;
                }
            }
        }
        if (firstColumn==2) {
            for (int i=0;i<3;i++){
                if(board.get(i,0)==0){
                    board.putCross(i,0);
                    return;
                }
            }
        }
        if (secondColumn==2) {
            for (int i=0;i<3;i++){
                if(board.get(i,1)==0){
                    board.putCross(i,1);
                    return;
                }
            }
        }
        if (thirdColumn==2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2)==0){
                    board.putCross(i,2);
                    return;
                }
            }
        }
        if (diagonalRight==2) {
            for (int i=0;i<3;i++){
                if(board.get(i,i)==0){
                    board.putCross(i,i);
                    return;
                }
            }
        }
        if (diagonalLeft==2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2-i)==0){
                    board.putCross(i,2-i);
                    return;
                }
            }
        }

        if (firstRow!=2) {
            for (int i=0;i<3;i++){
                if(board.get(0,i)==0){
                    board.putCross(0,i);
                    return;
                }
            }
        }
        if (secondRow!=2) {
            for (int i=0;i<3;i++){
                if(board.get(1,i)==0){
                    board.putCross(1,i);
                    return;
                }
            }
        }
        if (thirdRow!=2) {
            for (int i=0;i<3;i++){
                if(board.get(2,i)==0){
                    board.putCross(2,i);
                    return;
                }
            }
        }
        if (firstColumn!=2) {
            for (int i=0;i<3;i++){
                if(board.get(i,0)==0){
                    board.putCross(i,0);
                    return;
                }
            }
        }
        if (secondColumn!=2) {
            for (int i=0;i<3;i++){
                if(board.get(i,1)==0){
                    board.putCross(i,1);
                    return;
                }
            }
        }
        if (thirdColumn!=2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2)==0){
                    board.putCross(i,2);
                    return;
                }
            }
        }
        if (diagonalRight!=2) {
            for (int i=0;i<3;i++){
                if(board.get(i,i)==0){
                    board.putCross(i,i);
                    return;
                }
            }
        }
        if (diagonalLeft!=2) {
            for (int i=0;i<3;i++){
                if(board.get(i,2-i)==0){
                    board.putCross(i,2-i);
                    return;
                }
            }
        }

    }

    public void computerMove() {
        if(counter==0){
            board.putCross(1,1);
            return;
        }
        if(!defense()){
            attack();
        }
        counter++;
    }

    public void userMove() {
        int x, y;
        do {
            System.out.println("Введите x");
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
            System.out.println("Введите y");
            y = scanner.nextInt();
        } while (!board.putZero(x, y));

    }

    public boolean isFinished() {
        return board.isWon();
    }


}

