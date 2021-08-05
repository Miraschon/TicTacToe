package com.company;


import java.util.Scanner;

public class Player {
    private Board board;
    public int counter = 0;
    public boolean isCrossHuman;

    public Player(Board board) {
        this.board = board;
    }

    public boolean defense() {
        if(!isCrossHuman){
        return
                board.putIfRow(0, -2, Cell.CROSS) ||
                        board.putIfRow(1, -2, Cell.CROSS) ||
                        board.putIfRow(2, -2, Cell.CROSS) ||
                        board.putIfCol(0, -2, Cell.CROSS) ||
                        board.putIfCol(1, -2, Cell.CROSS) ||
                        board.putIfCol(2, -2, Cell.CROSS) ||
                        board.putIfDiagLeft(-2, Cell.CROSS) ||
                        board.putIfDiagRight(-2, Cell.CROSS);

    }else{
            return
                    board.putIfRow(0, 2, Cell.ZERO) ||
                            board.putIfRow(1, 2, Cell.ZERO) ||
                            board.putIfRow(2, 2, Cell.ZERO) ||
                            board.putIfCol(0, 2, Cell.ZERO) ||
                            board.putIfCol(1, 2, Cell.ZERO) ||
                            board.putIfCol(2, 2, Cell.ZERO) ||
                            board.putIfDiagLeft(2, Cell.ZERO) ||
                            board.putIfDiagRight(2, Cell.ZERO);
        }
    }

    public boolean attack() {
        if (!isCrossHuman) {
            return
                    board.putIfRow(0, 2, Cell.CROSS) ||
                            board.putIfRow(1, 2, Cell.CROSS) ||
                            board.putIfRow(2, 2, Cell.CROSS) ||
                            board.putIfCol(0, 2, Cell.CROSS) ||
                            board.putIfCol(1, 2, Cell.CROSS) ||
                            board.putIfCol(2, 2, Cell.CROSS) ||
                            board.putIfDiagLeft(2, Cell.CROSS) ||
                            board.putIfDiagRight(2, Cell.CROSS);

        } else {
            return
                    board.putIfRow(0, -2, Cell.ZERO) ||
                            board.putIfRow(1, -2, Cell.ZERO) ||
                            board.putIfRow(2, -2, Cell.ZERO) ||
                            board.putIfCol(0, -2, Cell.ZERO) ||
                            board.putIfCol(1, -2, Cell.ZERO) ||
                            board.putIfCol(2, -2, Cell.ZERO) ||
                            board.putIfDiagLeft(-2, Cell.ZERO) ||
                            board.putIfDiagRight(-2, Cell.ZERO);
        }
    }

    public boolean move() {
        if (!isCrossHuman) {
            return
                    board.putIfRowNE(0, 2, Cell.CROSS) ||
                            board.putIfRowNE(1, 2, Cell.CROSS) ||
                            board.putIfRowNE(2, 2, Cell.CROSS) ||
                            board.putIfColNE(0, 2, Cell.CROSS) ||
                            board.putIfColNE(1, 2, Cell.CROSS) ||
                            board.putIfColNE(2, 2, Cell.CROSS) ||
                            board.putIfDiagLeftNE(2, Cell.CROSS) ||
                            board.putIfDiagRightNE(2, Cell.CROSS);
        } else {
            return
                    board.putIfRowNE(0, -2, Cell.ZERO) ||
                            board.putIfRowNE(1, -2, Cell.ZERO) ||
                            board.putIfRowNE(2, -2, Cell.ZERO) ||
                            board.putIfColNE(0, -2, Cell.ZERO) ||
                            board.putIfColNE(1, -2, Cell.ZERO) ||
                            board.putIfColNE(2, -2, Cell.ZERO) ||
                            board.putIfDiagLeftNE(-2, Cell.ZERO) ||
                            board.putIfDiagRightNE(-2, Cell.ZERO);
        }
    }

    public void computerMove() {
        if (counter == 0 && !isCrossHuman) {
            board.putCross(1, 1);
            counter++;
            return;
        }
            if (!attack()) {
                if (!defense()) {
                    move();
                }
            }

        counter++;
    }

    public void userMove() {
        int x, y;
        boolean isUserMove;
        do {
            System.out.println("Введите x");
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
            System.out.println("Введите y");
            y = scanner.nextInt();
            if(!isCrossHuman) {
                isUserMove = board.putZero(x, y);
            }else{
                isUserMove = board.putCross(x, y);
            }
            if (!isUserMove) {
                System.out.println("Клетка занята");
            }
        } while (!isUserMove);

    }

    public boolean isFinished() {
        return board.isWon();
    }


}

