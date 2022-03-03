
/**
* RemoveIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class RemoveIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.addLast(4);
		L.addLast(5);

		// When iterator = null
		Exception e = assertThrows(NullPointerException.class, () -> L.removeIterator());
		assertEquals("removeIterator: Can't remove. Iterator is off the end", e.getMessage());

		// When iterator = first
		L.placeIterator();
		L.removeIterator();
		assertEquals(true, L.offEnd());
		assertEquals(4, L.getLength());
		Integer integer = new Integer(2);
		assertEquals(integer, L.getFirst());

		// When iterator = last
		L.placeIterator();
		L.advanceIterator();
		L.advanceIterator();
		L.advanceIterator();
		L.removeIterator();
		assertEquals(true, L.offEnd());
		assertEquals(3, L.getLength());
		integer = 4;
		assertEquals(integer, L.getLast());

		// General case
		L.placeIterator();
		L.advanceIterator();
		L.removeIterator();
		assertEquals(true, L.offEnd());
		assertEquals(2, L.getLength());
		integer = 4;
		assertEquals(integer, L.getLast());
		integer = 2;
		assertEquals(integer, L.getFirst());
	}

}
