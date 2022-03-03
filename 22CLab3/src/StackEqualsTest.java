
/**
* StackEqualsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StackEqualsTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		Stack<Integer> S2 = S;
		Object o = new Object();
		assertEquals(true, S.equals(S));
		assertEquals(true, S.equals(S2));
		assertEquals(false, S.equals(o));
		S2 = new Stack<>();
		S.push(0);
		assertEquals(false, S.equals(S2));
		S.push(1);
		S2.push(0);
		S2.push(2);
		assertEquals(false, S.equals(S2));
		S2.pop();
		S2.push(1);
		assertEquals(true, S.equals(S2));
	}

}
