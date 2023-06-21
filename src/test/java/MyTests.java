import org.example.BinaryTreeSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTests {
    private BinaryTreeSet<Integer> set;

    @BeforeEach
    public void setUp() {
        set = new BinaryTreeSet<>();
    }

    @Test
    public void testAdd() {
        Assertions.assertTrue(set.add(5));
        Assertions.assertTrue(set.add(3));
        Assertions.assertFalse(set.add(3));
        Assertions.assertTrue(set.add(8));
    }

    @Test
    public void testContains() {
        set.add(5);
        set.add(3);
        set.add(8);

        Assertions.assertTrue(set.contains(5));
        Assertions.assertTrue(set.contains(3));
        Assertions.assertTrue(set.contains(8));
        Assertions.assertFalse(set.contains(2));
    }

    @Test
    public void testRemove() {
        set.add(5);
        set.add(3);
        set.add(8);

        Assertions.assertTrue(set.remove(3));
        Assertions.assertFalse(set.remove(3));
        Assertions.assertFalse(set.contains(3));

        Assertions.assertTrue(set.remove(5));
        Assertions.assertFalse(set.contains(5));

        Assertions.assertTrue(set.remove(8));
        Assertions.assertFalse(set.contains(8));
        Assertions.assertFalse(set.remove(8));
    }

    @Test
    public void testPrintInOrder() {
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(4);
        set.add(7);

        set.printInOrder();
    }
}