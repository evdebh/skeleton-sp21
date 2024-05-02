package deque;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxArrayDequeTest {
    @Test
    public void Random() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<>();
        for (int i = 0; i < 7; i++) {
            lld1.addFirst(i);
        }
        int result = lld1.removeLast();
        assertEquals(result, 0);
    }

    @Test
    public void random1() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            lld1.addFirst(i);

        }
    }
}
