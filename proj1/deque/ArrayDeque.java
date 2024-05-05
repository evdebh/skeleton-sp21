package deque;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;



    //constructor no-argument
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int ind;
        for (int i = 0; i < size; i++) {
            ind = arrayInd(i);
            newItems[capacity / 4 + i] = items[ind];
        }
        items = newItems;
        nextFirst = capacity / 4 - 1;
        nextLast = nextFirst + size + 1;
    }


    //if last is eged of last, then put element in the begin(if there is empty)
    public void addLast(T x) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextLast] = x;
        nextLast = Math.floorMod((nextLast + 1), items.length);
        size++;

    }

    //put the element in the point(nextfirst), and if the first is 0,
    // put the elment into last(if there is empty)
    public void addFirst(T x) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        nextFirst = Math.floorMod((nextFirst - 1), items.length);
        size++;
    }
    private int arrayInd(int ind) {
        if (nextFirst + 1 + ind >= items.length) {
            return nextFirst + 1 + ind - items.length;
        } else {
            return nextFirst + 1 + ind;
        }
    }
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        int ind = arrayInd(index);
        return items[ind];
    }

    private T getFrist() {
        int ind = arrayInd(0);
        return items[ind];
    }

    private T getLast() {
        int ind = arrayInd(size - 1);
        return items[ind];
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursionHelper(this, index, 0);
    }

    private T getRecursionHelper(ArrayDeque<T> arrd, int index, int curr) {
        if (curr == index) {
            return arrd.get(curr);
        }

        return getRecursionHelper(this, index, curr + 1);

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / 4 ) && (size > 8)) {
            resize(items.length / 2);
        }
        T value = getFrist();
        int ind = arrayInd(0);
        items[ind] = null;
        size--;
        nextFirst = ind;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / 4 ) && (size > 8)) {
            resize(items.length / 2);
        }
        T value = getLast();
        int ind = arrayInd(size - 1);
        items[ind] = null;
        size--;
        nextLast = ind;
        return value;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (T i : this) {
            System.out.println(i + " ");
        }
    }

    public Iterator<T> iterator() {
        return new ADIterator();
    }

    private class ADIterator implements Iterator<T> {
        private int currentIndex;
        private ADIterator() {
            currentIndex = 0;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = get(currentIndex);
            currentIndex++;
            return item;

        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Deque<?>)) {
            return false;
        }


        if (this.size() != ((ArrayDeque<?>) obj).size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(((ArrayDeque<?>) obj).get(i))) {
                return false;
            }
        }
        return true;
    }

}
