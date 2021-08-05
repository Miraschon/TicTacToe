package com.tictactoe;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        Player player = new Player(board);

        System.out.println("X или О?");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("X")){
            player.isCrossHuman =true;
        }else if(scanner.nextLine().equals("O")){
            player.isCrossHuman =false;
        }
        if(player.isCrossHuman){
            player.userMove();
            board.print();
        }
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
