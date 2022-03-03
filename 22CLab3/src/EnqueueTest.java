
/**
* EnqueueTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class EnqueueTest {

	@Test
	public void test() {
		Queue<Integer> Q = new Queue<>();
		Integer integer = Integer.valueOf(1);
		Q.enqueue(1);
		assertEquals(1, Q.getLength());
		assertEquals(integer, Q.getFront());
		Q.enqueue(2);
		assertEquals(2, Q.getLength());
		assertEquals(integer, Q.getFront());
		Q.enqueue(3);
		assertEquals(3, Q.getLength());
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		integer++;
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		integer++;
		assertEquals(integer, Q.getFront());
		
	}

}
