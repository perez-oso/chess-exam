package chess;

import java.util.*;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPosition myPosition;
    ChessPiece myPiece;

    Map<ChessPosition, ChessPiece> board = new Map<ChessPosition, ChessPiece>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public ChessPiece get(Object key) {
            return null;
        }

        @Override
        public ChessPiece put(ChessPosition key, ChessPiece value) {
            return null;
        }

        @Override
        public ChessPiece remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends ChessPosition, ? extends ChessPiece> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<ChessPosition> keySet() {
            return Set.of();
        }

        @Override
        public Collection<ChessPiece> values() {
            return List.of();
        }

        @Override
        public Set<Entry<ChessPosition, ChessPiece>> entrySet() {
            return Set.of();
        }
    };

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board.put(position, piece);
//        throw new RuntimeException("Not implemented");

    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
//        throw new RuntimeException("Not implemented");
        return board.get(position);
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
//        throw new RuntimeException("Not implemented");
        this.board.clear();
    }
}
