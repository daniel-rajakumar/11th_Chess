package GUI;

import javax.swing.JButton;

import Assets.*;

import java.awt.*;

public class Tile extends JButton {
    private TileColor color;
    private Piece piece;
    private int x, y;

    Tile(int x, int y, TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;
        this.x = x;
        this.y = y;

        setOpaque(true);
        setBorderPainted(false);
        setTileColor(color);
    }

    public void setColor(TileColor color) {
        this.color = color;
    }


    public TileColor getTileColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece == null)  return;
        this.piece.setXY(x, y);
    }

    public void setTileColor(TileColor color){
        this.color = color;
        super.setBackground(color.getColor());
    }


    
}