package GUI;

import java.awt.event.*;
import Assets.*;

class UserClick implements ActionListener {
    static boolean whiteTurn = true;
    static boolean showLegalMove = true;
    private Tile button;
    private Piece focused_piece;
    private PieceColor pieceColor;
    private TileColor tileColor;
    int tile_x, tile_y;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.button = (Tile) e.getSource();
        this.tileColor = button.getTileColor();
        this.tile_x = button.getTile_x();
        this.tile_y = button.getTile_y();

        moveOrShowLegalMove();
    }

    /**
     * shows legal moves or move the piece to its legal clicken sport
     */
    public void moveOrShowLegalMove(){
        if (Board.getFocusedPiece() != null){
            if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT)){
                this.focused_piece = Board.getFocusedPiece();
                this.pieceColor = Board.getFocusedPiece().getColor();
                move();
            }
        } else {
            showLegalMove();
        }
    }

    

    /**
     * show legal moves of the clicked piece by changing the tile color.
     */
    public void showLegalMove(){
        if (button.getPiece() == null) return;

        if ( whiteTurn && button.getPiece().getColor().equals(PieceColor.BLACK)) return;
        if (!whiteTurn && button.getPiece().getColor().equals(PieceColor.WHITE)) return;

        changeTileColor(tile_x, tile_y);

        // if (whiteTurn){ } else { }

        for (int i = 0; i < Board.tile.length; i++) 
            for (int j = 0; j < Board.tile[i].length; j++) {
                Piece current_piece = Board.tile[i][j].getPiece();
                Piece focused_piece =  Board.tile[tile_x][tile_y].getPiece();

                if (current_piece == null || (current_piece.getColor() != focused_piece.getColor()))
                    changeTileColor(i, j);
           }

        Board.setFocusedPiece(button.getPiece());
    }

    /**
     * highlight the color of the tile which the clicked piece can move.
     * @param x x location of the tile
     * @param y y location of the tile
     */
    static void changeTileColor(int x, int y){
        if (Board.tile[x][y].getTileColor().equals(TileColor.DARK))
            Board.tile[x][y].setTileColor(TileColor.LEGAL_DARK);
        else
            Board.tile[x][y].setTileColor(TileColor.LEGAL_LIGHT);
    }


    /**
     * move the chess piece to the clicked highlighted tile from its current tile.
     */
    public void move(){
        int x1 = focused_piece.getX(), y1 = focused_piece.getY();
        int x2 = this.tile_x, y2 = this.tile_y;

        if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT))
            focused_piece.move(tile_x, tile_y);

        Board.printPieces();
        Board.setFocusedPiece(null);
        if (x1 != x2 || y1 != y2) whiteTurn = !whiteTurn;

    }

    void print(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
        System.out.println("whiteturn: " + whiteTurn);
        System.out.println("prv_piece: " + focused_piece.getClass().getSimpleName());
        System.out.println("prev_color: " + pieceColor);
        System.out.println("\n\n");

    }

    /**
     * get the focued piece (one which is ready to move in next valid click)
     * @return Piece
     */
    public Piece getFocusedPiece() { 
        return focused_piece; 
    }




}


