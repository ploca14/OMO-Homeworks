package cz.cvut.k36.omo.hw.hw03;

import java.util.NoSuchElementException;

public class PostorderIterator implements CustomIterator {

    private Node next;

    public PostorderIterator(Node root) {
        this.next = root;

        while (next.getLeft() != null || next.getRight() != null) {
            if (next.getLeft() != null) {
                next = next.getLeft();
            } else if (next.getRight() != null) {
                next = next.getRight();
            }
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

        if (next.getParent() != null) {
            if (next.getParent().getLeft() == next) {
                if (next.getParent().getRight() != null) {
                    next = next.getParent().getRight();

                    while (next.getLeft() != null || next.getRight() != null) {
                        if (next.getLeft() != null) {
                            next = next.getLeft();
                        } else if (next.getRight() != null) {
                            next = next.getRight();
                        }
                    }
                } else {
                    next = next.getParent();
                }
            } else if (next.getParent().getRight() == next) {
                next = next.getParent();
            }
        } else {
            next = null;
        }

        return contents;
    }
}
