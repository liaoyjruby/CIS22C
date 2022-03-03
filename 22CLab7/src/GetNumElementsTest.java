
/**
* GetNumElementsTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 7
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GetNumElementsTest {

	@Test
	void test() {
		Hash<String> ht = new Hash<>(10);
		assertEquals(0, ht.getNumElements());
		ht.insert(":^)");
		assertEquals(1, ht.getNumElements());
		ht.insert(":^(");
		assertEquals(2, ht.getNumElements());
		ht.remove(":^)");
		assertEquals(1, ht.getNumElements());
		ht.remove(":^(");
		assertEquals(0, ht.getNumElements());

	}

}
