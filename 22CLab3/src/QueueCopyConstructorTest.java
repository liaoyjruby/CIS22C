
/**
* QueueCopyConstructorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class QueueCopyConstructorTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<Integer>();
		Queue<Integer> Q2 = new Queue<Integer>(Q);
		// When Q.length = 0
		assertEquals(true, Q.equals(Q2));
		assertEquals(Q.isEmpty(), Q2.isEmpty());
		assertEquals(Q.getLength(), Q2.getLength());
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
		assertEquals(Q.getLength(), Q3.getLength());
		assertEquals(Q.getFront(), Q3.getFront());
	}

}
