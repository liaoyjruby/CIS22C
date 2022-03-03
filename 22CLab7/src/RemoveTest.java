
/**
* RemoveTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 7
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveTest {

	@Test
	void test() {
		Hash<Integer> ht = new Hash<>(2);
		ht.remove(3);
		assertEquals(0, ht.getNumElements());
		
		ht.insert(1);
		ht.insert(2);
		ht.insert(3);
		ht.insert(4);
		ht.insert(5);
		ht.remove(1);
		assertEquals(4, ht.getNumElements());
		assertEquals(-1, ht.search(1));
		assertEquals(2, ht.countBucket(1));
		assertEquals(2, ht.countBucket(0));
		
		ht.remove(5);
		assertEquals(3, ht.getNumElements());
		assertEquals(-1, ht.search(5));
		assertEquals(1, ht.countBucket(1));
		assertEquals(2, ht.countBucket(0));
		
		ht.remove(4);
		assertEquals(2, ht.getNumElements());
		assertEquals(-1, ht.search(4));
		assertEquals(1, ht.countBucket(1));
		assertEquals(1, ht.countBucket(0));
		
		ht.remove(2);
		ht.remove(3);
		ht.remove(10);
		assertEquals(0, ht.getNumElements());
		assertEquals(-1, ht.search(2));
		assertEquals(-1, ht.search(3));
		assertEquals(0, ht.countBucket(1));
		assertEquals(0, ht.countBucket(0));
	}

}
