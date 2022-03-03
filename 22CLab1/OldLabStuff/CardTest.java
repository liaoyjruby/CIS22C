
public class CardTest {

	public static void main(String[] args) {
		// (rank number, suit type)
		Card one = new Card("10", "S");
		Card two = new Card("2", "S");

		System.out.println(one.equals(two));
		System.out.println(one.compareTo(two));

		Card c1 = new Card("2", "S"); // update here
		Card c2 = new Card("2", "S"); // update here
		if (c1.equals(c2)) {
			System.out.println(c1 + " is the same as " + c2);
			System.out.println(c1.compareTo(c2));

		} else if (c1.compareTo(c2) < 0) {
			System.out.println(c1 + " comes before " + c2);
			System.out.println(c1.compareTo(c2));
		} else {
			System.out.println(c2 + " comes before " + c1);
			System.out.println(c1.compareTo(c2));
		}

	}

}
