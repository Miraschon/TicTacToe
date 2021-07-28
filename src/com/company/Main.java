package com.company;


public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        Player player = new Player(board);

        while (!player.isFinished()) {
            player.computerMove();
            board.print();
            if (player.isFinished()) {
                board.print();
                break;
            }
            player.userMove();
            board.print();
        }
    }
}
