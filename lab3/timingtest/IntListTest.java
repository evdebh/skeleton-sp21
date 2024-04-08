package timingtest;

import static timingtest.IntList.partition;

public class IntListTest {
    public static void main(String[] args) {
        IntList lst = IntList.of(5,4,3,2,1);
        System.out.println("origin lst is: " + lst);

        IntList[] result = partition(lst, 2);

        System.out.println("List after partition: " + result[0]);

    }
}
