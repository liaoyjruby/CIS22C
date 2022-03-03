
/**
* GetFrontTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.Test;

public class GetFrontTest {

	@Test
	public void test() {
		Queue<Integer> Q = new Queue<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> Q.getFront());
		assertEquals("getFront(): Queue is empty. No data to access.", e.getMessage());
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
