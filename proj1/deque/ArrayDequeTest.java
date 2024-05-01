package deque;


import org.apache.hc.core5.annotation.Internal;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class ArrayDequeTest {

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void EmptyaddFirstTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<>();

        assertTrue("a newly arraydeque should be empty", lld1.isEmpty());

        lld1.addFirst("zero");
        assertEquals(1, lld1.size());
        assertFalse("now has 1 item", lld1.isEmpty());


        lld1.addFirst("seven");
        assertEquals(2, lld1.size());
        lld1.addFirst("six");

        lld1.addLast("one");
        lld1.addLast("two");


        //above last should in the last position
        String result = lld1.get(7);
        assertEquals(result, "seven");
        assertEquals(5, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<>();

        lld1.addFirst("zero");
        assertFalse("now has 1 item", lld1.isEmpty());

//        lld1.addFirst("seven");
        lld1.removeFirst();

        assertEquals(0, lld1.size());
        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<>();
        ArrayDeque<Double> lld2 = new ArrayDeque<>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<>();
        ArrayDeque<Integer> lld4 = new ArrayDeque<>();


        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);
        lld4.addFirst(5);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
        Integer i = lld4.removeFirst();

        System.out.println(s);
        System.out.println(d);
        System.out.println(b);
        System.out.println(i);

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    public void smallLLDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 50; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 25; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 49; i > 25; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void bigLLDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            int result = lld1.removeLast();
            if (result != i) {
                System.out.print("i is: " + i);
                System.out.println("result is: " + result);
            }
//            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void fillEmptyfill() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            lld1.addFirst(i);
        }
        //empty
        for (int i = 0; i < 8; i++) {
//            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
            int c = lld1.removeFirst();
            System.out.println(c);
        }
        //again
        for (int i = 0; i < 8; i++) {
            lld1.addFirst(i);
        }

    }

    @Test
    public void multiplarray() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            lld1.addLast(i);
        }
        //new one
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();

        //empty
        for (double i = 0; i < 8; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        //fillagin
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 10; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }
    }

    @Test
    public void getSecondFirst() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
        for (int i = 0; i < lld1.size(); i++) {
            int second;
            int first = lld1.removeFirst();
            if (i == 9) {
                second = lld1.get(0);
            } else {
                second = lld1.get(i + 1);
            }
            int mix = first + second;
            lld1.addLast(mix);
            System.out.println(second);
        }


    }

    @Test
    public void removefirsttolastnoresize() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            lld1.addLast(i);
        }
        for (int i = 0; i < 3; i++) {
            int value = lld1.removeFirst();
            lld1.addLast(value);
        }

    }

    @Test
    public void removefirsttolastresize() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            int value = lld1.removeFirst();
            lld1.addLast(value);
        }

    }

    @Test
    public void arraydequeiterator() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        ArrayDeque<Integer> lld3 = new ArrayDeque<>();
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld3.addLast(1);
        lld3.addLast(2);
        lld3.addLast(3);

        for (Integer i : lld1) {
            lld2.addLast(i);
        }
        assertTrue(lld3.equals(lld2));
    }

    @Test
    public void toListtest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);

        ArrayList first = new ArrayList<>();
        first.add(lld1.removeFirst());
        first.add(lld1.removeFirst());
        first.add(lld1.removeFirst());

        ArrayList other = new ArrayList<>();
        other.addLast(3);
        other.addLast(2);
        other.addLast(1);

        assertTrue(other.equals(first));
    }

    @Test
    public void testGetRecursive() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            lld1.addLast(i);
        }

        int result = lld1.getRecursive(5);
        assertEquals(result, 5);
    }

    @Test
    public void andininstanceDeque() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        lld2.addLast(1);
        lld2.addLast(2);
        lld2.addLast(3);

        assertTrue(lld1.equals(lld2));

    }

    @Test
    public void random() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(0);
        int result = lld1.removeLast();

       assertEquals(result, 0);


    }

    @Test
    public void fillremovefirstaddlast() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            lld1.addLast(i);
        }
        int first = lld1.removeFirst();
        lld1.addLast(8);
        int resutl = lld1.get(0);
        assertEquals(8, resutl);
    }

    @Test
    public void bigfillremovefirstaddlast() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
//        int first = lld1.removeFirst();
        lld1.addLast(10);
        int resutl = lld1.get(0);

    }


}

