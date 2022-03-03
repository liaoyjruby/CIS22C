
/**
 * CardApp.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 * CIS 22C, Lab 2
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CardApp {

	private List<Card> L = new List<>();

	public static void main(String[] args) {
		CardApp lApp = new CardApp();
		System.out.println("Welcome!\n");
		System.out.print("Enter the name of the file containing a deck of cards: ");

		lApp.populate();
		lApp.shuffle();
		lApp.sort();

		System.out.println("Please open shuffled.txt and sorted.txt.\n");
		System.out.println("Goodbye!");

	}

	/**
	 * Shuffles cards following this algorithm: First swaps first and last card
	 * Next, swaps every even card with the card 3 nodes away from that card. Stops
	 * when it reaches the 3rd to last node Then, swaps ALL cards with the card that
	 * is 3 nodes away from it, stopping at the 3rd to last node
	 * 
	 * @postcondition Linked list is shuffled by algorithm and is then printed to
	 *                "shuffled.txt"
	 */
	public void shuffle() {
		Card cFirst = new Card(L.getFirst().getRank(), L.getFirst().getSuit()); // Copy first card
		Card cLast = new Card(L.getLast().getRank(), L.getLast().getSuit()); // Copy last card

		// Swap first with last
		L.removeFirst();
		L.addFirst(cLast);
		L.removeLast();
		L.addLast(cFirst);

		// Swap even cards with card 3 nodes away
		int n = (L.getLength() / 2) - 2; // Formula for # of even cards to swap for any size deck. -2 to skip last card.
		Card cTemp;
		for (int i = 0; i < n; i++) {
			repositionIterator(2 * i + 1); // Since n is half the deck, 2*i. +1 to skip first card.
			cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit()); // Copy even card

			// Move 3 nodes away
			L.advanceIterator();
			L.advanceIterator();
			L.advanceIterator();

			// Swap if possible
			if (!L.offEnd()) {
				L.addIterator(cTemp); // Insert even card
				cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit()); // Copy card to be moved back 3
																						// nodes
				L.removeIterator();
				repositionIterator(2 * i + 1);
				L.addIterator(cTemp); // Insert the copy
				L.removeIterator(); // Remove even card
			}
		}

		// Swap all cards with card 3 nodes away
		n = L.getLength() - 4; // -4 representing the last swap, 3rd from the last node
		for (int i = 0; i < n; i++) {
			L.placeIterator();
			for (int j = 0; j <= i; j++) {
				L.advanceIterator();
			}
			cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit());
			L.advanceIterator();
			L.advanceIterator();
			L.advanceIterator();
			L.addIterator(cTemp); // Insert node
			cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit()); // Copy node 3 nodes away
			L.removeIterator();
			L.placeIterator();
			for (int j = 0; j <= i; j++) { // go back to node
				L.advanceIterator();
			}
			L.addIterator(cTemp); // Insert other node
			L.removeIterator(); // Remove node
		}

		try { // Print to shuffled.txt
			PrintWriter print = new PrintWriter("shuffled.txt");
			print.println(L);
			print.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}

	/**
	 * Implements the bubble sort algorithm to sort L into sorted order, first by
	 * suit (alphabetical order) then by rank from 2 to A
	 * 
	 * @postcondition Linked list L is sorted first by suit and then by rank. Then
	 *                the list is printed out to "sorted.txt" file.
	 */
	public void sort() {
		int n = L.getLength();
		Card cTemp;

		for (int i = 0; i < n - 1; i++) { // For each card, sort to the correct position in deck
			L.placeIterator(); // Go to beginning to sort next card
			for (int j = 0; j < n - i - 1; j++) { // For each bubble sort pass through the deck
				cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit()); // Copy current card
				L.advanceIterator(); // Move to next card

				// If previous card is bigger, swap.
				if (cTemp.compareTo(L.getIterator()) > 0) {
					L.reverseIterator(); // Go back to previous card to copy and remove
					cTemp = new Card(L.getIterator().getRank(), L.getIterator().getSuit());
					L.removeIterator(); // Iterator is now off the end
					repositionIterator(j); // Return iterator to same node location in the list
					L.addIterator(cTemp); // Insert copied card to finish swap
					L.advanceIterator(); // Move to next card to be compared for swap
				}
			}
		}

		try { // Print to sorted.txt
			PrintWriter print = new PrintWriter("sorted.txt");
			print.println(L);
			print.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	/**
	 * Populates CardApp's double-linked list for a deck of cards by .txt file that
	 * the user specifies
	 * 
	 * @precondition .txt input file must be in correct format. One card per line
	 *               denoted as [rank][suit letter]
	 * @postcondition A double-linked list representing a deck of cards is created
	 */
	public void populate() {
		Scanner in = new Scanner(System.in);
		Scanner fileSC;
		File f;
		Boolean inputValid = true;
		String rank;
		String suit;

		String fileName = in.next();

		do {
			try {
				f = new File(fileName);
				fileSC = new Scanner(f);

				while (fileSC.hasNext()) {
					String temp = fileSC.nextLine();
					suit = temp.substring(temp.length() - 1); // Suit is always last character in line
					rank = temp.substring(0, temp.length() - 1);
					Card c = new Card(rank, suit);
					L.addLast(c);
				}
				inputValid = true;
			} catch (IOException e) {
				System.out.print("Invalid file name. Please enter a valid file name: ");
				fileName = in.next();
				inputValid = false;
			}
		} while (!inputValid);
		in.close();
	}

	/**
	 * Places iterator at the first node and advances it n times.
	 * 
	 * @param n the number of times to advance the iterator from the beginning of
	 *          CardApp's linked-list
	 * @precondition List length != 0
	 * @postcondition Iterator points to node after advancing n times from the
	 *                beginning of the list
	 */
	public void repositionIterator(int n) {
		if (L.getLength() != 0) {
			L.placeIterator();
			for (int i = 0; i < n; i++) {
				L.advanceIterator();
			}
		}
	}
}
