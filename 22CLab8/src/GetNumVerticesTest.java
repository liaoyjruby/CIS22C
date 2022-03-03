
/**
* GetNumVerticesTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GetNumVerticesTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		assertEquals(G.getNumVertices(), 0);

		Graph G2 = new Graph(5);
		assertEquals(G2.getNumVertices(), 5);
		G2.addUndirectedEdge(1, 2);
		assertEquals(G2.getNumVertices(), 5);

		Graph G3 = new Graph(10);
		assertEquals(G3.getNumVertices(), 10);

	}

}
