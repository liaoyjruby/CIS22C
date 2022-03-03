
/**
* QueueEqualsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueEqualsTest {

	@Test
	public void test() {
		Queue<Integer> Q = new Queue<>();
		Queue<Integer> Q2 = Q;
		Object o = new Object();
		assertEquals(true, Q.equals(Q));
		assertEquals(true, Q.equals(Q2));
		assertEquals(false, Q.equals(o));
		Q2 = new Queue<>();
		Q.enqueue(0);
		assertEquals(false, Q.equals(Q2));
		Q.enqueue(1);
		Q2.enqueue(0);
		Q2.enqueue(2);
		assertEquals(false, Q.equals(Q2));
		Q2.dequeue();
		Q2.dequeue();
		Q2.enqueue(0);
		Q2.enqueue(1);
		assertEquals(true, Q.equals(Q2));

	}

}
