
/**
* AdvanceToIndexTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 4
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdvanceToIndexTest {

	@Test
	void test() {
		List<Integer> L = new List<>();
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> L.advanceToIndex(0));
		assertEquals("advanceToIndex(): Cannot advance iterator. Index out of bounds.", e.getMessage());
		L.addLast(3);
		L.addLast(2);
		L.addLast(1);

		L.advanceToIndex(3);
		Integer integer = Integer.valueOf(3);
		assertEquals(integer, L.getIndex());
		integer = 1;
		assertEquals(integer, L.getIterator());
		L.advanceToIndex(1);
		integer = 3;
		assertEquals(integer, L.getIterator());
		integer = 1;
		assertEquals(integer, L.getIndex());
	}

}
