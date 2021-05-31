package Assets;


public class Piece {
    private PieceColor color;

    public Piece(PieceColor color){
        this.color = color;
    }

    public void setColor(PieceColor color) { this.color = color; }

    public PieceColor getColor() { return color; }
}