
/**
* SearchTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 7
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void test() {
		Hash<Integer> ht = new Hash<>(2);
		assertEquals(-1, ht.search(null));
		ht.insert(1);
		ht.insert(2);
		ht.insert(3);
		ht.insert(4);
		ht.insert(5);
		assertEquals(-1, ht.search(0));
		assertEquals(1, ht.search(1));
		assertEquals(0, ht.search(2));
		assertEquals(1, ht.search(3));
		ht.remove(1);
		assertEquals(-1, ht.search(1));

		Hash<String> ht2 = new Hash<>(2);
		assertEquals(-1, ht.search(null));
		ht2.insert("A");
		ht2.insert("B");
		ht2.insert("C");
		ht2.insert("D");
		ht2.insert("E");
		assertEquals(-1, ht2.search("F"));
		assertEquals(1, ht2.search("A"));
		assertEquals(0, ht2.search("B"));
		assertEquals(1, ht2.search("C"));
		ht2.remove("A");
		assertEquals(-1, ht2.search("A"));
		
	}

}
