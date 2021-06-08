package GUI;

import javax.swing.*;
import Assets.*;


public class Tile extends JButton {
    private TileColor color;
    private Piece piece;
    private int tile_x, tile_y;

    /**
     * constructor for creating a tile. 
     * @param tile_x x location of the tile
     * @param tile_y y location of the tile.
     * @param color color of the tile
     * @param piece chess piece on the tile (can be none)
     */
    Tile(int tile_x, int tile_y, TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;
        this.tile_x = tile_x;
        this.tile_y = tile_y;

        setOpaque(true);
        setBorderPainted(false);
        setTileColor(color);
    }

    /**
     *  set tile's color
     * @param color
     */
    public void setColor(TileColor color) {
        this.color = color;
    }

    /**
     * get tile's color
     * @return TileColor
     */
    public TileColor getTileColor() {
        return color;
    }

    /**
     * get piece on the tile
     * @return Piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * set piece on the tile.
     * @param piece the piece to set on the tile
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece == null)  return;
        this.piece.setXY(tile_x, tile_y);
    }

    /**
     * get the x location of the tile
     * @return Tile's y location
     */
    public int getTile_x() { return tile_x; }

    /**
     * get the y location of the tile
     * @return Tile's y location
     */
    public int getTile_y() { return tile_y; }

    /**
     * set the tile's background color
     * @param color Tile's background color
     */
    public void setTileColor(TileColor color){
        this.color = color;
        super.setBackground(color.getColor());
    }
    
}