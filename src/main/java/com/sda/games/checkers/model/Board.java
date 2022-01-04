package com.sda.games.checkers.model;

public class Board {

    private final static int BOARD_SIDE_SIZE = 8;
    private Spot[][] boardSpots = new Spot[BOARD_SIDE_SIZE][BOARD_SIDE_SIZE];

    public Spot getBoardSpot (int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Space is out of bounds");
        }
        return boardSpots[x][y];
    }

    public void setEndBoardSpot(int startX, int startY, int endX, int endY) {
        boardSpots[endX][endY].setPiece(boardSpots[startX][startY].getPiece());
    }

    public void setBoardPieceNull(int x, int y) {
        boardSpots[x][y].setPiece(null);
    }

    public void setSpotsAfterMove(int startX, int startY, int endX, int endY) {
        setEndBoardSpot(startX, startY, endX, endY);
        setBoardPieceNull(startX, startY);
    }

    public void printBoard() {
        for (int y = BOARD_SIDE_SIZE - 1; y >= 0; y--) {
            System.out.println();
            System.out.print((y + 1) + " ");
            for (int x = 0; x < BOARD_SIDE_SIZE; x++) {
                System.out.print("|");
                if (boardSpots[x][y] == null || boardSpots[x][y].getPiece() == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(boardSpots[x][y].getPiece().getPieceIcon());
                }
            }
            System.out.print("|");
        }
        System.out.println("\n   a b c d e f g h");
    }

    public boolean spotIsWhite(int x, int y) throws Exception {
        if (getBoardSpot(x, y).getPiece().isWhite()) {
            return true;
        }
        return false;
    }

    public boolean spotHasPiece(int x, int y) throws Exception {
        if (getBoardSpot(x, y).getPiece() != null) {
            return true;
        }
        return false;
    }

    public void resetBoard() {

        // initialize white pieces
        boardSpots[0][0] = SpotFactory.regularWhite(0, 0);
        boardSpots[2][0] = SpotFactory.regularWhite(2, 0);
        boardSpots[4][0] = SpotFactory.regularWhite(4, 0);
        boardSpots[6][0] = SpotFactory.regularWhite(6, 0);
        boardSpots[1][1] = SpotFactory.regularWhite(1, 1);
        boardSpots[3][1] = SpotFactory.regularWhite(3, 1);
        boardSpots[5][1] = SpotFactory.regularWhite(5, 1);
        boardSpots[7][1] = SpotFactory.regularWhite(7, 1);
        boardSpots[0][2] = SpotFactory.regularWhite(0, 2);
        boardSpots[2][2] = SpotFactory.regularWhite(2, 2);
        boardSpots[4][2] = SpotFactory.regularWhite(4, 2);
        boardSpots[6][2] = SpotFactory.regularWhite(6, 2);

        // initialize black pieces
        boardSpots[1][5] = SpotFactory.regularBlack(1, 5);
        boardSpots[3][5] = SpotFactory.regularBlack(3, 5);
        boardSpots[5][5] = SpotFactory.regularBlack(5, 5);
        boardSpots[7][5] = SpotFactory.regularBlack(7, 5);
        boardSpots[0][6] = SpotFactory.regularBlack(0, 6);
        boardSpots[2][6] = SpotFactory.regularBlack(2, 6);
        boardSpots[4][6] = SpotFactory.regularBlack(4, 6);
        boardSpots[6][6] = SpotFactory.regularBlack(6, 6);
        boardSpots[1][7] = SpotFactory.regularBlack(1, 7);
        boardSpots[3][7] = SpotFactory.regularBlack(3, 7);
        boardSpots[5][7] = SpotFactory.regularBlack(5, 7);
        boardSpots[7][7] = SpotFactory.regularBlack(7, 7);

        // initialize empty spots
        boardSpots[1][3] = SpotFactory.emptySpot(1, 3);
        boardSpots[3][3] = SpotFactory.emptySpot(3, 3);
        boardSpots[5][3] = SpotFactory.emptySpot(5, 3);
        boardSpots[7][3] = SpotFactory.emptySpot(7, 3);
        boardSpots[0][4] = SpotFactory.emptySpot(0, 4);
        boardSpots[2][4] = SpotFactory.emptySpot(2, 4);
        boardSpots[4][4] = SpotFactory.emptySpot(4, 4);
        boardSpots[6][4] = SpotFactory.emptySpot(6, 4);

    }
}
