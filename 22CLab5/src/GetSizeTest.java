
/**
* GetSizeTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GetSizeTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<>();
		assertEquals(0, Q.getSize());
		Q.enqueue(3);
		assertEquals(1, Q.getSize());
		Q.enqueue(2);
		assertEquals(2, Q.getSize());
		Q.dequeue();
		assertEquals(1, Q.getSize());
		Q.dequeue();
		assertEquals(0, Q.getSize());
	}

}
