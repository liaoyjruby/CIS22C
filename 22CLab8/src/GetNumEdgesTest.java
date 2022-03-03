
/**
* GetNumEdgesTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GetNumEdgesTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		assertEquals(G.getNumEdges(), 0);

		Graph G2 = new Graph(5);
		assertEquals(G2.getNumEdges(), 0);
		G2.addUndirectedEdge(1, 2);
		assertEquals(G2.getNumEdges(), 1);
		G2.addDirectedEdge(1, 3);
		assertEquals(G2.getNumEdges(), 2);
		G2.addUndirectedEdge(1, 5);
		assertEquals(G2.getNumEdges(), 3);

		G2.addUndirectedEdge(4, 4);
		G2.addDirectedEdge(4, 4);
		G2.addUndirectedEdge(4, 4);
		assertEquals(G2.getNumEdges(), 4);
	}

}
