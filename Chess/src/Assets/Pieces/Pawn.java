package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Pawn extends Piece {

    private final PieceType type = PieceType.PAWN; 

    public Pawn(PieceColor color) {
        super(color);
    }
    
}
