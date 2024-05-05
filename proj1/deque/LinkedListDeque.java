package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        private StuffNode(StuffNode prev, T item, StuffNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private StuffNode sentinel;
    private int size;

    //create a no-argument LinkedListDeque//
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        StuffNode newNode = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size = size + 1;
    }
    public void addLast(T item) {
        StuffNode newNode = new StuffNode(sentinel.prev, item, sentinel);
        newNode.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }


    public T removeFirst() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T first = getFirst();
        if (size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;

        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
        }
        return first;

    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T last = getLast();
        if (size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;
        } else {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
        }
        return last;

    }

    public T get(int index) {
        if (index < 0) {
            return null;
        }
        int nodeind = 0;
        for (StuffNode p = sentinel.next; p.item != null; p = p .next) {
            if (nodeind != index) {
                nodeind += 1;
            } else {
                return p.item;
            }
        }
        return null;
    }
    private T getLast() {
        return sentinel.prev.item;
    }
    private T getFirst() {
        return sentinel.next.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursionHelper(index, sentinel.next);

    }

    private T getRecursionHelper(int index, StuffNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursionHelper(index - 1, node.next);
    }
    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println("this is printDeque");
    }


    public Iterator<T> iterator() {
        return new LLDIterator();
    }

    private class LLDIterator implements Iterator<T> {
        private int curr;

        LLDIterator() {
            curr = 0;
        }

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = get(curr);
            curr++;
            return item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!(other.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }



}
