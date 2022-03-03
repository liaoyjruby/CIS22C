
/**
* GetLengthTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 2
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetLengthTest {

	@Test
	public void test() {
		List<Integer> L = new List<>();
		assertEquals(0, L.getLength());
		L.addLast(3);
		assertEquals(1, L.getLength());
		L.addFirst(2);
		assertEquals(2, L.getLength());

	}

}
