import java.util.NoSuchElementException;

public class ListTestOld {

	public static void main(String[] args) {
		// Test constructor
		List<Integer> L = new List<>();

		// Test toString()
		System.out.println("Should print nothing (an empty list): " + L);

		// Test addFirst()
		System.out.println("**Testing addFirst**");
		L.addFirst(2); // Testing Edge case: length == 0
		System.out.println("Should print 2: " + L);
		L.addFirst(1); // Testing General case: length >= 1
		System.out.println("Should print 1 2: " + L); // Data entries should be displayed on its own line

		// Test addLast()
		List<Integer> L2 = new List<>();
		System.out.println("**Testing addLast**");
		L2.addLast(3); // Testing Edge case: length == 0
		System.out.println("Should print 3: " + L2);
		L2.addLast(4); // Testing General case: length >= 1
		System.out.println("Should print 3 4: " + L2); // Data entries should be displayed on its own line

		// Test removeFirst()
		System.out.println("**Testing removeFirst**");
		L.removeFirst(); // Testing General case: length >1
		System.out.println("Should print 2: " + L);
		L.removeFirst(); // Testing Edge case: length == 1
		System.out.println("Should print an empty List: " + L);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			L.removeFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Test removeLast()
		System.out.println("**Testing removeLast**");
		L2.removeLast(); // Testing General case: length >1
		System.out.println("Should print 3: " + L2);
		L2.removeLast(); // Testing Edge case: length == 1
		System.out.println("Should print an empty List: " + L2);
		System.out.println("Should print an error message for an empty List: ");
		try { // Place in a try-catch so program does not end when exception thrown
			L2.removeLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Test isEmpty()
		System.out.println("**Testing isEmpty**");
		List<Integer> L3 = new List<>();
		System.out.println("Should print true: " + L3.isEmpty());
		L3.addFirst(0);
		System.out.println("Should print false: " + L3.isEmpty());

		// Test getLength()
		System.out.println("**Testing getLength()**");
		System.out.println("Length should be 1: " + L3.getLength());
		L3.removeFirst();
		System.out.println("Length should be 0: " + L3.getLength());

		// Test getFirst()
		System.out.println("**Testing getFirst()**");
		System.out.println("Should print an error message for an empty List: ");
		try { // Place in a try-catch so program does not end when exception thrown
			L3.getFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		L3.addFirst(1);
		System.out.println("Should print 1: " + L3.getFirst());
		L3.addFirst(2);
		System.out.println("Should print 2: " + L3.getFirst());

		// Test getLast()
		System.out.println("**Testing getLast()**");
		System.out.println("Should print 1: " + L3.getLast());
		L3.removeLast();
		System.out.println("Should print 2: " + L3.getLast());
		L3.removeFirst();
		System.out.println("Should print an error message for an empty List: ");
		try { // Place in a try-catch so program does not end when exception thrown
			L3.getLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Test placeIterator()
		System.out.println("**Testing placeIterator()**");
		L.placeIterator();
		System.out.println("Should print an error message for iterator pointing to null: ");
		try {
			System.out.println(L.getIterator());
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.addFirst(1);
		L.addFirst(2);
		L.placeIterator();
		System.out.println("Should print 2: " + L.getIterator());

		// Test getIterator()
		System.out.println("**Testing getIterator()**");
		System.out.println("Should print 2: " + L.getIterator());
		L.removeFirst();
		L.removeFirst();
		System.out.println("Should print an error message for iterator pointing to null: ");
		try {
			L.getIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		// Test advanceIterator()
		System.out.println("**Testing getIterator()**");
		System.out.println("Should print an error message for iterator being off end of list: ");
		try {
			L.advanceIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.addFirst(1);
		L.addFirst(2);
		L.placeIterator();
		L.advanceIterator();
		System.out.println("Should print 1: " + L.getIterator());

		// Test reverseIterator()
		System.out.println("**Testing reverseIterator()**");
		L.reverseIterator();
		System.out.println("Should print 2: " + L.getIterator());
		L.reverseIterator();
		System.out.println("Should print an error message for iterator being off end of list: ");
		try {
			L.reverseIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		// Test addIterator()
		System.out.println("**Testing addIterator()**");
		System.out.println("Should print an error message for iterator being off end of list: ");
		try {
			L.addIterator(3);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.placeIterator();
		L.advanceIterator();
		L.addIterator(3);
		System.out.println("Should print length of 3: " + L.getLength());
		System.out.println("Should print 2 1 3: " + L);
		L.addIterator(4);
		System.out.println("Should print length of 4: " + L.getLength());
		System.out.println("Should print 2 1 4 3: " + L);

		// Test removeIterator()
		System.out.println("**Testing removeIterator()**");
		L.advanceIterator();
		L.advanceIterator();
		L.advanceIterator();
		System.out.println("Should print an error message for iterator being off end of list: ");
		try {
			L.removeIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.placeIterator();
		L.removeIterator();
		System.out.println("Should print length of 3: " + L.getLength());
		System.out.println("Should print 1 4 3: " + L);
		System.out.println("Should print an error message for iterator pointing to null: ");
		try {
			L.getIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.placeIterator();
		L.advanceIterator();
		L.advanceIterator();
		L.removeIterator();
		System.out.println("Should print length of 2: " + L.getLength());
		System.out.println("Should print 1 4: " + L);
		System.out.println("Should print an error message for iterator pointing to null: ");
		try {
			L.getIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		L.addFirst(5);
		L.placeIterator();
		L.advanceIterator();
		L.removeIterator();
		System.out.println("Should print length of 2: " + L.getLength());
		System.out.println("Should print 5 4: " + L);
		System.out.println("Should print an error message for iterator pointing to null: ");
		try {
			L.getIterator();
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		// Test offEnd()
		System.out.println("Should print true: " + L.offEnd());
		L.placeIterator();
		System.out.println("Should print false: " + L.offEnd());

		// Test equals()
		List<Integer> L4 = new List<Integer>();
		List<Integer> L5 = L4;
		System.out.println("Should print true: " + L4.equals(L5));
		String str = "Hello world! :)";
		System.out.println("Should print false: " + L4.equals(str));
		List<Integer> L6 = new List<Integer>();
		L4.addFirst(1);
		System.out.println("Should print false: " + L4.equals(L6));
		L4.addFirst(2);
		L6.addFirst(1);
		L6.addFirst(2);
		System.out.println("Should print 2 1: " + L4);
		System.out.println("Should print 2 1: " + L6);
		System.out.println("Should print true: " + L4.equals(L6));

		// Test copy constructor
		List<Integer> L9 = new List<Integer>();
		List<Integer> L10 = new List<Integer>(L9);
		System.out.println("Should print true: " + L9.equals(L10));
		List<Integer> L11 = new List<Integer>(L4);
		System.out.println("Should print true: " + L11.equals(L4));


	}

}
