
/**
* AppendTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppendTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<Integer>();
		Queue<Integer> Q2 = new Queue<Integer>();
		Queue<Integer> expectedQ = new Queue<Integer>();
		
		// When queue(s) are empty
		Q.append(Q2);
		assertEquals(true, Q.isEmpty());
		Q2.enqueue(1);
		Q.append(Q2);
		expectedQ.enqueue(1);
		assertEquals(true, Q.equals(expectedQ));
		assertEquals(1, Q.getSize());
		assertEquals(true, Q2.equals(expectedQ));
		
		// General case
		Q2.dequeue();
		Q2.enqueue(2);
		Q2.enqueue(3);
		Q.append(Q2);
		assertEquals(3, Q.getSize());
		assertEquals(2, Q2.getSize());
		expectedQ.enqueue(2);
		expectedQ.enqueue(3);
		assertEquals(true, Q.equals(expectedQ));
		expectedQ.dequeue();
		assertEquals(true, Q2.equals(expectedQ));
	}

}
