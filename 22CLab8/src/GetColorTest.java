
/**
* GetColorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetColorTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> G.getColor(0));
		assertEquals("getColor(): Cannot return value. Out of bounds.", e.getMessage());

		Graph G2 = new Graph(5);
		G2.addUndirectedEdge(1, 2);
		G2.addUndirectedEdge(1, 3);
		G2.addUndirectedEdge(1, 5);
		G2.addUndirectedEdge(3, 4);
		assertEquals(G2.getColor(1), 'W');
		assertEquals(G2.getColor(2), 'W');
		assertEquals(G2.getColor(3), 'W');
		assertEquals(G2.getColor(4), 'W');
		assertEquals(G2.getColor(5), 'W');
		G2.BFS(1);
		assertEquals(G2.getColor(1), 'B');
		assertEquals(G2.getColor(2), 'B');
		assertEquals(G2.getColor(3), 'B');
		assertEquals(G2.getColor(4), 'B');
		assertEquals(G2.getColor(5), 'B');
	}

}
