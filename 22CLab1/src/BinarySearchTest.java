
/**
* AdvanceToIndexTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 4
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		List<Integer> L = new List<>();
		assertEquals(-1, L.binarySearch(0));
		L.addLast(5);
		assertEquals(-1, L.binarySearch(3));
		assertEquals(1, L.binarySearch(5));
		L.addLast(2);
		Exception e = assertThrows(IllegalStateException.class, () -> L.binarySearch(10));
		assertEquals("binarySearch: Cannot do binary search. List is unsorted.", e.getMessage());
		assertThrows(IllegalStateException.class, () -> L.binarySearch(5));
		L.addLast(8);
		assertThrows(IllegalStateException.class, () -> L.binarySearch(10));
		assertThrows(IllegalStateException.class, () -> L.binarySearch(5));
		
		
		List<Integer> L2 = new List<>();
		L2.addLast(0);
		assertEquals(1, L2.binarySearch(0));
		assertEquals(-1, L2.binarySearch(1));
		L2.addLast(1);
		assertEquals(2, L2.binarySearch(1));
		L2.addLast(2);
		L2.addLast(5);
		L2.addLast(7);
		L2.addLast(10);
		assertEquals(4, L2.binarySearch(5));
		assertEquals(-1, L2.binarySearch(9));
		assertEquals(6, L2.binarySearch(10));
		
		List<String> L3 = new List<>();
		L3.addLast("test");
		assertEquals(1, L3.binarySearch("test"));
		assertEquals(-1, L3.binarySearch("test2"));
		L3.addLast("test2");
		assertEquals(2, L3.binarySearch("test2"));
		L3.addLast("test3");
		L3.addLast("test4");
		L3.addLast("test5");
		L3.addLast("test6");
		assertEquals(4, L3.binarySearch("test4"));
		assertEquals(-1, L3.binarySearch("test10"));
		assertEquals(6, L3.binarySearch("test6"));
	}

}
