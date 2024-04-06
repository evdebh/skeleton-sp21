package deque;


import org.junit.Test;
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
            if(result != i) {
                System.out.print("i is: " + i);
                System.out.println("result is: " + result);
            }
//            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void fillEmptyfill() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
        //empty
        for (double i = 0; i < 10; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        //new one
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        //fillagin
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 10; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }
    }

    @Test
    public void multiplarray() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
        //new one
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();

        //empty
        for (double i = 0; i < 10; i++) {
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


}
