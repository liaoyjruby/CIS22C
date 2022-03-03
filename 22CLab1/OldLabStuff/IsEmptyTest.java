
/**
* IsEmptyTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		assertEquals(true, L.isEmpty());
		L.addFirst(8);
		assertEquals(false, L.isEmpty());
		L.addLast(5);
		assertEquals(false, L.isEmpty());
		L.removeFirst();
		L.removeFirst();
		assertEquals(true, L.isEmpty());
	}

}
