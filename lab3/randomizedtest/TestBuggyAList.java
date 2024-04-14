package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        a.addLast(5);
        a.addLast(10);
        a.addLast(15);

        b.addLast(5);
        b.addLast(10);
        b.addLast(15);

        assertEquals(b.size(), a.size());

        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());

    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
//                assertEquals(L.size(), B.size());
            }else if (L.size() > 0 && operationNumber == 2) {
                int Llast = L.getLast();
                int Blast = B.getLast();
                System.out.println("getlast("+ Llast + ")");
                System.out.println("getlast("+ Blast + ")");
//                assertEquals(Llast,Blast);
                L.removeLast();
                B.removeLast();
            }else if (L.size() > 0 && operationNumber == 3) {
                int reLlast = L.removeLast();
                int reBlast = B.removeLast();
                System.out.println("removeLast(" + reLlast + ")");
//                assertEquals(reLlast, reBlast);
            }
        }
        assertEquals(L.size(), B.size());
        assertEquals(L.getLast(),B.getLast());
        System.out.println("error is above");
    }



}
