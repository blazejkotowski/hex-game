import org.junit.*;
import static org.junit.Assert.*;
import org.hexgame.core.PieceType;
import org.hexgame.core.Player;

public class PlayerTest {
  @Test
  public void testInitializingWithWhitePiece() {
    Player player = new Player(PieceType.WHITE);
    assertEquals(player.getPieceType(), PieceType.WHITE);
  }

  @Test
  public void testInitializingWithBlackPiece() {
    Player player = new Player(PieceType.BLACK);
    assertEquals(player.getPieceType(), PieceType.BLACK);
  }
}
