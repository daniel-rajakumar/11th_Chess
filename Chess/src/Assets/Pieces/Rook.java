package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Rook extends Piece {
    private final PieceType type = PieceType.ROOK; 

    public Rook(PieceColor color) {
        super(color);
    }
    
}
