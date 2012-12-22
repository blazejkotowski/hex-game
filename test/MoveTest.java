import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.PieceType;
import org.hexgame.core.Move;

public class MoveTest {
  @Test
  public void testInitializingWithWhitePiece() {
    Move move = new Move(PieceType.WHITE, 3, 2);
    assertEquals(move.getPieceType(), PieceType.WHITE);
    assertEquals(move.coordinateX, 3);
    assertEquals(move.coordinateY, 2);
  }

  @Test
  public void testInitializingWithBlackPiece() {
    Move move = new Move(PieceType.BLACK, 3, 2);
    assertEquals(move.getPieceType(), PieceType.BLACK);
  }
}
