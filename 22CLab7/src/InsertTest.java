
/**
* InsertTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 7
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertTest {

	@Test
	void test() {
		Hash<Integer> ht = new Hash<>(3);
		
		ht.insert(0);
		assertEquals(1, ht.getNumElements());
		assertEquals(0, ht.search(0));
		
		ht.insert(3);
		assertEquals(2, ht.getNumElements());
		assertEquals(0, ht.search(3));
		
		ht.insert(1);
		assertEquals(3, ht.getNumElements());
		assertEquals(1, ht.search(1));
		
		ht.insert(2);
		assertEquals(4, ht.getNumElements());
		assertEquals(2, ht.search(2));
		
		ht.insert(6);
		ht.insert(7);
		ht.insert(8);
		assertEquals(7, ht.getNumElements());
		assertEquals(0, ht.search(6));
		assertEquals(1, ht.search(7));
		assertEquals(2, ht.search(8));
		assertEquals(0, ht.search(0));
		assertEquals(2, ht.search(2));
	}

}
