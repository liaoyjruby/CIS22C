
/**
* IsEmptyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		assertEquals(true, B.isEmpty());
		B.insert(8);
		assertEquals(false, B.isEmpty());
		B.insert(5);
		assertEquals(false, B.isEmpty());
		B.remove(8);
		assertEquals(false, B.isEmpty());
		B.remove(5);
		assertEquals(true, B.isEmpty());
	}

}
