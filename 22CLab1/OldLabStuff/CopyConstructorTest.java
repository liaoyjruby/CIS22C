
/**
* CopyConstructorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Test;

public class CopyConstructorTest {

	@Test
	public void test() {
		List<Integer> L = new List<Integer>();
		List<Integer> L2 = new List<Integer>(L);
		// When L.length = 0
		assertEquals(true, L.equals(L2));
		assertEquals(L.isEmpty(), L2.isEmpty());
		assertEquals(L.getLength(), L2.getLength());
		Exception e = assertThrows(NoSuchElementException.class, () -> L.getFirst());
		Exception e2 = assertThrows(NoSuchElementException.class, () -> L2.getFirst());
		assertEquals(e.getMessage(), e2.getMessage());
		e = assertThrows(NullPointerException.class, () -> L.getIterator());
		e2 = assertThrows(NullPointerException.class, () -> L2.getIterator());
		assertEquals(e.getMessage(), e2.getMessage());
		// General case
		L.addLast(0);
		L.addLast(1);
		L.addLast(2);
		List<Integer> L3 = new List<Integer>(L);
		assertEquals(true, L.equals(L3));
		assertEquals(L.isEmpty(), L3.isEmpty());
		assertEquals(L.getLength(), L3.getLength());
		assertEquals(L.getFirst(), L3.getFirst());
		assertEquals(L.getLast(), L3.getLast());
		e = assertThrows(NullPointerException.class, () -> L.getIterator());
		e2 = assertThrows(NullPointerException.class, () -> L3.getIterator());
		assertEquals(e.getMessage(), e2.getMessage());
	}
}
