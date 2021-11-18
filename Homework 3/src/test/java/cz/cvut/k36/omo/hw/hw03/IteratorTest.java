package cz.cvut.k36.omo.hw.hw03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IteratorTest {

    private Node prepareTree() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        return createNode(arr, null, 0);
    }

    public Node createNode(int[] arr, Node root, int i) {
        if (i < arr.length) {
            return new Node(arr[i], createNode(arr, null, 2 * i + 1),
                createNode(arr, null, 2 * i + 2));
        }
        return root;
    }

    @Test
    public void preorderIteratorHasNextReturnsTrue() {
        Node tree = prepareTree();

        assertTrue(tree.preorderIterator().hasNext());
    }

    @Test
    public void preorderIteratorIteratesCorrectly() {
        Node tree = prepareTree();

        CustomIterator iterator = tree.preorderIterator();
        List<Integer> result = new LinkedList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = List.of(0, 1, 3, 7, 8, 4, 9, 2, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    public void inorderIteratorIteratesCorrectly() {
        Node tree = prepareTree();

        CustomIterator iterator = tree.inorderIterator();
        List<Integer> result = new LinkedList<>();
        while (iterator.hasNext()) {
            int next = iterator.next();
            result.add(next);
        }

        List<Integer> expected = List.of(7, 3, 8, 1, 9, 4, 0, 5, 2, 6);
        assertEquals(expected, result);
    }

    @Test
    public void postorderIteratorIteratesCorrectly() {
        Node tree = prepareTree();

        CustomIterator iterator = tree.postorderIterator();
        List<Integer> result = new LinkedList<>();
        while (iterator.hasNext()) {
            int next = iterator.next();
            result.add(next);
        }

        List<Integer> expected = List.of(7, 8, 3, 9, 4, 1, 5, 6, 2, 0);
        assertEquals(expected, result);
    }
}
