package GamePeaces;

public enum Pieces {

    KING(99999999),
    QUEEN(9),
    ROOK(5),
    KNIGHT(3),
    BISHOP(3),
    PAWN(1);

    // color
    public static enum Color {
        WHITE,
        BLACK
    }

    int value;
    Color color;

    Pieces(int value){
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

}
