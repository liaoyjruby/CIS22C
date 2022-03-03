
/**
* EqualsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EqualsTest {

	@Test
	void test() {
		// Test with integers
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
		assertEquals(2, Q.getSize());
		Integer integer = Integer.valueOf(0);
		assertEquals(integer, Q.getFront());
		assertEquals(2, Q2.getSize());
		assertEquals(integer, Q2.getFront());
		
		// Test with strings
		Queue<String> Q3 = new Queue<>();
		Queue<String> Q4 = new Queue<>();
		Q3.enqueue("test");
		assertEquals(false, Q3.equals(Q4));
		
		Q3.enqueue("test2");
		Q4.enqueue("test");
		Q4.enqueue("test5");
		assertEquals(false, Q3.equals(Q4));
		
		Q4.dequeue();
		Q4.dequeue();
		Q4.enqueue("test");
		Q4.enqueue("test2");
		assertEquals(true, Q3.equals(Q4));
	}

}
