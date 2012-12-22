import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.Board;
import org.hexgame.core.PieceType;

public class BoardTest {
  @Test
  public void testBoardConstructor() {
    Board board = new Board(4);
    assertEquals(board.getSize(), 4);
  }

  @Test(expected=RuntimeException.class)
  public void testMinimalBoardSize() {
    Board board = new Board(3);
  }

  @Test
  public void testCanPlacePieceOnBoard() {
    Board board = new Board(4);
    assertTrue(board.canPlacePiece(1, 1));
  }

  @Test
  public void testCanPlacePieceOnLowerPartOfTheBoard() {
    Board board = new Board(4);
    assertTrue(board.canPlacePiece(7, 4));
  }

  @Test
  public void testCannotPlacePieceOffBoard() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(1, 2));
  }

  @Test
  public void testCannotPlacePieceOffBoard2() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(2, -1));
  }

  @Test
  public void testCannotPlacePieceOffBoard3() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(4, 5));
  }

  @Test
  public void testCannotPlacePieceOffBoard4() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(7, 3));
  }

  @Test
  public void testCannotPlacePieceOffBoard5() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(7, 5));
  }

  @Test
  public void testCannotPlacePieceOffBoard6() {
    Board board = new Board(4);
    assertFalse(board.canPlacePiece(8, 4));
  }

  @Test
  public void testCannotPlacePieceOnOccupiedField() {
    Board board = new Board(4);
    board.placePiece(1, 1, PieceType.WHITE);
    assertFalse(board.canPlacePiece(1, 1));
  }

  @Test
  public void testCannotPlacePieceOnOccupiedField2() {
    Board board = new Board(4);
    board.placePiece(1, 1, PieceType.BLACK);
    assertFalse(board.canPlacePiece(1, 1));
  }

  @Test
  public void testPlacePiece() {
    Board board = new Board(4);
    board.placePiece(1, 1, PieceType.WHITE);
  }

  @Test(expected=RuntimeException.class)
  public void testPlacePieceOutOfBoard() {
    Board board = new Board(4);
    board.placePiece(1, 3, PieceType.WHITE);
  }

  @Test
  public void testGetPieces() {
    Board board = new Board(4);
    board.placePiece(1, 1, PieceType.WHITE);
    board.placePiece(2, 1, PieceType.BLACK);

    assertEquals(board.getPiece(1, 1), PieceType.WHITE);
    assertEquals(board.getPiece(2, 1), PieceType.BLACK);
    assertEquals(board.getPiece(2, 2), null);
  }

  @Test(expected=RuntimeException.class)
  public void testgetPieceOutOfBoard() {
    Board board = new Board(4);
    board.getPiece(1, 3);
  }

}
