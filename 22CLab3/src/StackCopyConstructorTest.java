
/**
* StackCopyConstructorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class StackCopyConstructorTest {

	@Test
	void test() {
		Stack<Integer> S = new Stack<Integer>();
		Stack<Integer> S2 = new Stack<Integer>(S);
		// When S.length = 0
		assertEquals(true, S.equals(S2));
		assertEquals(S.isEmpty(), S2.isEmpty());
		assertEquals(S.getLength(), S2.getLength());
		Exception e = assertThrows(NoSuchElementException.class, () -> S.pop());
		Exception e2 = assertThrows(NoSuchElementException.class, () -> S2.pop());
		assertEquals(e.getMessage(), e2.getMessage());
		e = assertThrows(NoSuchElementException.class, () -> S.peek());
		e2 = assertThrows(NoSuchElementException.class, () -> S2.peek());
		assertEquals(e.getMessage(), e2.getMessage());
		// General case
		S.push(0);
		S.push(1);
		S.push(2);
		Stack<Integer> S3 = new Stack<Integer>(S);
		assertEquals(true, S.equals(S3));
		assertEquals(S.isEmpty(), S3.isEmpty());
		assertEquals(S.getLength(), S3.getLength());
		assertEquals(S.peek(), S3.peek());
	}

}
