/**
 * Card.java
 * 
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen CIS 22C, Lab 2
 */

public class Card implements Comparable<Card> {
	private String rank;
	private String suit;

	/**
	 * Instantiates a new Card object with parameter values
	 * 
	 * @param rank the rank of card from 2 to A
	 * @param suit the suit of card C, D, H, or S
	 */
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns the card's rank
	 * 
	 * @return rank a rank from 2 (low) to A (high)
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Returns the card's suit
	 * 
	 * @return C, D, H, or S
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Updates the card's rank
	 * 
	 * @param rank a new rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Updates the card's suit
	 * 
	 * @param suit the new suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Concatenates rank and suit
	 */
	@Override
	public String toString() {
		return rank + suit;
	}

	/**
	 * Overrides the equals method for Card Compares rank and suit and follows the
	 * equals formula given in Lesson 4 and also in Joshua Block's text
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) { // If same memory location in heap
			return true;
		} else if (!(o instanceof Card)) { // If wrong type
			return false;
		} else {
			Card C = (Card) o; // after confirming correct type, cast to List<T>
			// L is of type list
			if (this.rank.equals(C.rank) && this.suit.equals(C.suit)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Orders two cards first by suit (alphabetically) Next by rank. "A" is
	 * considered the high card Order goes 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	 * 
	 * @return a negative number if this comes before c and a positive number if c
	 *         comes before this and 0 if this and c are equal according to the
	 *         above equals method
	 */

	@Override
	public int compareTo(Card c) {
		// C D H S
		// 2 3 4 5 6 7 8 9 10 J Q K A

		if (this.equals(c))
			return 0;

		int suitComparison;

		suitComparison = this.getSuit().compareTo(c.getSuit());

		if (suitComparison == 0) { // If same suit
			int rankTemp1 = 0;
			int rankTemp2 = 0;
			// If this card is not a face card, parse rank as an int.
			// Otherwise assign int value for face card.
			switch (this.rank) {
			case "J":
				rankTemp1 = 11;
				break;
			case "Q":
				rankTemp1 = 12;
				break;
			case "K":
				rankTemp1 = 13;
				break;
			case "A":
				rankTemp1 = 14;
				break;
			default:
				rankTemp1 = Integer.parseInt(this.rank);
			}
			switch (c.rank) {
			case "J":
				rankTemp2 = 11;
				break;
			case "Q":
				rankTemp2 = 12;
				break;
			case "K":
				rankTemp2 = 13;
				break;
			case "A":
				rankTemp2 = 14;
				break;
			default:
				rankTemp2 = Integer.parseInt(c.rank);
			}

			// Compare rank
			if (rankTemp1 < rankTemp2) {
				return -1;
			} else {
				return 1;
			}

		} else {
			return suitComparison;
		}
	}
}