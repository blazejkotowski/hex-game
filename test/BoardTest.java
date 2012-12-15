import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.Board;

public class BoardTest {
  @Test
  public void testBoardConstructor() {
    Board board = new Board(4);
    assertTrue(board.getSize() == 4);
  }

  @Test(expected=RuntimeException.class)
  public void testMinimalBoardSize() {
    Board board = new Board(3);
  }
}
