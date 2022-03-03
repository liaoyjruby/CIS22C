
/**
* AdvanceToIndexTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 4
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InSortedOrderTest {

	@Test
	void test() {
		List<Integer> L = new List<>();
		assertEquals(true, L.inSortedOrder());
		L.addLast(2);
		assertEquals(true, L.inSortedOrder());
		L.addLast(0);
		assertEquals(false, L.inSortedOrder());
		L.removeLast();
		L.addLast(5);
		assertEquals(true, L.inSortedOrder());
		L.addLast(7);
		assertEquals(true, L.inSortedOrder());
		L.removeLast();
		L.addLast(3);
		assertEquals(false, L.inSortedOrder());
		L.removeLast();
		L.addLast(7);
		assertEquals(true, L.inSortedOrder());
		L.removeLast();
		L.removeLast();
		L.removeLast();
		L.addLast(0);
		L.addLast(0);
		L.addLast(0);
		assertEquals(true, L.inSortedOrder());
		L.addLast(-1);
		assertEquals(false, L.inSortedOrder());
	}

}
