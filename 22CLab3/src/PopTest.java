
/**
* PopTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.Test;

public class PopTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		S.push(1);
		S.push(2);
		S.push(3);
		S.pop();
		assertEquals(2, S.getLength());
		Integer integer = Integer.valueOf(2);
		assertEquals(integer, S.peek());
		S.pop();
		assertEquals(1, S.getLength());
		integer--;
		assertEquals(integer, S.peek());
		S.pop();
		assertEquals(0, S.getLength());
		assertEquals(true, S.isEmpty());
		Exception e = assertThrows(NoSuchElementException.class, () -> S.pop());
		assertEquals("pop(): Cannot remove from an empty Stack", e.getMessage());
	}

}
