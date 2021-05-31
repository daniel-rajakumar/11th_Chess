package Assets;

public enum PieceType {
    KING(99999999),
    QUEEN(9),
    ROOK(5),
    KNIGHT(3),
    BISHOP(3),
    PAWN(1);

    int value;

    PieceType(int value){
        this.value = value;
    }
}