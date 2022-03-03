
/**
 * Constructs List of Blocks from transactions.txt data
 * Displays UI for additional data input
 * Prints List data to file
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 */

import java.util.*;
import java.io.*;

public class BlockChain {

	public static void main(String[] args) {
		// If running on Windows system, change line 17 to .useDelimiter("\\r\\n")
		Scanner in = new Scanner(System.in).useDelimiter("\\n"); // Delimiter reads each line as a single token
		String fileName = "transactions.txt";

		List<Block> L = new List<>();
		L = readFile(fileName); // Use transactions.txt to populate Nodes of List

		System.out.println("Welcome to Block Chain!");
		char yesNo = 'y';

		while (yesNo == 'y') {
			System.out.println("\nTotal Number of Blocks: " + Block.getNumBlocks() + "\n");
			System.out.print("Would you like to add another transaction (y/n)?: ");
			yesNo = in.next().charAt(0);
			if (yesNo == 'y') { // User's choice to add another entry
				System.out.print("Enter the transaction id: ");
				int id = in.nextInt(); // If InputMismatchException, see lines 16/17 and adjust Delimiter if necessary
				System.out.print("Enter the customer first and last name: ");
				String name = in.next();
				StringTokenizer st = new StringTokenizer(name); // Tokenize full name to two separate words
				String firstName = st.nextToken();
				String lastName = st.nextToken();
				System.out.print("Enter the transaction description: ");
				String description = in.next();
				if (!(L.isEmpty())) // Only computes hash of previous Node if reading information of next node
					L.getLast().computeHash(id, firstName, lastName);
				Block block = new Block(id, firstName, lastName, description); // Construct Block with user's data
				L.addLast(block); // Add new block read in to end of List
			}
		}

		System.out.println("\nTotal Number of Blocks: " + Block.getNumBlocks() + "\n");

		System.out.print("Enter the name of the output file: ");
		String outputName = in.next();
		printOutput(L, outputName);

		System.out.println("Goodbye!");
	}

	/**
	 * Returns List of Blocks populated by .txt file of specified name
	 * @param fileName specified name of data input file ("transactions.txt")
	 * @return List of Blocks populated by data within transactions.txt
	 */
	public static List<Block> readFile(String fileName) {
		List<Block> L = new List<>();
		int id;
		String name;
		String firstName;
		String lastName;
		String description;
		Block block;

		try { // Within try/catch in case of FileIO exception
			FileReader file = new FileReader(fileName); // Open file
			BufferedReader buff = new BufferedReader(file); // Open buffer
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();

				if (line == null) // When line read in is empty, end of file is reached and loop is exited
					eof = true;
				else {
					id = Integer.parseInt(line);
					name = buff.readLine();
					StringTokenizer st = new StringTokenizer(name); // Tokenize full name to first/last name
					firstName = st.nextToken();
					lastName = st.nextToken();
					description = buff.readLine();
					if (!(L.isEmpty())) // Only computes hash of previous Node if reading information of next node
						L.getLast().computeHash(id, firstName, lastName);
					block = new Block(id, firstName, lastName, description);
					L.addLast(block); // Add new block read in to end of list
				}
			}
			buff.close();
		} catch (IOException e) { // In case of exception during file reading, will print exception
			System.out.println("Error: " + e.toString());
		}
		return L;
	}

	/**
	 * Log data to output ".txt" file of user specified title
	 * @param L completed List<Block> previously populated by input file
	 *    "transactions.txt" and user data entry
	 * @param outputName user inputted name of output file; must be of format
	 *    "name.txt"
	 */
	public static void printOutput(List<Block> L, String outputName) {
		try {
			FileWriter file = new FileWriter(outputName);
			BufferedWriter buff = new BufferedWriter(file);
			PrintWriter print = new PrintWriter(buff);
			print.println(L);
			print.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}

}
