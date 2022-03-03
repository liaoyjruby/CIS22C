
/**
* DequeueTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DequeueTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<>();
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.dequeue();
		assertEquals(2, Q.getSize());
		Integer integer = Integer.valueOf(2);
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		assertEquals(1, Q.getSize());
		integer++;
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		assertEquals(0, Q.getSize());
		assertEquals(true, Q.isEmpty());
		Exception e = assertThrows(NoSuchElementException.class, () -> Q.dequeue());
		assertEquals("dequeue: Cannot dequeue from empty queue!", e.getMessage());
	}

}
