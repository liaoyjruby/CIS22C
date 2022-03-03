
/**
* GetHeightTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetHeightTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		Integer integer = Integer.valueOf(-1);
		assertEquals(integer, B.getHeight());
		B.insert(5);
		integer++;
		assertEquals(integer, B.getHeight());
		B.insert(4);
		integer++;
		assertEquals(integer, B.getHeight());
		B.insert(6);
		assertEquals(integer, B.getHeight());
		B.insert(7);
		integer++;
		assertEquals(integer, B.getHeight());
		B.remove(5);
		integer--;
		assertEquals(integer, B.getHeight());


	}

}
