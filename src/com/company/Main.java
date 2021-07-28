package com.company;


public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        Player player = new Player(board);

        while (true) {
            player.computerMove();
            board.print();
            if (player.isFinished()) {
                break;
            }
            player.userMove();
            if (player.isFinished()) {
                board.print();
                break;
            }
        }
    }
}
