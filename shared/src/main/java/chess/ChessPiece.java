package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return myColor == that.myColor && myType == that.myType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myColor, myType);
    }

    ChessGame.TeamColor myColor;
    ChessPiece.PieceType myType;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.myColor = pieceColor;
        this.myType = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        //'throw new RuntimeException("Not implemented");
        return this.myColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {

//        throw new RuntimeException("Not implemented");
        return this.myType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
//        throw new RuntimeException("Not implemented");
        Collection<ChessMove> moveSet = new ArrayList<>();

        ChessPosition testPosition;
        ChessPiece testPiece;
        int testRow, testCol;

        switch(this.myType) {
            case ChessPiece.PieceType.KNIGHT:
                int[][] xyKnight = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

                for (int i = 0; i < 8; i++) {
                    testRow = myPosition.getRow() + xyKnight[i][0];
                    testCol = myPosition.getColumn() + xyKnight[i][1];

                    if (testRow > 0 && testRow < 9 && testCol > 0 && testCol < 9) {
                        testPosition = new ChessPosition(testRow, testCol);
                        testPiece = board.getPiece(testPosition);

                        if (testPiece == null || testPiece.getTeamColor() != this.myColor) {
                            moveSet.add(new ChessMove(myPosition, testPosition, null));
                        }
                    }
                }
                break;
            case ChessPiece.PieceType.KING:
                int[][] xyKing = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

                for (int i = 0; i < 8; i++) {
                    testRow = myPosition.getRow() + xyKing[i][0];
                    testCol = myPosition.getColumn() + xyKing[i][1];

                    if (testRow > 0 && testRow < 9 && testCol > 0 && testCol < 9) {
                        testPosition = new ChessPosition(testRow, testCol);
                        testPiece = board.getPiece(testPosition);

                        if (testPiece == null || testPiece.getTeamColor() != this.myColor) {
                            moveSet.add(new ChessMove(myPosition, testPosition, null));
                        }
                    }
                }
                break;
            case PAWN:
                int inc = -1;

                if (myColor == ChessGame.TeamColor.WHITE) {
                    inc = 1;
                }

                testRow = myPosition.getRow() + inc;
                testCol = myPosition.getColumn();
                testPosition = new ChessPosition(testRow, testCol);
                testPiece = board.getPiece(testPosition);

                if (testRow > 0 && testRow < 9 && testCol > 0 && testCol < 9) {
                    testPosition = new ChessPosition(testRow, testCol);
                    testPiece = board.getPiece(testPosition);

                    if (testPiece == null) {
                        if ((this.myColor == ChessGame.TeamColor.BLACK && myPosition.getRow() == 2) ||
                                this.myColor == ChessGame.TeamColor.WHITE && myPosition.getRow() == 7) {
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.QUEEN));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.BISHOP));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.KNIGHT));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.ROOK));
                        } else {
                            moveSet.add(new ChessMove(myPosition, testPosition, null));
                        }

                       if ((this.myColor == ChessGame.TeamColor.BLACK && myPosition.getRow() == 7) ||
                                this.myColor == ChessGame.TeamColor.WHITE && myPosition.getRow() == 2) {
                            testRow = testRow + inc;
                            testPosition = new ChessPosition(testRow, testCol);
                            testPiece = board.getPiece(testPosition);

                            if (testPiece == null) {
                                moveSet.add(new ChessMove(myPosition, testPosition, null));
                            }
                        }
                    }
                }

                testRow = myPosition.getRow() + inc;
                testCol = myPosition.getColumn() - 1;
                testPosition = new ChessPosition(testRow, testCol);
                testPiece = board.getPiece(testPosition);

                if (testRow > 0 && testRow < 9 && testCol > 0 && testCol < 9) {
                    testPosition = new ChessPosition(testRow, testCol);
                    testPiece = board.getPiece(testPosition);

                    if (testPiece != null && testPiece.getTeamColor() != this.myColor) {
                        if ((this.myColor == ChessGame.TeamColor.BLACK && myPosition.getRow() == 2) ||
                                this.myColor == ChessGame.TeamColor.WHITE && myPosition.getRow() == 7) {
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.QUEEN));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.BISHOP));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.KNIGHT));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.ROOK));
                        } else {
                            moveSet.add(new ChessMove(myPosition, testPosition, null));
                        }
                    }
                }

                testRow = myPosition.getRow() + inc;
                testCol = myPosition.getColumn() + 1;
                testPosition = new ChessPosition(testRow, testCol);
                testPiece = board.getPiece(testPosition);

                if (testRow > 0 && testRow < 9 && testCol > 0 && testCol < 9) {
                    testPosition = new ChessPosition(testRow, testCol);
                    testPiece = board.getPiece(testPosition);

                    if (testPiece != null && testPiece.getTeamColor() != this.myColor) {
                        if ((this.myColor == ChessGame.TeamColor.BLACK && myPosition.getRow() == 2) ||
                                this.myColor == ChessGame.TeamColor.WHITE && myPosition.getRow() == 7) {
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.QUEEN));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.BISHOP));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.KNIGHT));
                            moveSet.add(new ChessMove(myPosition, testPosition, ChessPiece.PieceType.ROOK));
                        } else {
                            moveSet.add(new ChessMove(myPosition, testPosition, null));
                        }
                    }
                }

                break;
            default:
                break;
        }




        return moveSet;
    }
}
