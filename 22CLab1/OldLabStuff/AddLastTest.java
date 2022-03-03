
/**
* AddLastTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddLastTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(2);

		L.addLast(1);
		assertEquals(1, L.getLength());
		L.addLast(2);
		assertEquals(integer, L.getLast());
		L.addLast(3);
		integer++;
		assertEquals(integer, L.getLast());
		L.placeIterator();
		L.advanceIterator();
		L.advanceIterator();
		L.addLast(4);
		L.advanceIterator();
		L.reverseIterator();
		assertEquals(integer, L.getIterator());
	}

}