package chess;

import java.util.Objects;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {
    int myRow, myCol;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPosition that = (ChessPosition) o;
        return myRow == that.myRow && myCol == that.myCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myRow, myCol);
    }

    public ChessPosition(int row, int col) {
        this.myRow = row;
        this.myCol = col;
    }

    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {
//        throw new RuntimeException("Not implemented");
        return this.myRow;
    }

    /**
     * @return which column this position is in
     * 1 codes for the left column
     */
    public int getColumn() {
//        throw new RuntimeException("Not implemented");
        return this.myCol;
    }

    @Override
    public String toString() {
        return "(" + this.myRow + ", " + this.myCol + ")";
    }
}
