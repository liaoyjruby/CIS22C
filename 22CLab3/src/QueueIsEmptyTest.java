
/**
* QueueIsEmptyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class QueueIsEmptyTest {

	@Test
	public void test() {
		Queue<Integer> Q = new Queue<>();
		assertEquals(true, Q.isEmpty());
		Q.enqueue(8);
		assertEquals(false, Q.isEmpty());
		Q.enqueue(5);
		assertEquals(false, Q.isEmpty());
		Q.dequeue();
		Q.dequeue();
		assertEquals(true, Q.isEmpty());
	}

}
