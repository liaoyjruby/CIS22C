
/**
* GetIndexTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 4
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class GetIndexTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Exception e = assertThrows(NullPointerException.class, () -> L.getIndex());
		assertEquals("getIndex: Cannot access. Iterator is null.", e.getMessage());
		L.addLast(1);
		L.addLast(1);
		L.addLast(1);
		L.addLast(1);
		L.addLast(1);
		L.placeIterator();
		L.advanceIterator();
		L.advanceIterator();
		assertEquals(3, L.getIndex());
		L.advanceIterator();
		L.advanceIterator();
		assertEquals(5, L.getIndex());
		L.advanceToIndex(1);
		assertEquals(1, L.getIndex());
	}
}
