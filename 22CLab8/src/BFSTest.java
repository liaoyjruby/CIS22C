
/**
* BFSTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BFSTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		Exception e = assertThrows(IllegalStateException.class, () -> G.BFS(0));
		assertEquals("BFS(): Cannot search. Graph is empty.", e.getMessage());
		Graph G1 = new Graph(2);
		e = assertThrows(IndexOutOfBoundsException.class, () -> G1.BFS(0));
		assertEquals("BFS(): Cannot search. Out of bounds.", e.getMessage());
		e = assertThrows(IndexOutOfBoundsException.class, () -> G1.BFS(3));
		assertEquals("BFS(): Cannot search. Out of bounds.", e.getMessage());

		Graph G2 = new Graph(5);
		G2.addUndirectedEdge(1, 2);
		G2.addUndirectedEdge(1, 3);
		G2.addUndirectedEdge(1, 5);
		G2.addUndirectedEdge(3, 4);
		G2.BFS(1);
		
		assertEquals(G2.getDistance(1), 0);
		assertEquals(G2.getDistance(2), 1);
		assertEquals(G2.getDistance(3), 1);
		assertEquals(G2.getDistance(5), 1);
		assertEquals(G2.getDistance(4), 2);
		
		assertEquals(G2.getParent(1), 0);
		assertEquals(G2.getParent(2), 1);
		assertEquals(G2.getParent(3), 1);
		assertEquals(G2.getParent(5), 1);
		assertEquals(G2.getParent(4), 3);
		
		assertEquals(G2.getColor(1), 'B');
		assertEquals(G2.getColor(2), 'B');
		assertEquals(G2.getColor(3), 'B');
		assertEquals(G2.getColor(4), 'B');
		assertEquals(G2.getColor(5), 'B');
	}

}
