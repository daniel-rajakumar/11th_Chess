package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Pawn extends Piece {
    private final PieceType type = PieceType.PAWN; 
    private boolean firstMove = true;

    /**
     * creates a Piece as Pawn
     * @param color Pawn's color
     */
    public Pawn(PieceColor color) {
        super(color);
    }

    public void showLegalMoves(){
        

    }
    
}
