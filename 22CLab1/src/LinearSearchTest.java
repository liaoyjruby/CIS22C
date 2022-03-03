
/**
* LinearSearchTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 4
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinearSearchTest {

	@Test
	void test() {
		List<Integer> L = new List<>();
		assertEquals(-1, L.linearSearch(0));
		L.addLast(0);
		assertEquals(1, L.linearSearch(0));
		assertEquals(-1, L.linearSearch(1));
		L.addLast(9);
		L.addLast(1);
		L.addLast(13);
		L.addLast(3);
		assertEquals(4, L.linearSearch(13));
		assertEquals(-1, L.linearSearch(2));
	}

}
