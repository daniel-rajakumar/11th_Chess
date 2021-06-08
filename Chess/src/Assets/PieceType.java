package Assets;

public enum PieceType {
    KING(99999999),
    QUEEN(9),
    ROOK(5),
    KNIGHT(3),
    BISHOP(3),
    PAWN(1);

    int value;

    /**
     * constructor for creating a PieceType 
     * @param value the game value of the chess piece (example: rook = 5, pawn = 1)
     */
    PieceType(int value){
        this.value = value;
    }
}