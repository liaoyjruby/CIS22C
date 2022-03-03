
/**
* PushTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class PushTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		Integer integer = Integer.valueOf(1);
		S.push(1);
		assertEquals(1, S.getLength());
		assertEquals(integer, S.peek());
		S.push(2);
		assertEquals(2, S.getLength());
		integer++;
		assertEquals(integer, S.peek());
		S.push(3);
		assertEquals(3, S.getLength());
		integer++;
		assertEquals(integer, S.peek());
	}
}
