
/**
* AdvanceIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class AdvanceIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Exception e = assertThrows(NullPointerException.class, () -> L.advanceIterator());
		assertEquals("advanceIterator: Can't advance. Iterator is off the end.", e.getMessage());
		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.placeIterator();
		L.advanceIterator();
		Integer integer = new Integer(2);
		assertEquals(integer, L.getIterator());
		L.advanceIterator();
		integer = 3;
		assertEquals(integer, L.getIterator());
	}

}
