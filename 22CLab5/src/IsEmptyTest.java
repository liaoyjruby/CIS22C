
/**
* IsEmptyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<>();
		assertEquals(true, Q.isEmpty());
		Q.enqueue(8);
		assertEquals(false, Q.isEmpty());
		Q.enqueue(5);
		assertEquals(false, Q.isEmpty());
		Q.dequeue();
		assertEquals(false, Q.isEmpty());
		Q.dequeue();
		assertEquals(true, Q.isEmpty());
	}

}
