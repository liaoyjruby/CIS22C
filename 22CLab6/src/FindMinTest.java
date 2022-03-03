
/**
* FindMinTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class FindMinTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> B.findMin());
		assertEquals("findMin(): Cannot find value. Tree is empty.", e.getMessage());
		B.insert(10);
		Integer integer = Integer.valueOf(10);
		assertEquals(integer, B.findMin());
		B.insert(5);
		B.insert(40);
		B.insert(15);
		B.insert(3);
		B.insert(6);
		B.insert(3);
		B.insert(9);
		integer = 3;
		assertEquals(integer, B.findMin());
		B.remove(3);
		assertEquals(integer, B.findMin());
		B.remove(3);
		integer = 5;
		assertEquals(integer, B.findMin());

	}

}
