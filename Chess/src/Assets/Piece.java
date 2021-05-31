package Assets;


public class Piece {
    private String name;
    private PieceColor color;
    private PieceType type;

    public Piece(PieceType type, PieceColor color){
        this.type = type;
        this.color = color;
    }

    public void setName(String name) { this.name = name; }
    public void setColor(PieceColor color) { this.color = color; }
    public void setType(PieceType type) { this.type = type; }

    public String getName() { return name; }
    public PieceColor getColor() { return color; }
    public PieceType getType() { return type; }

}