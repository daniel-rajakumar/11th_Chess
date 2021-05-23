package GUI;

import java.awt.*;

import javax.swing.*;

import GamePeaces.Piece1;
import GamePeaces.Piece;

public class Board extends JPanel {
    private Tile[][] tile = new Tile[8][8];


    public Board(String text){
       setBackground(Color.green);
       setPreferredSize(new Dimension(800, 800));
       setLayout(new GridLayout(8,8));

       draw();
    }

    void draw(){
        setBoard();
        addBoard();
        pieceSetup();
        printPieces();
    }

    void setBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j) % 2 == 0) tile[i][j] = new Tile(TileColor.LIGHT, null);
                else                tile[i][j] = new Tile(TileColor.DARK, null);
            }
        }

    }

    void addBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                add(tile[i][j]);
            }
        }
    }

    void pieceSetup(){
        Piece.Color black = Piece.Color.BLACK;
        Piece.Color white = Piece.Color.WHITE;

        tile[0][0].setPiece(Piece.ROOK, black);
        tile[0][1].setPiece(Piece.KNIGHT, black);
        tile[0][2].setPiece(Piece.BISHOP, black);
        tile[0][3].setPiece(Piece.KING, black);
        tile[0][4].setPiece(Piece.QUEEN, black);
        tile[0][5].setPiece(Piece.BISHOP, black);
        tile[0][6].setPiece(Piece.KNIGHT, black);
        tile[0][7].setPiece(Piece.ROOK, black);
        for (int i = 0; i < 8; i ++) tile[1][i].setPiece(Piece.PAWN, black);
        for (int i = 0; i < 8; i ++) tile[6][i].setPiece(Piece.PAWN, white);
        tile[7][0].setPiece(Piece.ROOK, white);
        tile[7][1].setPiece(Piece.KNIGHT, white);
        tile[7][2].setPiece(Piece.BISHOP, white);
        tile[7][3].setPiece(Piece.KING, white);
        tile[7][4].setPiece(Piece.QUEEN, white);
        tile[7][5].setPiece(Piece.BISHOP, white);
        tile[7][6].setPiece(Piece.KNIGHT, white);
        tile[7][7].setPiece(Piece.ROOK, white);

    }

    void printPieces(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String name = tile[i][j].getPiece() + "";

                if (tile[i][j].getPiece() != null){
                    System.out.println(i + ", " + j + " => " + tile[i][j].getPiece().getColor() + " = " + Piece.Color.BLACK);
                    if (tile[i][j].getPiece()
                                .getColor()
                                .equals(Piece.Color.BLACK)){
                        name = "B_" + name;
                    } 

                    if (tile[i][j].getPiece()
                                .getColor()
                                .equals(Piece.Color.WHITE)){
                        name = "W_" + name;
                    } 

                    tile[i][j].setLabel(name);
                }

            }

        }

    }



}


