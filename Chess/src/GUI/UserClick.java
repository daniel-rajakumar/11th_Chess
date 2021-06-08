package GUI;

import java.awt.event.*;
import Assets.*;

class UserClick implements ActionListener {
    static boolean whiteTurn = true;
    static boolean showLegalMove = true;
    Tile button;
    private Piece prev_piece, piece;
    private PieceColor pieceColor, prev_pieceColor;
    private TileColor tileColor;
    int x, y;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.button = (Tile) e.getSource();
        this.tileColor = button.getTileColor();
        this.piece = button.getPiece();
        this.x = button.getTile_x();
        this.y = button.getTile_y();

        if (Board.getFocusedPiece() != null){
            if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT)){
                this.prev_piece = Board.getFocusedPiece();
                this.pieceColor = Board.getFocusedPiece().getColor();
                move();
            }
        } else {
                showLegalMove();
        }




       if (button.getPiece() == null) return;

        // Board.setPreviousPiece(button.getPiece());
    }

    

    public void showLegalMove(){
        if (button.getPiece() == null) return;

        if ( whiteTurn && button.getPiece().getColor().equals(PieceColor.BLACK)) return;
        if (!whiteTurn && button.getPiece().getColor().equals(PieceColor.WHITE)) return;

        changeTileColor(x, y);

        if (whiteTurn){ 
            for (int i = 0; i < Board.tile.length; i++) 
                for (int j = 0; j < Board.tile[i].length; j++) 
                    changeTileColor(i, j);
        } else {
            for (int i = 0; i < Board.tile.length; i++) 
                for (int j = 0; j < Board.tile[i].length; j++) 
                    changeTileColor(i, j);
        }



        Board.setFocusedPiece(button.getPiece());
    }

    static void changeTileColor(int x, int y){
        if (Board.tile[x][y].getTileColor().equals(TileColor.DARK))
            Board.tile[x][y].setTileColor(TileColor.LEGAL_DARK);
        else
            Board.tile[x][y].setTileColor(TileColor.LEGAL_LIGHT);
    }


    public void move(){
        // print();
        // System.out.println("pre_piececolor: " + pieceColor);
        // if      ( whiteTurn && pieceColor.equals(PieceColor.WHITE)) moveWhite();
        // else if (!whiteTurn && pieceColor.equals(PieceColor.BLACK)) moveBlack();
        int x1 = prev_piece.getX(), y1 = prev_piece.getY();
        int x2 = this.x, y2 = this.y;

        // System.out.println("x1: " + prev_piece.getX() + " | y1: " + prev_piece.getY());
        // System.out.println("x1: " + x + " | y1: " + y);

        if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT)){
            prev_piece.move(x, y);
        }


        Board.printPieces();
        Board.setFocusedPiece(null);
        if (x1 != x2 || y1 != y2) whiteTurn = !whiteTurn;

    }

    void print(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
        System.out.println("whiteturn: " + whiteTurn);
        System.out.println("prv_piece: " + prev_piece.getClass().getSimpleName());
        System.out.println("prev_color: " + pieceColor);
        System.out.println("\n\n");

    }

    public Piece getPiece() { return prev_piece; }




}


