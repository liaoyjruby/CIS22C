
/**
* GetIteratorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class GetIteratorTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Exception e = assertThrows(NullPointerException.class, () -> L.getIterator());
		assertEquals("getIterator: Iterator is pointing to null.", e.getMessage());
		L.addLast(1);
		L.placeIterator();
		Integer integer = new Integer(1);
		assertEquals(integer, L.getIterator());
		L.addLast(2);
		L.advanceIterator();
		integer = 2;
		assertEquals(integer, L.getIterator());

	}

}
