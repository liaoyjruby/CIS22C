
/**
* OffEndTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OffEndTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		assertEquals(true, L.offEnd());
		L.addLast(0);
		assertEquals(true, L.offEnd());
		L.placeIterator();
		assertEquals(false, L.offEnd());
	}

}
