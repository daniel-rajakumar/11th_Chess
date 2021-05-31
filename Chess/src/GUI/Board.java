package GUI;

import java.awt.*;

import javax.swing.*;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Board extends JPanel {
    private Tile[][] tile = new Tile[8][8];


    public Board(String text){
       setOpaque(true);
       
       setBackground(Color.red);
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
        PieceColor black = PieceColor.BLACK;
        PieceColor white = PieceColor.WHITE;

        tile[0][0].setPiece(PieceType.ROOK, black);
        tile[0][1].setPiece(PieceType.KNIGHT, black);
        tile[0][2].setPiece(PieceType.BISHOP, black);
        tile[0][3].setPiece(PieceType.KING, black);
        tile[0][4].setPiece(PieceType.QUEEN, black);
        tile[0][5].setPiece(PieceType.BISHOP, black);
        tile[0][6].setPiece(PieceType.KNIGHT, black);
        tile[0][7].setPiece(PieceType.ROOK, black);
        for (int i = 0; i < 8; i ++) tile[1][i].setPiece(PieceType.PAWN, black);
        for (int i = 0; i < 8; i ++) tile[6][i].setPiece(PieceType.PAWN, white);
        tile[7][0].setPiece(PieceType.ROOK, white);
        tile[7][1].setPiece(PieceType.KNIGHT, white);
        tile[7][2].setPiece(PieceType.BISHOP, white);
        tile[7][3].setPiece(PieceType.KING, white);
        tile[7][4].setPiece(PieceType.QUEEN, white);
        tile[7][5].setPiece(PieceType.BISHOP, white);
        tile[7][6].setPiece(PieceType.KNIGHT, white);
        tile[7][7].setPiece(PieceType.ROOK, white);

    }

    void printPieces(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tile[i][j].getPiece() != null){
                    String name = tile[i][j].getPiece().getType() + "";

                    // set up black pieces
                    if (tile[i][j].getPiece()
                                .getColor()
                                .equals(PieceColor.BLACK)){
                        tile[i][j].setForeground(Color.BLACK);
                    } 

                    // set up white pieces
                    if (tile[i][j].getPiece()
                                .getColor()
                                .equals(PieceColor.WHITE)){
                        tile[i][j].setForeground(Color.BLUE);
                    } 

                    tile[i][j].setLabel(name);
                }

            }

        }

    }



}


