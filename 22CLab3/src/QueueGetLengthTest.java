
/**
* QueueGetLengthTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueGetLengthTest {

	@Test
	public void test() {
		Queue<Integer> Q = new Queue<>();
		assertEquals(0, Q.getLength());
		Q.enqueue(3);
		assertEquals(1, Q.getLength());
		Q.enqueue(2);
		assertEquals(2, Q.getLength());
	}

}
