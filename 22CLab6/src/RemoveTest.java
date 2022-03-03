
/**
* RemoveTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 6
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveTest {

	@Test
	void test() {
		BST<String> B = new BST<String>();
		
		B.insert("D");
		B.insert("B");
		B.insert("F");
		B.insert("A");
		B.insert("E");
		B.insert("C");
		
		/*			 D
		 * 		B		   F
		 * 	A	   C	E
		 */
		
		
		B.remove("F");
		assertEquals(5, B.getSize());
		assertEquals(2, B.getHeight());
		assertEquals(false, B.search("F"));
		assertEquals("E", B.findMax());
		
		B.remove("A");
		assertEquals(4, B.getSize());
		assertEquals(2, B.getHeight());
		assertEquals(false, B.search("A"));
		assertEquals("B", B.findMin());
		
		B.remove("C");
		assertEquals(3, B.getSize());
		assertEquals(1, B.getHeight());
		assertEquals(false, B.search("C"));
		
		B.remove("E");
		B.insert("F");
		B.insert("E");
		B.insert("G");
		B.remove("D");
		assertEquals(4, B.getSize());
		assertEquals(2, B.getHeight());
		assertEquals(false, B.search("D"));
		assertEquals("E", B.getRoot());
		assertEquals("G", B.findMax());
		B.insert("G");
		B.remove("G");
		assertEquals("G", B.findMax());
		assertEquals(4, B.getSize());
		assertEquals(2, B.getHeight());
	}

}
