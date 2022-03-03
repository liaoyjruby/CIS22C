
/**
* GetFrontTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 5
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class GetFrontTest {

	@Test
	void test() {
		Queue<Integer> Q = new Queue<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> Q.getFront());
		assertEquals("getFront: Cannot get front of empty queue!", e.getMessage());
		Q.enqueue(1);
		Integer integer = Integer.valueOf(1);
		assertEquals(integer, Q.getFront());
		Q.enqueue(2);
		assertEquals(integer, Q.getFront());
		Q.dequeue();
		integer++;
		assertEquals(integer, Q.getFront());
	}

}
