
/**
* RemoveFirstTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveFirstTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(2);

		L.addFirst(1);
		L.addFirst(2);
		L.addFirst(3);
		L.removeFirst();
		assertEquals(2, L.getLength());
		assertEquals(integer, L.getFirst());
		L.removeFirst();
		integer = 1;
		assertEquals(1, L.getLength());
		assertEquals(integer, L.getFirst());
		L.removeFirst();
		assertEquals(true, L.isEmpty());
	}

}