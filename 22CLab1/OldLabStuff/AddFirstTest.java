
/**
* AddFirstTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddFirstTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(2);

		L.addFirst(1);
		assertEquals(1, L.getLength());
		L.addFirst(2);
		assertEquals(integer, L.getFirst());
		L.addFirst(3);
		integer++;
		assertEquals(integer, L.getFirst());
		L.placeIterator();
		L.addFirst(4);
		L.reverseIterator();
		L.advanceIterator();
		assertEquals(integer, L.getIterator());
	}

}