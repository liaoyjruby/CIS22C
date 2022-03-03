
/**
* AddIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class AddIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();

		Exception e = assertThrows(NullPointerException.class, () -> L.addIterator(0));
		assertEquals("addIterator: Can't add. Iterator is off the end.", e.getMessage());

		L.addLast(1);
		L.placeIterator();
		L.addIterator(2);
		assertEquals(2, L.getLength());
		Integer integer = new Integer(2);
		assertEquals(integer, L.getLast());

		L.addIterator(3);
		assertEquals(3, L.getLength());
		integer = 1;
		assertEquals(integer, L.getIterator());
		L.advanceIterator();
		integer = 3;
		assertEquals(integer, L.getIterator());
	}

}
