import org.junit.*;
import static org.junit.Assert.*;

import org.hexgame.core.PieceType;
import org.hexgame.core.Player;
import org.hexgame.core.Game;

public class GameTest {
  @Test
  public void testInitializing() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    assertEquals(game.getBoard().getSize(), 10);
    assertEquals(game.getPlayerA(), playerA);
    assertEquals(game.getPlayerB(), playerB);
  }
}
