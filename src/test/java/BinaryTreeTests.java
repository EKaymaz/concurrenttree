import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;


public class BinaryTreeTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void insertTest() throws InterruptedException {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(30);
        tree.insert(10);
        tree.insert(70);
        tree.insert(230);
        tree.insert(44);
        tree.insert(120);

        tree.inorder();

        assertEquals("10 30 44 70 120 230 ", outContent.toString());
    }

    @Test
    public void countTest() throws InterruptedException {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(30);
        tree.insert(10);
        tree.insert(70);
        tree.insert(230);
        tree.insert(44);
        tree.insert(120);

        assertEquals(6, tree.size());

        tree.insert(111);

        assertEquals(7, tree.size());
    }

}
