
/**
* PeekTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.Test;

public class PeekTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> S.peek());
		assertEquals("peek(): Stack is empty. No data to access.", e.getMessage());
		S.push(1);
		Integer integer = Integer.valueOf(1);
		assertEquals(integer, S.peek());
		S.push(2);
		integer++;
		assertEquals(integer, S.peek());
		S.push(3);
		integer++;
		assertEquals(integer, S.peek());
	}

}
