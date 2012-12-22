import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.PieceType;
import org.hexgame.core.Player;
import org.hexgame.core.Board;
import org.hexgame.core.Move;

public class MoveTest {
  Player playerA, playerB;
  Move   move;
  Board  board;

  @Before
  public void setUp() {
    board = new Board(4);
    playerA = new Player(PieceType.WHITE);
    playerB = new Player(PieceType.BLACK);
  }

  @Test
  public void testInitializingWithWhitePiece() {
    move = new Move(board, playerA, 3, 2);
    assertEquals(move.getPlayer(), playerA);
    assertEquals(move.xCoordinate, 3);
    assertEquals(move.yCoordinate, 2);
  }

  @Test
  public void testInitializingWithBlackPiece() {
    move = new Move(board, playerB, 3, 2);
    assertEquals(move.getPlayer(), playerB);
  }

  @Test
  public void testValidMove() {
    move = new Move(board, playerA, 1, 1);
    assertTrue(move.isValid());
  }

  @Test
  public void testInvalidMoveIfFieldIsOccupied() {
    board.placePiece(1, 1, PieceType.BLACK);
    move = new Move(board, playerA, 1, 1);
    assertFalse(move.isValid());
  }

  @Test
  public void testInvalidMoveIfFieldIsOutOfBounds() {
    move = new Move(board, playerA, 6, 1);
    assertFalse(move.isValid());
  }

  @Test
  public void testPerformValidMove() {
    move = new Move(board, playerA, 1, 1);
    move.perform();
    assertEquals(board.getPiece(1, 1), PieceType.WHITE);
  }

  @Test(expected=RuntimeException.class)
  public void testPerformInvalidMove() {
    move = new Move(board, playerA, 1, 2);
    move.perform();
  }
}
