
/**
* GetParentTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 8
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetParentTest {

	@Test
	void test() {
		Graph G = new Graph(0);
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> G.getParent(0));
		assertEquals("getParent(): Cannot return value. Out of bounds.", e.getMessage());

		Graph G2 = new Graph(5);
		G2.addUndirectedEdge(1, 2);
		G2.addUndirectedEdge(1, 3);
		G2.addUndirectedEdge(1, 5);
		G2.addUndirectedEdge(3, 4);
		G2.BFS(1);
		assertEquals(G2.getParent(1), 0);
		assertEquals(G2.getParent(2), 1);
		assertEquals(G2.getParent(4), 3);

	}

}
