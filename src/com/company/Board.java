package com.company;

public class Board {
    private int[][] cell = new int[3][3];

    /*
    ┌─┬─┬─┐
    │x│o│x│
    ├─┼─┼─┤
    │ │ │ │
    └─┴─┴─┘
     */
    private String cellToSrting(int i) {
        if (i == -1) {
            return "o";
        } else if (i == 1) {
            return "x";
        } else return " ";
    }

    public void print() {
        String line = "      0   1   2\n" +
                "    ┌───┬───┬───┐\n" +
                "  0 │ " + cellToSrting(cell[0][0]) + " │ " + cellToSrting(cell[0][1]) + " │ " + cellToSrting(cell[0][2]) + " │\n" +
                "    ├───┼───┼───┤\n" +
                "  1 │ " + cellToSrting(cell[1][0]) + " │ " + cellToSrting(cell[1][1]) + " │ " + cellToSrting(cell[1][2]) + " │\n" +
                "    ├───┼───┼───┤\n" +
                "  2 │ " + cellToSrting(cell[2][0]) + " │ " + cellToSrting(cell[2][1]) + " │ " + cellToSrting(cell[2][2]) + " │\n" +
                "    └───┴───┴───┘";
        System.out.println(line);
    }

    public boolean putCross(int x, int y) {
        cell[y][x] = 1;
        return true;
    }

    public boolean putZero(int x, int y) {
        if (cell[y][x] == 1 || cell[y][x] == -1) {
            return false;
        } else {
            cell[y][x] = -1;
            return true;
        }
    }

/*    public int get(int x, int y) {
        return cell[y][x];
    }*/

    public boolean isWon() {
        int firstRow = 0, secondRow = 0, thirdRow = 0, firstColumn = 0, secondColumn = 0, thirdColumn = 0, diagonalRight = 0, diagonalLeft = 0;

        for (int i = 0; i < 3; i++) {
            firstRow = firstRow + cell[0][i];
            secondRow = secondRow + cell[1][i];
            thirdRow = thirdRow + cell[2][i];
            firstColumn = firstColumn + cell[i][0];
            secondColumn = secondColumn + cell[i][1];
            thirdColumn = thirdColumn + cell[i][2];
            diagonalRight = diagonalRight + cell[i][i];
            diagonalLeft = diagonalLeft + cell[i][2 - i];
        }

        if (firstRow == 3 || secondRow == 3 || thirdRow == 3 || firstColumn == 3 || secondColumn == 3 || thirdColumn == 3 || diagonalRight == 3 || diagonalLeft == 3) {
                    System.out.println("X player won");
            return true;
        } else if (firstRow == -3 || secondRow == -3 || thirdRow == -3 || firstColumn == -3 || secondColumn == -3 || thirdColumn == -3 || diagonalRight == -3 || diagonalLeft == -3) {
            System.out.println("O player won");
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cell[i][j] == 0) {
                        return false;
                    }
                }
            }
            System.out.println("It's a tie");
            return true;
        }
    }

    /**
     * делает ход в строку, если строка соответствует критерию checkSum
     *
     * @param idx номер строки
     * @param checkSum сумма элементов, которая соответсвует критерию
     * @param cellType крестик или нолик
     * @return true если ход сделан
     */
    public boolean putIfRow(int idx, int checkSum, Cell cellType) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[idx][i];
        }
        if (sum == checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[idx][i] == 0) {
                    putCross(i, idx);
                    return true;
                } else if (cellType == Cell.ZERO && cell[idx][i] == 0) {
                    putZero(i, idx);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfCol(int idx, int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][idx];
        }
        if (sum == checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][idx] == 0) {
                    putCross(idx, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][idx] == 0) {
                    putZero(idx, i);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfDiagLeft(int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][i];
        }
        if (sum == checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][i] == 0) {
                    putCross(i, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][i] == 0) {
                    putZero(i, i);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfDiagRight(int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][2-i];
        }
        if (sum == checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][2-i] == 0) {
                    putCross(2-i, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][2-i] == 0) {
                    putZero(2-i,i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean putIfRowNE(int idx, int checkSum, Cell cellType) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[idx][i];
        }
        if (sum != checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[idx][i] == 0) {
                    putCross(i, idx);
                    return true;
                } else if (cellType == Cell.ZERO && cell[idx][i] == 0) {
                    putZero(i, idx);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfColNE(int idx, int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][idx];
        }
        if (sum != checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][idx] == 0) {
                    putCross(idx, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][idx] == 0) {
                    putZero(idx, i);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfDiagLeftNE(int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][i];
        }
        if (sum != checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][i] == 0) {
                    putCross(i, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][i] == 0) {
                    putZero(i, i);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean putIfDiagRightNE(int checkSum, Cell cellType){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += cell[i][2-i];
        }
        if (sum != checkSum) {
            for (int i = 0; i < 3; i++) {
                if (cellType == Cell.CROSS && cell[i][2-i] == 0) {
                    putCross(2-i, i);
                    return true;
                } else if (cellType == Cell.ZERO && cell[i][2-i] == 0) {
                    putZero(2-i,i);
                    return true;
                }
            }
        }
        return false;
    }
}
