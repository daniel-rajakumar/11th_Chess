package GUI;

import javax.swing.JButton;

import Assets.*;

import java.awt.*;

public class Tile extends JButton {
    private TileColor color;
    private Piece piece;
    private int tile_x, tile_y;

    Tile(int tile_x, int tile_y, TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;
        this.tile_x = tile_x;
        this.tile_y = tile_y;

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
        this.piece.setXY(tile_x, tile_y);
    }



    public int getTile_x() { return tile_x; }
    public int getTile_y() { return tile_y; }


    public void setTileColor(TileColor color){
        this.color = color;
        super.setBackground(color.getColor());
    }


    
}