
/**
* EqualsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EqualsTest {

	@Test
	void test() {
		// Test with integers
		BST<Integer> B = new BST<>();
		BST<Integer> B2 = B;
		Object o = new Object();
		assertEquals(true, B.equals(B));
		assertEquals(true, B.equals(B2));
		assertEquals(false, B.equals(o));
		
		B2 = new BST<>();
		B.insert(0);
		assertEquals(false, B.equals(B2));
		
		B.insert(1);
		B2.insert(0);
		B2.insert(2);
		assertEquals(false, B.equals(B2));
		
		B2.remove(2);
		B2.insert(1);
		assertEquals(true, B.equals(B2));
		B.insert(-5);
		B2.insert(-5);
		B.insert(7);
		B2.insert(7);
		B.insert(-3);
		B2.insert(-3);
		B.insert(3);
		B2.insert(3);
		assertEquals(B2.getSize(), B.getSize());
		assertEquals(B2.getHeight(), B.getHeight());
		assertEquals(B2.getRoot(), B.getRoot());
		assertEquals(B2.findMax(), B.findMax());
		assertEquals(B2.findMin(), B.findMin());
		
		
		// Test with strings
		BST<String> B3 = new BST<>();
		BST<String> B4 = new BST<>();
		B3.insert("C");
		assertEquals(false, B3.equals(B4));
		
		B3.insert("A");
		B4.insert("C");
		B4.insert("D");
		assertEquals(false, B3.equals(B4));
		
		B4.remove("D");
		B4.insert("A");
		assertEquals(true, B3.equals(B4));
		
		B3.insert("F");
		B4.insert("F");
		B3.insert("B");
		B4.insert("B");
		B3.insert("E");
		B4.insert("E");
		B3.insert("D");
		B4.insert("D");
		assertEquals(B4.getSize(), B3.getSize());
		assertEquals(B4.getHeight(), B3.getHeight());
		assertEquals(B4.getRoot(), B3.getRoot());
		assertEquals(B4.findMax(), B3.findMax());
		assertEquals(B4.findMin(), B3.findMin());
			
	}

}
