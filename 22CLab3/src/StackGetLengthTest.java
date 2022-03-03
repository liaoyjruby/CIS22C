
/**
* StackGetLengthTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class StackGetLengthTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		assertEquals(0, S.getLength());
		S.push(3);
		assertEquals(1, S.getLength());
		S.push(2);
		assertEquals(2, S.getLength());
	}

}
