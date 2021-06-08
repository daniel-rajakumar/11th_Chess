package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Assets.*;
import Assets.Pieces.*;

public class Board extends JPanel {
    public static Tile[][] tile = new Tile[8][8];

    public Board(String text){
       setOpaque(true);
       
       setBackground(Color.red);
       setPreferredSize(new Dimension(800, 800));
       setLayout(new GridLayout(8,8));

       draw();
    }

    void draw(){
        setBoard();
        addBoard();
        pieceSetup();
        printPieces();
        tileAction();
    }

    void setBoard(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if ((i+j) % 2 == 0) tile[i][j] = new Tile(i, j, TileColor.LIGHT, null);
                else                tile[i][j] = new Tile(i, j, TileColor.DARK, null);

    }

    void addBoard(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                add(tile[i][j]);

    }

    void pieceSetup(){
        PieceColor black = PieceColor.BLACK;
        PieceColor white = PieceColor.WHITE;

        tile[0][0].setPiece(new Rook(black));
        tile[0][1].setPiece(new Knight(black));
        tile[0][2].setPiece(new Bishop(black));
        tile[0][3].setPiece(new King(black));
        tile[0][4].setPiece(new Queen(black));
        tile[0][5].setPiece(new Bishop(black));
        tile[0][6].setPiece(new Knight(black));
        tile[0][7].setPiece(new Rook(black));
        for (int i = 0; i < 8; i ++) tile[1][i].setPiece(new Pawn(black));
        for (int i = 0; i < 8; i ++) tile[6][i].setPiece(new Pawn(white));
        tile[7][0].setPiece(new Rook(white));
        tile[7][1].setPiece(new Knight(white));
        tile[7][2].setPiece(new Bishop(white));
        tile[7][3].setPiece(new King(white));
        tile[7][4].setPiece(new Queen(white));
        tile[7][5].setPiece(new Bishop(white));
        tile[7][6].setPiece(new Knight(white));
        tile[7][7].setPiece(new Rook(white));

    }

    public static void printPieces(){
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {

                if (tile[i][j].getPiece() != null) tile[i][j].setIcon(getIcons(i, j, 85, 85));
                else                               tile[i][j].setIcon(null);

                if ((i+j) % 2 == 0) tile[i][j].setTileColor(TileColor.LIGHT);
                else                tile[i][j].setTileColor(TileColor.DARK);

            }

        }
    }

    public static ImageIcon getIcons(int x, int y, int width, int height){
        String name = tile[x][y].getPiece().getClass().getSimpleName();
        PieceColor pieceColor = tile[x][y].getPiece().getColor();

        if (pieceColor.equals(PieceColor.WHITE)){
            if (name.equalsIgnoreCase("pawn"))   return pieceImage("white_pawn",   width, height);
            if (name.equalsIgnoreCase("king"))   return pieceImage("white_king",   width, height);
            if (name.equalsIgnoreCase("queen"))  return pieceImage("white_queen",  width, height);
            if (name.equalsIgnoreCase("bishop")) return pieceImage("white_bishop", width, height);
            if (name.equalsIgnoreCase("knight")) return pieceImage("white_knight", width, height);
            if (name.equalsIgnoreCase("rook"))   return pieceImage("white_rook",   width, height);

        } else if (pieceColor.equals(PieceColor.BLACK)){
            if (name.equalsIgnoreCase("pawn"))   return pieceImage("black_pawn",   width, height);
            if (name.equalsIgnoreCase("king"))   return pieceImage("black_king",   width, height);
            if (name.equalsIgnoreCase("queen"))  return pieceImage("black_queen",  width, height);
            if (name.equalsIgnoreCase("bishop")) return pieceImage("black_bishop", width, height);
            if (name.equalsIgnoreCase("knight")) return pieceImage("black_knight", width, height);
            if (name.equalsIgnoreCase("rook"))   return pieceImage("black_rook",   width, height);
        }

        return null;
    }

    public static ImageIcon pieceImage(String name, int width, int height){
        String path = System.getProperty("user.dir") + "/Chess/res/img/" + name + ".png";
        System.out.println(path);
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }


    private static Piece previousPiece;

    public static Piece getPreviousPiece() { return previousPiece; }
    public static void setPreviousPiece(Piece previousPiece) { Board.previousPiece = previousPiece; }

    void tileAction(){
        for (int i = 0; i < tile.length; i++)
            for (int j = 0; j < tile.length; j++){
                tile[i][j].addActionListener(new Click());
            }

    }

    



}

class Click implements ActionListener {
    private ActionEvent e;
    static boolean whiteTurn = true;
    static boolean showLegalMove = true;
    Tile button;
    private Piece prev_piece, piece;
    private PieceColor pieceColor, prev_pieceColor;
    private TileColor tileColor;
    int x, y;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.e = e;
        this.button = (Tile) e.getSource();
        this.tileColor = button.getTileColor();
        this.piece = button.getPiece();
        this.x = button.getTile_x();
        this.y = button.getTile_y();







        if (Board.getPreviousPiece() != null){
            if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT)){
                this.prev_piece = Board.getPreviousPiece();
                this.pieceColor = Board.getPreviousPiece().getColor();
                move();
            }
        } else {
                showLegalMove();
        }




       if (button.getPiece() == null) return;

        // Board.setPreviousPiece(button.getPiece());
    }

    

    public void showLegalMove(){
        if (button.getPiece() == null) return;

        if ( whiteTurn && button.getPiece().getColor().equals(PieceColor.BLACK)) return;
        if (!whiteTurn && button.getPiece().getColor().equals(PieceColor.WHITE)) return;

        changeTileColor(x, y);

        if (whiteTurn){ 
            for (int i = 0; i < Board.tile.length; i++) 
                for (int j = 0; j < Board.tile[i].length; j++) 
                    changeTileColor(i, j);
        } else {
            for (int i = 0; i < Board.tile.length; i++) 
                for (int j = 0; j < Board.tile[i].length; j++) 
                    changeTileColor(i, j);
        }



        Board.setPreviousPiece(button.getPiece());
    }

    static void changeTileColor(int x, int y){
        if (Board.tile[x][y].getTileColor().equals(TileColor.DARK))
            Board.tile[x][y].setTileColor(TileColor.LEGAL_DARK);
        else
            Board.tile[x][y].setTileColor(TileColor.LEGAL_LIGHT);
    }


    public void move(){
        // print();
        // System.out.println("pre_piececolor: " + pieceColor);
        // if      ( whiteTurn && pieceColor.equals(PieceColor.WHITE)) moveWhite();
        // else if (!whiteTurn && pieceColor.equals(PieceColor.BLACK)) moveBlack();
        int x1 = prev_piece.getX(), y1 = prev_piece.getY();
        int x2 = this.x, y2 = this.y;

        // System.out.println("x1: " + prev_piece.getX() + " | y1: " + prev_piece.getY());
        // System.out.println("x1: " + x + " | y1: " + y);

        if (tileColor.equals(TileColor.LEGAL_DARK) || tileColor.equals(TileColor.LEGAL_LIGHT)){
            prev_piece.move(x, y);
        }


        Board.printPieces();
        Board.setPreviousPiece(null);
        if (x1 != x2 || y1 != y2) whiteTurn = !whiteTurn;

    }

    void print(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
        System.out.println("whiteturn: " + whiteTurn);
        System.out.println("prv_piece: " + prev_piece.getClass().getSimpleName());
        System.out.println("prev_color: " + pieceColor);
        System.out.println("\n\n");

    }

    public Piece getPiece() { return prev_piece; }

}



