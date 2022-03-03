
/**
* GetRootTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class GetRootTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> B.getRoot());
		assertEquals("getRoot(): Cannot access root. Tree is empty.", e.getMessage());
		B.insert(1);
		Integer integer = Integer.valueOf(1);
		assertEquals(integer, B.getRoot());
		B.insert(0);
		B.insert(2);
		B.insert(3);
		B.remove(1);
		integer = 2;
		assertEquals(integer, B.getRoot());
		B.remove(2);
		integer = 3;
		assertEquals(integer, B.getRoot());
	}

}
