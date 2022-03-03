
/**
 * Graph.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 * CIS 22C, Lab 8
 */

import java.util.ArrayList;

public class Graph {
	private int vertices;
	private int edges;
	private ArrayList<List<Integer>> adj;
	private ArrayList<Character> color;
	private ArrayList<Integer> distance;
	private ArrayList<Integer> parent;

	/** Constructor */

	/**
	 * initializes an empty graph, with n vertices and 0 edges, and initializes all
	 * arraylists to contain default values from indices 1 to n
	 * 
	 * @param n the number of vertices in the graph
	 */
	public Graph(int n) {
		vertices = n;
		edges = 0;
		adj = new ArrayList<List<Integer>>();
		color = new ArrayList<Character>();
		distance = new ArrayList<Integer>();
		parent = new ArrayList<Integer>();

		// Leave index 0 empty
		adj.add(null);
		color.add(null);
		distance.add(null);
		parent.add(null);
		for (int i = 1; i <= n; i++) {
			adj.add(new List<Integer>());
			color.add('W');
			distance.add(-1);
			parent.add(0);
		}

	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return vertices;
	}

	/**
	 * returns whether the graph is empty (no vertices)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return vertices == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getDistance(): Cannot return value. Out of bounds.");
		}
		return distance.get(v);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Integer getParent(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getParent(): Cannot return value. Out of bounds.");
		}
		return parent.get(v);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getColor(): Cannot return value. Out of bounds.");
		}
		return color.get(v);
	}

	/**
	 * Returns the List stored at index v
	 * 
	 * @param v a vertex in the graph
	 * @return the adjacency List a v
	 * @precondition 0 < v <= vertices
	 * @throws IndexOutOfBoundsException when the precondition is violated
	 */
	public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("getAdjacencyList(): Cannot return value. Out of bounds.");
		}
		return adj.get(v);
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u)
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 * @postcondition a sorted adjacency list
	 */
	public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (u <= 0 || u > vertices || v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("addDirectedEdge(): Cannot add edge. Out of bounds.");
		}
		
		List<Integer> adjU = adj.get(u); // Adjacency list of u
		
		if (u == v && adjU.binarySearch(v) != -1) { // Edge case: self loop
			// if self loop is already in u's adjacency list, do nothing; no multiple self loops
			return;
		} else if (adjU.isEmpty() || v <= adjU.getFirst()) {
			adjU.addFirst(v);
		} else if(v >= adjU.getLast()) {
			adjU.addLast(v);
		} else { 
			// v to be inserted between first and last of u's adjacency list
			int low = 1;
			int high = adjU.getLength();
			int mid;
			// Modified binary search algorithm for sorted insertion into list
			// O(log n) for large adjacency lists
			while (high > low) {
				mid = low + (high - low) / 2;
				adjU.advanceToIndex(mid);
				if (v == adjU.getIterator()) {  // if duplicate found (parallel edge)
					high = -1; // to exit loop
				} else if (v < adjU.getIterator()) {
					high = mid;
				} else {
					low = mid + 1;
				}
			} // iterator now pointing to last value <= v in u's adjacency list
			adjU.addIterator(v);
		}
		edges++;
		
/*

		
		if (!adjU.offEnd() && v != adjU.getIterator()) { // when position is correct
			adjU.addIterator(v);

			if (adjU.getIterator() == adjU.getFirst()) {
				adjU.addFirst(v);
			} else {
				adjU.reverseIterator();
				adjU.addIterator(v);
			}
		}*/
		
		/*
		adjU.placeIterator();
		// while adjacency list iterator is not offEnd(),
		// advance iterator in u's adjacency list to insert v in correct location (sorted order)
		while (!adjU.offEnd() && adjU.getIterator() < v) {
			adjU.advanceIterator();
		}

		if (adjU.offEnd()) { // v is > last in u's adjacency list or the list is empty
			adjU.addLast(v);
		} else if (adjU.getIterator() == adjU.getFirst()) { // v is <= first in u's adjacency list
			adjU.addFirst(v);
		} else { // first < v <= last of u's adjacency list
			// iterator currently pointing to first value >= v 
			adjU.reverseIterator();
			adjU.addIterator(v);
		}
		edges++;
		*/
	}

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into the
	 * list at index u) and inserts u into the adjacent vertex list of v
	 * 
	 * @precondition 0 < u <= vertices, 0 < v <= vertices
	 * @throws IndexOutOfBounds exception when the precondition is violated
	 * @postcondition a sorted adjacency list
	 */
	public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (u <= 0 || u > vertices || v <= 0 || v > vertices) {
			throw new IndexOutOfBoundsException("addUndirectedEdge(): Cannot add edge. Out of bounds.");
		}
		if (u == v) { // In case of self loop
			// don't allow multiple self loops; check if v is already in u's adjacency list
			if (adj.get(u).binarySearch(v) == -1) {
				addDirectedEdge(u, v);
			}
		} else {
			addDirectedEdge(u, v);
			addDirectedEdge(v, u);
			edges--; // addDirectedEdge increments edges by 1 each time but only one undirected edge
						// is being added
		}

	}

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space separated list of adjacent vertices>
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i <= vertices; i++) {
			result += i + ": " + adj.get(i) + "\n";
		}
		return result;
	}

	/**
	 * Prints the current values in the parallel ArrayLists after executing BFS.
	 * First prints the heading: v <tab> c <tab> p <tab> d Then, prints out this
	 * information for each vertex in the graph Note that this method is intended
	 * purely to help you debug your code
	 */
	public void printBFS() {
		System.out.println("V\tC\tP\tD");
		for (int i = 1; i <= vertices; i++) {
			System.out.println(i + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + distance.get(i));
		}
	}

	/**
	 * Performs breath first search on this Graph give a source vertex
	 * 
	 * @param source the source vertex
	 * @precondition graph must not be empty
	 * @precondition source is a vertex in the graph
	 * @throws IllegalStateException     if the graph is empty
	 * @throws IndexOutOfBoundsException when vertex is outside the bounds of the
	 *                                   graph
	 */

	public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IllegalStateException("BFS(): Cannot search. Graph is empty.");
		}
		if (source < 1 || source > vertices) {
			throw new IndexOutOfBoundsException("BFS(): Cannot search. Out of bounds.");
		}

		List<Integer> listQ = new List<Integer>();
		int x;
		color.set(source, 'G');
		distance.set(source, 0);
		listQ.addLast(source);
		while (!listQ.isEmpty()) {
			x = listQ.getFirst();
			List<Integer> adjX = adj.get(x);
			listQ.removeFirst();
			adjX.placeIterator();
			int adjVertex;
			for (int i = 1; i <= adjX.getLength(); i++) {
				adjVertex = adjX.getIterator(); // next adjacent vertex of x
				if (getColor(adjVertex) == 'W') {
					color.set(adjVertex, 'G');
					distance.set(adjVertex, getDistance(x) + 1);
					parent.set(adjVertex, x);
					listQ.addLast(adjVertex);
				}
				adjX.advanceIterator();
			}
			color.set(x, 'B');
		}

	}

}