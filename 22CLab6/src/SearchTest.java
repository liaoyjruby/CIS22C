
/**
* SearchTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void test() {
		BST<String> B = new BST<String>();
		assertEquals(false, B.search("A"));
		B.insert("C");
		assertEquals(true, B.search("C"));
		B.insert("F");
		B.insert("B");
		B.insert("D");
		B.insert("E");
		assertEquals(true, B.search("C"));
		assertEquals(true, B.search("B"));
		assertEquals(true, B.search("E"));
		assertEquals(true, B.search("D"));
		assertEquals(false, B.search("S"));
		assertEquals(false, B.search("A"));
		assertEquals(true, B.search("F"));
		B.remove("B");
		assertEquals(false, B.search("B"));
		B.remove("D");
		assertEquals(false, B.search("D"));
		assertEquals(true, B.search("E"));
		B.remove("C");
		B.remove("E");
		B.remove("F");
		assertEquals(false, B.search("C"));
	}

}
