
/**
* CopyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class CopyTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<Integer>();
		Queue<Integer> Q2 = new Queue<Integer>(Q);
		// When length of Q is 0
		assertEquals(true, Q.equals(Q2));
		assertEquals(Q.isEmpty(), Q2.isEmpty());
		assertEquals(Q.getSize(), Q2.getSize());
		Exception e = assertThrows(NoSuchElementException.class, () -> Q.getFront());
		Exception e2 = assertThrows(NoSuchElementException.class, () -> Q2.getFront());
		assertEquals(e.getMessage(), e2.getMessage());
		// General case
		Q.enqueue(0);
		Q.enqueue(1);
		Q.enqueue(2);
		Queue<Integer> Q3 = new Queue<Integer>(Q);
		assertEquals(true, Q.equals(Q3));
		assertEquals(Q.isEmpty(), Q3.isEmpty());
		assertEquals(Q.getSize(), Q3.getSize());
		assertEquals(Q.getFront(), Q3.getFront());
	}

}
