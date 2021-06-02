package Assets;

import GUI.Board;
import GUI.Tile;

public class Piece {
    private PieceColor color;
    private int x, y;
    

    public Piece(PieceColor color){
        this.color = color;
    }

    public void setColor(PieceColor color) { this.color = color; }

    public PieceColor getColor() { return color; }

    public void move(int new_x, int new_y){
        Piece piece = Board.tile[this.x][this.y].getPiece();
        Board.tile[this.x][this.y].setPiece(null); 
        Board.tile[new_x][new_y].setPiece(piece); 
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

}