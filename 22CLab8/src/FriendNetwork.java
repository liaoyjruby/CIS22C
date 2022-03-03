
/**
 * FriendNetwork.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 * CIS 22C, Lab 8
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FriendNetwork {
	static Scanner in = new Scanner(System.in).useDelimiter(";|\r?\n|\r");

	public static void main(String[] args) throws IOException {
		FriendNetwork FN = new FriendNetwork();

		System.out.println("Welcome to the Friend Recommender!\n");

		ArrayList<String> names = new ArrayList<>(); // Parallel array to store name Strings
		names.add(null); // Leave index 0 empty for parallel array
		Graph G = FN.fileRead(names); // Reads in information from .txt file to populate Graph and ArrayList of names
		System.out.println("Enter Your User Number Below:");
		FN.userList(names); // Display users read in from file
		FN.userFriends(G, names); // Displays recommended friends; allows for new friends

		System.out.println("\nGoodbye!");
	}

	/**
	 * Populates Graph with data from .txt file
	 * 
	 * @param names  Parallel array for storing user names
	 * @precondition  .txt file to read data from must be in proper format
	 * @return  Graph created from .txt file
	 * @postcondition Graph created
	 */
	public Graph fileRead(ArrayList<String> names) {
		Graph G = new Graph(0); // Size of graph will be adjusted based on info in .txt
		String fileName; // User input String for file name
		Boolean inputValid = true; // For file name input validation

		do {
			try {
				System.out.print("Enter the name of a file: ");
				fileName = in.next();
				File file = new File(fileName);
				Scanner input = new Scanner(file); // exception thrown here if file name is invalid

				if (input.hasNext()) { // check for empty file
					int size = Integer.parseInt(input.nextLine());
					G = new Graph(size); // size Graph appropriately according to first line of .txt
				}

				int currentID; // ID of user currently being read in from file
				String friendList; // Line to store comma separated list of friend
				int friendID; // ID of friend from comma separated list of friends
				StringTokenizer st;
				while (input.hasNext()) {
					currentID = Integer.parseInt(input.nextLine());
					names.add(input.nextLine());
					friendList = input.nextLine();
					st = new StringTokenizer(friendList, ", "); // Use StringTokenizer to separate line by commas
					while (st.hasMoreTokens()) {
						friendID = Integer.parseInt(st.nextToken());
						G.addDirectedEdge(currentID, friendID);
					}
				}
				inputValid = true;
				input.close();
			} catch (IOException e) {
				System.out.println("\nInvalid file name!");
				inputValid = false; // Cannot exit loop if exception is caught
			}
		} while (!inputValid);

		return G;
	}

	/**
	 * Displays a list of all users (vertexes in the graph)
	 * 
	 * @param names  Parallel array for storing user names
	 */
	public void userList(ArrayList<String> names) {
		for (int i = 1; i < names.size(); i++) {
			System.out.println(i + ". " + names.get(i));
		}
	}

	/**
	 * Displays recommended friends & allows for addition of friends
	 * 
	 * @param G  Graph of all users
	 * @param names  Parallel array for storing user names
	 * @postcondition  If user adds new friends, graph is updated with undirected edges to new friends
	 */
	public void userFriends(Graph G, ArrayList<String> names) {
		System.out.print("\nEnter your choice: ");
		int userID = Integer.parseInt(in.next()); // User input of their own ID
		int friendID; // User input choice of friend's ID
		ArrayList<Integer> recFriends = new ArrayList<>(); // ArrayList of recommended friends user IDs

		G.BFS(userID); // Updates values of parallel arrays to reflect connections to user vertex
		List<Integer> adjUser = G.getAdjacencyList(userID); // Adjacency list of the user
		
		// Build list of recommended friends (friends of current friends)
		// iterating through distance array
		for (int i = 1; i <= G.getNumVertices(); i++) { // This may be inefficient for extremely large graphs
			if (G.getDistance(i) >= 2) {
				recFriends.add(i);
			}
		}
		
		do {
			// Prints adjacency list of user chosen user ID
			System.out.println("\nHere are your current friends:");
			
			// Iterate through each node of adjacency list and print as you go
			adjUser.placeIterator();
			for (int i = 1; i <= adjUser.getLength(); i++) {
				System.out.println(adjUser.getIterator() + ". " + names.get(adjUser.getIterator()));
				adjUser.advanceIterator();
			}

			// Prints recommended friends; vertices >= 2 distance from source
			System.out.println("\nHere are your recommended friends:");

			// Print recommended friends ArrayList + names associated with IDs
			if (recFriends.size() > 0) { // if adding more friends is possible
				for (int i = 0; i < recFriends.size(); i++) { // print recommended friends list
					System.out.println(recFriends.get(i) + ". " + names.get(recFriends.get(i)));
				}

				System.out.println("\nEnter the number of a friend to add or -1 to quit:");
				System.out.print("Enter your choice: ");
				friendID = Integer.parseInt(in.next());
				if (friendID != -1) { // add edge between recommended friend of choice
					G.addUndirectedEdge(userID, friendID);
					int recFriendsIndex = recFriends.indexOf(friendID);
					recFriends.remove(recFriendsIndex); // update recommended friends arrayList
				}
			} else { // no more possible recommended friends to add
				System.out.println("Sorry! We don't have any recommendations for you at this time.");
				friendID = -1; // exit loop
			}
		} while (friendID != -1);

	}

}
