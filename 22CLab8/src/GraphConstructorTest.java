
/**
* GraphConstructorTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphConstructorTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		assertEquals(G.getNumVertices(), 0);
		assertEquals(G.getNumEdges(), 0);

		Graph G2 = new Graph(5);
		assertEquals(G2.getNumVertices(), 5);
		assertEquals(G2.getNumEdges(), 0);
		assertEquals(G2.getAdjacencyList(1).getLength(), 0);
		assertEquals(G2.getAdjacencyList(1).getLength(), G2.getAdjacencyList(5).getLength());
		assertEquals(G2.getColor(3), 'W');
		assertEquals(G2.getColor(3), G2.getColor(1));
		assertEquals(G2.getDistance(1), -1);
		assertEquals(G2.getDistance(1), G2.getDistance(2));
		assertEquals(G2.getParent(4), 0);
		assertEquals(G2.getParent(4), G2.getParent(5));

	}

}
