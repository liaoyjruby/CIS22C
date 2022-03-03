
/**
* PlaceIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PlaceIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		// When List is empty
		L.placeIterator();
		Exception e = assertThrows(NullPointerException.class, () -> L.getIterator());
		assertEquals("getIterator: Iterator is pointing to null.", e.getMessage());
		assertEquals(true, L.offEnd());
		// When List has 1 Node
		L.addLast(0);
		L.placeIterator();
		assertEquals(false, L.offEnd());
		Integer integer = new Integer(0);
		assertEquals(integer, L.getIterator());
		// When List has 1+ Nodes
		L.addLast(1);
		L.placeIterator();
		assertEquals(false, L.offEnd());
		assertEquals(integer, L.getIterator());
		L.addFirst(2);
		L.placeIterator();
		integer = 2;
		assertEquals(integer, L.getIterator());

	}

}
