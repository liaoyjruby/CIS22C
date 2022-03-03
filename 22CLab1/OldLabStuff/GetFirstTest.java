
/**
* GetFirstTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetFirstTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		Integer integer = new Integer(1);

		L.addFirst(1);
		assertEquals(integer, L.getFirst());
		L.addFirst(3);
		integer = 3;
		assertEquals(integer, L.getFirst());
		L.addFirst(2);
		integer = 2;
		assertEquals(integer, L.getFirst());

	}

}
