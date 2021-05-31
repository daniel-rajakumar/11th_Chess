package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Knight extends Piece {
    private final PieceType type = PieceType.KNIGHT; 

    public Knight(PieceColor color) {
        super(color);
    }
    
}