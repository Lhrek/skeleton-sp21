package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove (){
        BuggyAList<Integer> l1 = new BuggyAList<Integer>();
        AListNoResizing<Integer> l2 = new AListNoResizing<Integer>();
        l1.addLast(4);
        l1.addLast(5);
        l1.addLast(6);
        l2.addLast(4);
        l2.addLast(5);
        l2.addLast(6);
        assertEquals(l1.size(),l2.size());
        assertEquals(l1.removeLast(),l2.removeLast());
        assertEquals(l1.removeLast(),l2.removeLast());
        assertEquals(l1.removeLast(),l2.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B   = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniformInt(0,4) ;
            if(L.size() == 0)
                operationNumber = StdRandom.uniform(0,2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
//                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
//                assertEquals(L.getLast(),B.getLast());
                int last1 = L.getLast();
                int last2 = B.getLast();
                assertEquals(last1,last2);
            } else if (operationNumber == 3) {
//                assertEquals(L.removeLast(),B.removeLast());
                int last1 = L.removeLast();
                int last2 = B.removeLast();
                assertEquals(last2,last1);
            }
        }
    }
}
