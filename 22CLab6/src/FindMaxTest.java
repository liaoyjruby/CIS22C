
/**
* FindMaxTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class FindMaxTest {

	@Test
	void test() {
		BST<Integer> B = new BST<>();
		Exception e = assertThrows(NoSuchElementException.class, () -> B.findMax());
		assertEquals("findMax(): Cannot find value. Tree is empty.", e.getMessage());
		B.insert(10);
		Integer integer = Integer.valueOf(10);
		assertEquals(integer, B.findMax());
		B.insert(5);
		B.insert(50);
		B.insert(15);
		B.insert(3);
		B.insert(6);
		B.insert(50);
		B.insert(9);
		integer = 50;
		assertEquals(integer, B.findMax());
		B.remove(50);
		assertEquals(integer, B.findMax());
		B.remove(50);
		integer = 15;
		assertEquals(integer, B.findMax());
	}

}
