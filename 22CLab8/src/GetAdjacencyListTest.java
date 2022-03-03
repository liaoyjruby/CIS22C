
/**
* GetAdjacencyListTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetAdjacencyListTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> G.getAdjacencyList(0));
		assertEquals("getAdjacencyList(): Cannot return value. Out of bounds.", e.getMessage());
		
		Graph G2 = new Graph(5);
		assertEquals(G2.getAdjacencyList(1).getLength(), 0);
		G2.addUndirectedEdge(1, 2);
		G2.addUndirectedEdge(1, 3);
		G2.addUndirectedEdge(1, 5);
		assertEquals(G2.getAdjacencyList(1).getLength(), 3);
		assertEquals(G2.getAdjacencyList(2).getLength(), 1);
		
		G2.addUndirectedEdge(4, 4);
		G2.addUndirectedEdge(4, 4);
		assertEquals(G2.getAdjacencyList(4).getLength(), 1);
		
	}

}
