package cz.cvut.k36.omo.hw.hw03;

import java.util.NoSuchElementException;

public class InorderIterator implements CustomIterator {

    private Node next;

    public InorderIterator(Node root) {
        this.next = root;

        while (next.getLeft() != null) {
            this.next = next.getLeft();
        }
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

        if (next.getRight() != null) {
            next = next.getRight();

            while (next.getLeft() != null) {
                this.next = next.getLeft();
            }
        } else {
            while (next.getParent() != null && next.getParent().getRight() == next) {
                next = next.getParent();
            }
            next = next.getParent();
        }

        return contents;
    }
}
