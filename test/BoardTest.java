import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.Board;
import org.hexgame.core.PieceType;

public class BoardTest {
  Board board;

  @Before
  public void setUp() {
    board = new Board(4);
  }

  @Test
  public void testBoardConstructor() {
    assertEquals(board.getSize(), 4);
  }

  @Test(expected=RuntimeException.class)
  public void testMinimalBoardSize() {
    board = new Board(3);
  }

  @Test
  public void testCanPlacePieceOnBoard() {
    assertTrue(board.canPlacePiece(1, 1));
  }

  @Test
  public void testCanPlacePieceOnLowerPartOfTheBoard() {
    assertTrue(board.canPlacePiece(7, 4));
  }

  @Test
  public void testCannotPlacePieceOffBoard() {
    assertFalse(board.canPlacePiece(1, 2));
  }

  @Test
  public void testCannotPlacePieceOffBoard2() {
    assertFalse(board.canPlacePiece(2, -1));
  }

  @Test
  public void testCannotPlacePieceOffBoard3() {
    assertFalse(board.canPlacePiece(4, 5));
  }

  @Test
  public void testCannotPlacePieceOffBoard4() {
    assertFalse(board.canPlacePiece(7, 3));
  }

  @Test
  public void testCannotPlacePieceOffBoard5() {
    assertFalse(board.canPlacePiece(7, 5));
  }

  @Test
  public void testCannotPlacePieceOffBoard6() {
    assertFalse(board.canPlacePiece(8, 4));
  }

  @Test
  public void testCannotPlacePieceOnOccupiedField() {
    board.placePiece(1, 1, PieceType.WHITE);
    assertFalse(board.canPlacePiece(1, 1));
  }

  @Test
  public void testCannotPlacePieceOnOccupiedField2() {
    board.placePiece(1, 1, PieceType.BLACK);
    assertFalse(board.canPlacePiece(1, 1));
  }

  @Test
  public void testPlacePiece() {
    board.placePiece(1, 1, PieceType.WHITE);
  }

  @Test(expected=RuntimeException.class)
  public void testPlacePieceOutOfBoard() {
    board.placePiece(1, 3, PieceType.WHITE);
  }

  @Test
  public void testRemovePiece() {
    board.placePiece(1, 1, PieceType.WHITE);
    board.removePiece(1, 1);
    assertEquals(board.getPiece(1, 1), null);
  }

  @Test(expected=RuntimeException.class)
  public void testRemovePieceOutOfBoard() {
    board.removePiece(1, 3);
  }

  @Test
  public void testGetPieces() {
    board.placePiece(1, 1, PieceType.WHITE);
    board.placePiece(2, 1, PieceType.BLACK);

    assertEquals(board.getPiece(1, 1), PieceType.WHITE);
    assertEquals(board.getPiece(2, 1), PieceType.BLACK);
    assertEquals(board.getPiece(2, 2), null);
  }

  @Test(expected=RuntimeException.class)
  public void testgetPieceOutOfBoard() {
    board.getPiece(1, 3);
  }
}
