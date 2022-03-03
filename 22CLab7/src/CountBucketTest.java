
/**
* CountBucketTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 7
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CountBucketTest {

	@Test
	void test() {
		Hash<Integer> ht = new Hash<>(1);
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> ht.countBucket(1));
		assertEquals("countBucket(): Cannot access index of Table. Out of bounds.", e.getMessage());
		e = assertThrows(IndexOutOfBoundsException.class, () -> ht.countBucket(-1));
		assertEquals("countBucket(): Cannot access index of Table. Out of bounds.", e.getMessage());

		assertEquals(0, ht.countBucket(0));
		ht.insert(0);
		assertEquals(1, ht.countBucket(0));
		Hash<Integer> ht2 = new Hash<>(5);
		ht2.insert(0);
		ht2.insert(1);
		ht2.insert(2);
		ht2.insert(3);
		ht2.insert(4);
		ht2.insert(5);
		ht2.insert(6);
		ht2.insert(7);
		ht2.insert(8);
		ht2.insert(9);
		assertEquals(2, ht2.countBucket(2));
		assertEquals(2, ht2.countBucket(3));
		assertEquals(2, ht2.countBucket(4));

	}
}
