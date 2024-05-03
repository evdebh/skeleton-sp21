package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int first;
    private int last;


    //constructor no-argument
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
        size = 0;
        first = 0;
        last = 0;
    }
    //constructor one-argument


    //if last is eged of last, then put element in the begin(if there is empty)
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
            nextLast = size;
        }
        items[nextLast] = x;
        last = nextLast;
        nextLast = Math.floorMod((nextLast + 1), items.length);
        size++;

    }

    //put the element in the point(nextfirst), and if the first is 0,
    // put the elment into last(if there is empty)
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        first = nextFirst;
        nextFirst = Math.floorMod((nextFirst - 1), items.length);
        nextLast = Math.floorMod((last + 1), items.length);
        size++;
    }
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        if (index == 0) {
            return items[first];
        } else {
            return items[index];
        }
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


    public void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int start;
        int oldSize = size;
        if (capacity < items.length) {
            if (items[nextFirst] != null) {
                start = nextFirst;
            } else {
                start = nextFirst + 1;
            }
            System.arraycopy(items, start, newItems, 0, size);
            nextFirst = 0;
            nextLast = size;
        } else {
            for(int i = 0; i < oldSize; i++) {
                newItems[i] = items[first];
                first = (first + 1) % items.length;
            }
            items = newItems;
            first = 0;
            last = oldSize - 1;
            nextFirst = Math.floorMod((first - 1), items.length);
            nextLast = oldSize;
        }
    }

    public void reSimallSize() {
        double util = ((double) size / items.length);
        if (isEmpty()) {
            resize(8);
        } else if(items.length >= 16) {
            double goal = 0.26;
            if (util <= 0.25) {
                resize((int) (size / goal));
            }
        } else {
            double goal = 0.06;
            if (util <= goal) {
                resize((int) (size / goal));
            }
        }
    }
    public T removeFirst() {
        T value;
        if (isEmpty()) {
            return null;
        }
        if (items[first] == null) {
            return null;
        }
        value = items[first];
        items[first] = null;
        nextFirst = first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = first + 1;
        }
        size--;
        reSimallSize();
        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T value = items[last];
        items[last] = null;
        nextLast = last;
        last = Math.floorMod((last - 1), items.length);
        size--;
        reSimallSize();
        return value;
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
        int index = 0;
        while (index < items.length) {
            System.out.print(items[index]);
            System.out.print("->");
            index++;
        }
    }

    public ArrayList toList() {
        ArrayList result = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            result.add(this.get(i));
        }

        return result;
    }

    public Iterator<T> iterator() {
        return new ADIterator();
    }

    private class ADIterator implements Iterator<T> {
        private int currentIndex;
        ADIterator() {
            currentIndex = 0;
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
            return item;

        }

    }

    @Override
    public boolean equals(Deque obj) {
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
