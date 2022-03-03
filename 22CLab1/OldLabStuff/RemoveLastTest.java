
/**
* RemoveLastTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveLastTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(2);

		L.addLast(1);
		L.addLast(2);
		L.addLast(3);
		L.removeLast();
		assertEquals(2, L.getLength());
		assertEquals(integer, L.getLast());
		L.removeLast();
		integer = 1;
		assertEquals(1, L.getLength());
		assertEquals(integer, L.getLast());
		L.removeLast();
		assertEquals(true, L.isEmpty());
	}

}