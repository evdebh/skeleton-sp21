package deque;

import java.util.Iterator;

public interface Deque<T> extends Iterable{
     void addFirst(T item);
     void addLast(T item);
     boolean isEmpty();
     int size();
     void printDeque();
     T removeFirst();
     T removeLast();
     T get(int index);

     T getRecursive(int index);

     boolean equals(Object o);

     Iterator<T> iterator();
}

