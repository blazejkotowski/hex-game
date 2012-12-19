import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.PieceType;

public class PieceTypeTest {
  @Test
  public void testInvertWhite() {
    PieceType pieceType = PieceType.WHITE;
    assertEquals(pieceType.invert(), PieceType.BLACK);
  }

  @Test
  public void testInvertBlack() {
    PieceType pieceType = PieceType.BLACK;
    assertEquals(pieceType.invert(), PieceType.WHITE);
  }
}
