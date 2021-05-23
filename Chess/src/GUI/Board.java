package GUI;

import java.awt.*;

import javax.swing.*;

import GamePeaces.Piece;
import GamePeaces.Pieces;

public class Board extends JPanel {
    private Tile[][] tile = new Tile[8][8];


    public Board(String text){
       setBackground(Color.green);
       setPreferredSize(new Dimension(400, 400));
       setLayout(new GridLayout(8,8));

       draw();
    }

    void draw(){
        setBoard();
        addBoard();
        Pieces king = Pieces.KING;
        System.out.println(king.getValue());
        System.out.println(king.getColor());
        king.setColor(Pieces.Color.BLACK);
        System.out.println(king.getColor());

        pieceSetup();

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
        tile[0][0].setPiece(Pieces.ROOK);
        

    }


}


