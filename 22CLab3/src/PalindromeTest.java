
/**
 * PalindromeTest.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 */

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class PalindromeTest {
	private Queue<Character> Q = new Queue<Character>();
	private Stack<Character> S = new Stack<Character>();

	public static void main(String[] args) throws IOException {
		PalindromeTest P = new PalindromeTest();
		System.out.print("Welcome!\n\nEnter the name of a file: ");

		Scanner in = new Scanner(System.in);
		Scanner fileSC;
		File f;
		Boolean inputValid = true;

		String fileName = in.next();

		do {
			try {
				f = new File(fileName);
				fileSC = new Scanner(f);

				System.out.println("\nLabeled Data: \n");
				while (fileSC.hasNext()) {
					String line = fileSC.nextLine();
					P.storeChars(line); 
					boolean continueLoop = true;
					boolean isPalindrome = true;

					do { // Compares character by character
						if (!P.Q.isEmpty()) { // If not empty
							char qChar = P.Q.getFront();
							char sChar = P.S.peek();
							if (qChar != sChar) { // If characters don't match
								continueLoop = false;
								isPalindrome = false;
								P.empty();
							} else { // Characters match so far
								// Discard matching characters and move to next
								P.Q.dequeue();
								P.S.pop();
							}
						} else { // If empty
							continueLoop = false;
						}
					} while (continueLoop);

					System.out.print(line);
					if (isPalindrome) {
						System.out.println(" (palindrome)");
					} else {
						System.out.println();
					}		
				}
				inputValid = true;
			} catch (IOException e) {
				System.out.println("Sorry, but I cannot find a file with that name!\n");
				System.out.print("Enter the name of a file: ");
				fileName = in.next();
				inputValid = false;
			}
		} while (!inputValid);
		in.close();
	}// end of main

	/**
	 * Removes punctuation and whitespace from a string and stores it in a queue and
	 * stack of characters.
	 * 
	 * @param line line is a string to be stored in a queue and stack.
	 * @precondition String line != null
	 * @postcondition A queue and stack of characters without punctuation or
	 *                whitespace is generated from the line parameter.
	 */
	public void storeChars(String line) {
		line = line.replaceAll("\\s|[^a-zA-Z]", "");
		line = line.toLowerCase();

		for (int i = 0; i < line.length(); i++) {
			Q.enqueue(line.charAt(i));
			S.push(line.charAt(i));
		}
	}

	/**
	 * Empties queue and stack
	 * 
	 * @precondition Queue and stack are both the same length.
	 * @postcondition Both queue and stack are empty.
	 */
	public void empty() {
		while (Q.getLength() != 0) {
			Q.dequeue();
			S.pop();
		}
	}
}