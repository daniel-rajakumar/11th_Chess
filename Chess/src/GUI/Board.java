package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;
import Assets.Pieces.Bishop;
import Assets.Pieces.King;
import Assets.Pieces.Knight;
import Assets.Pieces.Pawn;
import Assets.Pieces.Queen;
import Assets.Pieces.Rook;

public class Board extends JPanel {
    public static Tile[][] tile = new Tile[8][8];


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
        tileAction();
    }

    void setBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j) % 2 == 0) tile[i][j] = new Tile(i, j, TileColor.LIGHT, null);
                else                tile[i][j] = new Tile(i, j, TileColor.DARK, null);
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

        tile[0][0].setPiece(new Rook(black));
        tile[0][1].setPiece(new Knight(black));
        tile[0][2].setPiece(new Bishop(black));
        tile[0][3].setPiece(new King(black));
        tile[0][4].setPiece(new Queen(black));
        tile[0][5].setPiece(new Bishop(black));
        tile[0][6].setPiece(new Knight(black));
        tile[0][7].setPiece(new Rook(black));
        for (int i = 0; i < 8; i ++) tile[1][i].setPiece(new Pawn(black));
        for (int i = 0; i < 8; i ++) tile[6][i].setPiece(new Pawn(white));
        tile[7][0].setPiece(new Rook(white));
        tile[7][1].setPiece(new Knight(white));
        tile[7][2].setPiece(new Bishop(white));
        tile[7][3].setPiece(new King(white));
        tile[7][4].setPiece(new Queen(white));
        tile[7][5].setPiece(new Bishop(white));
        tile[7][6].setPiece(new Knight(white));
        tile[7][7].setPiece(new Rook(white));

    }

    public static void printPieces(){
        System.out.println("hello");
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                if (tile[i][j].getPiece() != null){
                    String name = tile[i][j].getPiece().getClass().getSimpleName() + "";

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
                } else {
                    tile[i][j].setLabel("");
                }


            }

        }
    }

    void tileAction(){
        for (int i = 0; i < tile.length; i++){
            for (int j = 0; j < tile.length; j++){
                tile[i][j].addActionListener(new click());
            }
        }
    }

    



}

class click implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Tile button = (Tile) e.getSource();

        if (button.getPiece() == null) return;

        int x = button.getPiece().getX();
        int y = button.getPiece().getY();
        System.out.println("( " + x + ", " + y + " )");

        // Board.tile[x][y].getPiece().move(x - 1, y);
        Board.tile[x -1][y].setTileColor(TileColor.LEGAL);
    }

    
}



