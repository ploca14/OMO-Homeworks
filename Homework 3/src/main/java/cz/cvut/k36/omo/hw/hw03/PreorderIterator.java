package cz.cvut.k36.omo.hw.hw03;

import java.util.NoSuchElementException;

public class PreorderIterator implements CustomIterator {

    private Node next;

    public PreorderIterator(Node root) {
        this.next = root;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int contents = next.getContents();

        if (next.getLeft() != null) {
            next = next.getLeft();
        } else if (next.getRight() != null) {
            next = next.getRight();
        } else {
            while (next.getParent().getRight() == next || next.getParent().getRight() == null) {
                next = next.getParent();

                if (next.getParent() == null) {
                    next = null;
                    return contents;
                }
            }
            next = next.getParent().getRight();
        }

        return contents;
    }
}
