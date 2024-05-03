package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        StuffNode(StuffNode prev, T item, StuffNode next) {
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
    //create a one-argument linkedListDeque
    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null, null, null);
        StuffNode newNode = new StuffNode(sentinel, item, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        size = size + 1;
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
        for (StuffNode p = sentinel.next; p.item!= null; p = p .next) {
            if (nodeind != index) {
                nodeind += 1;
            } else {
                return p.item;
            }
        }
        return null;
    }
    public T getLast() {
        return sentinel.prev.item;
    }
    public T getFirst() {
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

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public void printDeque() {
        System.out.println("this is printDeque");
    }

    public void toList() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            StuffNode temp = sentinel.next;
            System.out.print("[");
            while (temp != sentinel) {
                System.out.print(temp.item);
                if (temp.next == sentinel) {
                    break;
                }
                System.out.print(", ");
                temp = temp.next;
            }
            System.out.println("]");
        }


    }

    public Iterator<T> iterator() {
        return new LLDIterator();
    }

    private class LLDIterator implements Iterator<T> {
        private StuffNode curr;

        LLDIterator() {
            curr = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = removeFirst();
            curr = curr.next;
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
