import org.junit.*;
import java.util.Set;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.hexgame.core.Field;

public class FieldTest {
  Field field;

  @Before
  public void setUp() {
    field = new Field(2, 3);
  }

  @Test
  public void testInitializing() {
    assertEquals(field.xCoordinate, 2);
    assertEquals(field.yCoordinate, 3);
  }

  @Test
  public void testShouldBeEquals() {
    assertTrue(field.equals(new Field(2, 3)));
  }

  @Test
  public void testShouldNotBeEquals() {
    assertFalse(field.equals(new Field(3, 3)));
  }

  @Test
  public void testShouldBeIncludedInSet() {
    Set<Field> set = new HashSet();
    set.add(field);
    assertTrue(set.contains(new Field(2, 3)));
  }

  @Test
  public void testShouldNotBeIncludedInSet() {
    Set<Field> set = new HashSet();
    set.add(field);
    assertFalse(set.contains(new Field(3, 3)));
  }
}
