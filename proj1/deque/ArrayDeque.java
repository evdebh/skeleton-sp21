package deque;

public class ArrayDeque<T> {
    T[] items;
    int nextFirst;
    int nextLast;
    int size;


    //constructor no-argument
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
        size = 0;
    }
    //constructor one-argument


    //if last is eged of last, then put element in the begin(if there is empty)
    public void addLast(T x) {
        if(size == items.length) {
            resize(size * 2);
            nextLast = size;
        }
        items[nextLast] = x;
        nextLast = Math.floorMod((nextLast + 1), items.length);
        size++;
    }

    //put the element in the point(nextfirst), and if the first is 0, put the elment into last(if there is empty)
    public void addFirst(T x) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = Math.floorMod((nextFirst - 1), items.length);
        size++;
    }
    public T get(int index) {
        if(index < 0 || index >= items.length) {
            return null;
        }
        return items[index];
    }
    public void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int start;
        if(capacity < items.length) {
            if(items[nextFirst] != null) {
                start = nextFirst;
            }else {
                start = nextFirst + 1;
            }
            System.arraycopy(items, start, newItems, 0, size);
            nextFirst = 0;
            nextLast = size;
        }else {
            System.arraycopy(items, 0, newItems, 0, size);
        }
        items = newItems;
    }

    public void reSimallSize() {
        double util = ((double) size / items.length);
        if(isEmpty()) {
            resize(8);
        }else if(items.length >= 16) {
            double goal = 0.26;
            if(util <= 0.25) {
                resize((int) (size/ goal));
            }
        }else {
            double goal = 0.06;
            if(util <= goal) {
                resize((int) (size/ goal));
            }
        }
    }
    public T removeFirst() {
        // int ItemLge = items.length;
        // int first;
        if(isEmpty()) {
            return null;
        }
        // if(nextFirst == ItemLge - 1 || (nextFirst == 0 && (items[nextFirst] != null))) {
        //     first = 0;
        // }else {
        //     first = nextFirst + 1;
        // }
        T value = get(nextFirst);
        items[nextFirst] = null;
//        nextFirst = Math.floorMod((nextFirst - 1), items.length);
        nextFirst = (nextFirst + 1) % items.length;
        size--;
        reSimallSize();
        return value;
    }

    public T removeLast() {
        int last;
        if(isEmpty()) {
            return null;
        }

        if(nextLast != 0) {
            last = nextLast - 1;
        }else {
            last = items.length - 1;
        }
        T value = get(last);
        items[last] = null;
        nextLast = last;
        size--;
        reSimallSize();
        return value;
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
        int index = 0;
        while(index < items.length) {
            System.out.print(items[index]);
            System.out.print("->");
            index++;
        }
    }

}