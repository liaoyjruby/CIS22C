
/**
* GetSizeTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GetSizeTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		assertEquals(0, B.getSize());
		B.insert(3);
		assertEquals(1, B.getSize());
		B.insert(2);
		assertEquals(2, B.getSize());
		B.remove(3);
		assertEquals(1, B.getSize());
		B.remove(2);
		assertEquals(0, B.getSize());
	}

}
