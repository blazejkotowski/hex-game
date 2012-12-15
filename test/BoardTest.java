import org.junit.*;
import org.hexgame.Board;

public class BoardTest extends junit.framework.TestCase {
  public void testBoardConstructor() {
    Board board = new Board(4);
    assertTrue(board.getSize() == 4);
  }
}
