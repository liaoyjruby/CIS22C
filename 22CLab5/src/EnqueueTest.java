
/**
* EnqueueTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EnqueueTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<>();
		Integer integer = Integer.valueOf(1);
		Q.enqueue(1);
		assertEquals(1, Q.getSize());
		assertEquals(integer, Q.getFront());
		Q.enqueue(2);
		assertEquals(2, Q.getSize());
		assertEquals(integer, Q.getFront());
		Q.enqueue(3);
		assertEquals(3, Q.getSize());
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		integer++;
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		integer++;
		assertEquals(integer, Q.getFront());
	}

}
