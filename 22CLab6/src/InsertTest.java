
/**
* InsertTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertTest {

	@Test
	void test() {
		BST<String> B = new BST<String>();
		
		B.insert("D");
		assertEquals("D", B.getRoot());
		assertEquals(1, B.getSize());
		assertEquals(0, B.getHeight());
		assertEquals(true, B.search("D"));
		
		B.insert("B");
		assertEquals("D", B.getRoot());
		assertEquals(2, B.getSize());
		assertEquals(1, B.getHeight());
		assertEquals(true, B.search("B"));
		
		B.insert("F");
		assertEquals("D", B.getRoot());
		assertEquals(3, B.getSize());
		assertEquals(1, B.getHeight());
		assertEquals(true, B.search("F"));
		
		B.insert("A");
		B.insert("E");
		B.insert("C");
		assertEquals("D", B.getRoot());
		assertEquals(6, B.getSize());
		assertEquals(2, B.getHeight());
		assertEquals(true, B.search("E"));
		assertEquals(true, B.search("C"));
		assertEquals(true, B.search("A"));
		
		B.insert("H");
		B.insert("G");
		B.insert("I");
		B.insert("J");
		assertEquals(10, B.getSize());
		assertEquals(4, B.getHeight());
		
		assertEquals("A", B.findMin());
		assertEquals("J", B.findMax());
		
		B.insert("A");
		assertEquals(11, B.getSize());
		assertEquals(4, B.getHeight());
		assertEquals("A", B.findMin());
	}

}
