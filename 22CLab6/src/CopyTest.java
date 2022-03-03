
/**
* CopyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class CopyTest {

	@Test
	void test() {
		BST<Integer> B = new BST<Integer>();
		BST<Integer> B2 = new BST<Integer>(B);
		// When length of Q is 0
		assertEquals(true, B.equals(B2));
		assertEquals(B.isEmpty(), B2.isEmpty());
		assertEquals(B.getSize(), B2.getSize());
		Exception e = assertThrows(NoSuchElementException.class, () -> B.getRoot());
		Exception e2 = assertThrows(NoSuchElementException.class, () -> B2.getRoot());
		assertEquals(e.getMessage(), e2.getMessage());
		// General case
		B.insert(3);
		assertEquals(false, B.equals(B2));
		B.insert(1);
		B.insert(2);
		B.insert(5);
		BST<Integer> B3 = new BST<Integer>(B);
		assertEquals(true, B.equals(B3));
		assertEquals(B.isEmpty(), B3.isEmpty());
		assertEquals(B.getSize(), B3.getSize());
		assertEquals(B.getRoot(), B3.getRoot());
		
		BST<String> B4 = new BST<String>();
		BST<String> B5 = new BST<String>(B4);
		assertEquals(true, B4.equals(B5));
		assertEquals(B4.isEmpty(), B5.isEmpty());
		assertEquals(B4.getSize(), B5.getSize());
		Exception e3 = assertThrows(NoSuchElementException.class, () -> B4.getRoot());
		Exception e4 = assertThrows(NoSuchElementException.class, () -> B5.getRoot());
		assertEquals(e3.getMessage(), e4.getMessage());
		// General case
		B4.insert("C");
		assertEquals(false, B4.equals(B5));
		B4.insert("A");
		B4.insert("B");
		B4.insert("D");
		BST<String> B6 = new BST<String>(B4);
		assertEquals(true, B.equals(B3));
		assertEquals(B4.isEmpty(), B6.isEmpty());
		assertEquals(B4.getSize(), B6.getSize());
		assertEquals(B4.getRoot(), B6.getRoot());
		
	}

}
