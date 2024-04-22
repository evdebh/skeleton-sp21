package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode prev, T item, StuffNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private StuffNode sentinel;
    private int size;

    //create a no-argument LinkedListDeque//
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    //create a one-argument linkedListDeque
    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null, null,null);
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
        if(sentinel.prev == sentinel) {
            return null;
        }
        T first = getFirst();
        if(size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;

        }else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
        }
        return first;

    }

    public T removeLast() {
        if(sentinel.prev == sentinel) {
            return null;
        }
        T last = getLast();
        if(size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = size - 1;
        }else {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
        }
        return last;

    }

    public T get(int item) {
        StuffNode p = sentinel;
        while(p != null) {
            if (p.item.equals(item)) {
                return p.item;
            }
            p = p.next;
        }
        return null;
    }
    public T getLast() {
        return sentinel.prev.item;
    }
    public T getFirst() {
        return sentinel.next.item;
    }
    public T getRecursion(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return getRecursionHlepr(index, sentinel.next);

    }

    private T getRecursionHlepr(int index, StuffNode node) {
        if(index == 0) {
            return node.item;
        }
        return getRecursionHlepr(index - 1, node.next);
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    public void printDeque() {
        System.out.println("this is printDeque");
    }
}
