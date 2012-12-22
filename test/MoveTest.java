import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.PieceType;
import org.hexgame.core.Board;
import org.hexgame.core.Move;

public class MoveTest {
  @Test
  public void testInitializingWithWhitePiece() {
    Move move = new Move(new Board(4), PieceType.WHITE, 3, 2);
    assertEquals(move.getPieceType(), PieceType.WHITE);
    assertEquals(move.xCoordinate, 3);
    assertEquals(move.yCoordinate, 2);
  }

  @Test
  public void testInitializingWithBlackPiece() {
    Move move = new Move(new Board(4), PieceType.BLACK, 3, 2);
    assertEquals(move.getPieceType(), PieceType.BLACK);
  }

  @Test
  public void testValidMove() {
    Board board = new Board(4);
    Move move = new Move(board, PieceType.WHITE, 1, 1);
    assertTrue(move.isValid());
  }

  @Test
  public void testInvalidMoveIfFieldIsOccupied() {
    Board board = new Board(4);
    board.placePiece(1, 1, PieceType.BLACK);
    Move move = new Move(board, PieceType.WHITE, 1, 1);
    assertFalse(move.isValid());
  }

  @Test
  public void testInvalidMoveIfFieldIsOutOfBounds() {
    Board board = new Board(4);
    Move move = new Move(board, PieceType.WHITE, 6, 1);
    assertFalse(move.isValid());
  }
}
