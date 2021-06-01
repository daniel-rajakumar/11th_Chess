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

        if (color.equals(TileColor.DARK)) setBackground(Color.decode("#EEEED2"));
        else                              setBackground(Color.decode("#769656"));
    }

    public TileColor getTileColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.piece.setXY(x, y);
    }

    public int getX() { return x; }
    public int getY() { return y; }

}
