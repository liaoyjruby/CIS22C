
/**
 * GraphTest.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen 
 * CIS 22C, Lab 8
 */

public class GraphTest {

	public static void main(String[] args) {
		System.out.println("\n***Testing Directed Edge + Constructor + toString ***\n");
		Graph g = new Graph(5);
		System.out.println("Should print 5 vertices: " + g.getNumVertices());
		System.out.println("Should print 0 edges: " + g.getNumEdges());
		System.out.println("Should print -1 distance for 1: " + g.getDistance(1));
		System.out.println("Should print 0 parent for 1: " + g.getParent(1));
		System.out.println("Should print error message:");
		try {
			int i = g.getDistance(6);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print error message:");
		try {
			int i = g.getParent(6);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print error message:");
		try {
			int i = g.getColor(0);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print error message:");
		try {
			List<Integer> l = g.getAdjacencyList(0);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		g.addDirectedEdge(1, 1);
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(3, 4);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 1);

		System.out.println();
		System.out.println(g);

		System.out.println("Should print 6 edges: " + g.getNumEdges());
		System.out.println("Should print 'W' color: " + g.getColor(1));
		System.out.println("Should print 1 2 for vertex 1 adj: " + g.getAdjacencyList(1));

		System.out.println("\n***Testing Undirected Edge***\n");
		Graph g2 = new Graph(4);
		System.out.println("Should print 4 vertices: " + g2.getNumVertices());
		System.out.println("Should print 0 edges: " + g2.getNumEdges());
		g2.addUndirectedEdge(1, 1);
		g2.addUndirectedEdge(1, 1);
		g2.addUndirectedEdge(1, 1);
		g2.addUndirectedEdge(1, 2);
		g2.addUndirectedEdge(4, 2);
		g2.addUndirectedEdge(4, 2);
		g2.addUndirectedEdge(4, 2);

		System.out.println();
		System.out.println(g2);

		System.out.println("Should print 5 edges: " + g2.getNumEdges());
		System.out.println("Should print 'W' color: " + g2.getColor(1));
		System.out.println("Should print 1 2 for vertex 1 adj: " + g2.getAdjacencyList(1));
		System.out.println("Should print 2 2 2 for vertex 4 adj: " + g2.getAdjacencyList(4));

		System.out.println("\n***Testing printBFS***\n");
		g2.printBFS();

		System.out.println("\n***Testing BFS***\n");

		System.out.println("Graph 1 - 1 is source");
		g.BFS(1);
		g.printBFS();
		System.out.println("Should print 'B' color for 1: " + g.getColor(1));
		System.out.println("Should print 0 distance for 1: " + g.getDistance(1));
		System.out.println("Should print 4 distance for 5: " + g.getDistance(5));
		System.out.println("Should print 4 parent for 5: " + g.getParent(5));

		System.out.println();

		System.out.println("Graph 2 - 3 is source");
		g2.BFS(3);
		g2.printBFS();
		System.out.println("Should print 'B' color for 3: " + g2.getColor(3));
		System.out.println("Should print 'W' color for 4: " + g2.getColor(4));
		System.out.println("Should print 0 distance for 3: " + g2.getDistance(3));
		System.out.println("Should print -1 distance for 1: " + g2.getDistance(1));
		System.out.println("Should print 0 parent for 4: " + g2.getParent(4));

	}

}
