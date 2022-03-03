
/**
* StackIsEmptyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StackIsEmptyTest {

	@Test
	public void test() {
		Stack<Integer> S = new Stack<>();
		assertEquals(true, S.isEmpty());
		S.push(8);
		assertEquals(false, S.isEmpty());
		S.push(5);
		assertEquals(false, S.isEmpty());
		S.pop();
		S.pop();
		assertEquals(true, S.isEmpty());
	}

}
