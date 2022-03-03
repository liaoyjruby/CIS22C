
/**
* ReverseIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ReverseIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Exception e = assertThrows(NullPointerException.class, () -> L.reverseIterator());
		assertEquals("reverseIterator: Can't reverse. Iterator is off the end.", e.getMessage());
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.placeIterator();
		L.advanceIterator();
		L.advanceIterator();
		Integer integer = new Integer(3);
		assertEquals(integer, L.getIterator());
		L.reverseIterator();
		integer = 2;
		assertEquals(integer, L.getIterator());
		L.reverseIterator();
		integer = 1;
		assertEquals(integer, L.getIterator());
		assertEquals(integer, L.getFirst());
		L.reverseIterator();
		e = assertThrows(NullPointerException.class, () -> L.getIterator());
		assertEquals("getIterator: Iterator is pointing to null.", e.getMessage());
	}

}
