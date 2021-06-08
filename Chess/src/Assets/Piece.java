package Assets;

import GUI.Board;

public class Piece {
    private PieceColor color;
    private int x, y;
    
    /**
     * creates a Piece.
     * @param color Piece's color
     */
    public Piece(PieceColor color){
        this.color = color;
    }

    /**
     * set color of the piece (white/black)
     * @param color Piece's color
     */
    public void setColor(PieceColor color) { 
        this.color = color; 
    }

    /**
     * get the color of the piece (white/black)
     * @return PieceColor
     */
    public PieceColor getColor() { 
        return color; 
    }

    /**
     * move the piece to the given new_x and new_y location.
     * @param new_x moving piece's new x location
     * @param new_y moving piece's new y location
     */
    public void move(int new_x, int new_y){
        Piece piece = Board.tile[this.x][this.y].getPiece();
        Board.tile[this.x][this.y].setPiece(null); 
        Board.tile[new_x][new_y].setPiece(piece); 
    }

    /**
     * set the x and y location of the piece
     * @param x x location of the piece of the baord
     * @param y y location of the piece
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x location of the Piece of the board.
     * @return x location of the piece.
     */
    public int getX() { 
        return x; 
    }

    /**
     * get the y location of the Piece of the board.
     * @return y location of the piece.
     */
    public int getY() { 
        return y; 
    }

}