
/**
* EqualsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EqualsTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		List<Integer> L2 = L;
		Object o = new Object();
		assertEquals(true, L.equals(L));
		assertEquals(true, L.equals(L2));
		assertEquals(false, L.equals(o));
		L2 = new List<>();
		L.addLast(0);
		assertEquals(false, L.equals(L2));
		L.addLast(1);
		L2.addLast(0);
		L2.addLast(2);
		assertEquals(false, L.equals(L2));
		L2.removeLast();
		L2.addLast(1);
		assertEquals(true, L.equals(L2));
	}

}
