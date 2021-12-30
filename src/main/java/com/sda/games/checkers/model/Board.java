package com.sda.games.checkers.model;

public class Board {

    private final static int BORDER_SIZE = 8;
    private Spot[][] boardSpots = new Spot[BORDER_SIZE][BORDER_SIZE];

    public Spot getBoardSpot (int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Space is out of bounds");
        }
        return boardSpots[x][y];
    }

    public void setBoardSpot(Spot boardSpot) {
        boardSpots[boardSpot.getX()][boardSpot.getY()] = boardSpot;
        this.boardSpots = boardSpots;
    }

    public void printBoard() {
        for (int y = 7; y >= 0; y--) {
            System.out.println();
            System.out.print((y + 1) + " ");
            for (int x = 0; x < 8; x++) {
                System.out.print("|");
                if (boardSpots[y][x] == null || boardSpots[y][x].getPiece() == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(boardSpots[y][x].getPiece().getPieceIcon());
                }
            }
            System.out.print("|");
        }
        System.out.println("\n   a b c d e f g h");
    }

    public void resetBoard() {
        // initialize white pieces
        boardSpots[0][0] = new Spot(0,0,new RegularPiece(true));
        boardSpots[0][2] = new Spot(0,2,new RegularPiece(true));
        boardSpots[0][4] = new Spot(0,4,new RegularPiece(true));
        boardSpots[0][6] = new Spot(0,5,new RegularPiece(true));
        boardSpots[1][1] = new Spot(1,1,new RegularPiece(true));
        boardSpots[1][3] = new Spot(1,3,new RegularPiece(true));
        boardSpots[1][5] = new Spot(1,5,new RegularPiece(true));
        boardSpots[1][7] = new Spot(1,7,new RegularPiece(true));
        boardSpots[2][0] = new Spot(2,0,new RegularPiece(true));
        boardSpots[2][2] = new Spot(2,2,new RegularPiece(true));
        boardSpots[2][4] = new Spot(2,4,new RegularPiece(true));
        boardSpots[2][6] = new Spot(2,6,new RegularPiece(true));

        // initialize black pieces
        boardSpots[5][1] = new Spot(5,1,new RegularPiece(false));
        boardSpots[5][3] = new Spot(5,3,new RegularPiece(false));
        boardSpots[5][5] = new Spot(5,5,new RegularPiece(false));
        boardSpots[5][7] = new Spot(5,7,new RegularPiece(false));
        boardSpots[6][0] = new Spot(6,0,new RegularPiece(false));
        boardSpots[6][2] = new Spot(6,2,new RegularPiece(false));
        boardSpots[6][4] = new Spot(6,4,new RegularPiece(false));
        boardSpots[6][6] = new Spot(6,6,new RegularPiece(false));
        boardSpots[7][1] = new Spot(7,1,new RegularPiece(false));
        boardSpots[7][3] = new Spot(7,3,new RegularPiece(false));
        boardSpots[7][5] = new Spot(7,5,new RegularPiece(false));
        boardSpots[7][7] = new Spot(7,7,new RegularPiece(false));

        // initialize empty spots
        boardSpots[3][1] = new Spot(3,1,null);
        boardSpots[3][3] = new Spot(3,3,null);
        boardSpots[3][5] = new Spot(3,5,null);
        boardSpots[3][7] = new Spot(3,7,null);
        boardSpots[4][0] = new Spot(4,0,null);
        boardSpots[4][2] = new Spot(4,2,null);
        boardSpots[4][4] = new Spot(4,4,null);
        boardSpots[4][6] = new Spot(4,6,null);
    }

}
