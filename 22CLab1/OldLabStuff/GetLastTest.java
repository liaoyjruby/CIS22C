
/**
* GetLastTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetLastTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(1);

		L.addLast(1);
		assertEquals(integer, L.getLast());
		L.addLast(3);
		integer = 3;
		assertEquals(integer, L.getLast());
		L.addLast(2);
		integer = 2;
		assertEquals(integer, L.getLast());

	}

}
