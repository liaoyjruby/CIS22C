/**
 * Class to test List.java
 * 
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 */

public class ListTest {

	public static void main(String[] args) {

		// Test printInReverse()
		System.out.println("**Testing printInReverse()**");
		List<Integer> L12 = new List<Integer>();
		L12.addLast(1);
		L12.addLast(2);
		L12.addLast(3);
		L12.addLast(4);
		System.out.print("Should print 4 3 2 1: ");
		L12.printInReverse();
		List<Integer> emptyL = new List<Integer>();
		System.out.print("Should print nothing: ");
		emptyL.printInReverse();
		List<Integer> oneL = new List<Integer>();
		oneL.addLast(0);
		System.out.print("Should print 0: ");
		oneL.printInReverse();

		// Test inSortedOrder()
		System.out.println();
		System.out.println("**Testing inSortedOrder()**");
		System.out.println("Should print true: " + L12.inSortedOrder());
		List<Integer> L13 = new List<Integer>();
		L13.addLast(4);
		L13.addLast(1);
		L13.addLast(3);
		System.out.println("Should print false: " + L13.inSortedOrder());
		System.out.println("Should print true: " + emptyL.inSortedOrder());
		System.out.println("Should print true: " + oneL.inSortedOrder());

		// Test advanceToIndex() + getIndex()
		System.out.println();
		System.out.println("**Testing advanceToIndex()**");
		L12.advanceToIndex(3);
		System.out.println("Should print 3: " + L12.getIterator());
		System.out.println("Should print 3: " + L12.getIndex());
		System.out.println("Should print an error message: ");
		try {
			emptyL.advanceToIndex(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("Should print an error message: ");
		try {
			emptyL.getIndex();
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println("Should print an error message: ");
		try {
			emptyL.advanceToIndex(1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		oneL.advanceToIndex(1);
		System.out.println("Should print 0: " + oneL.getIterator());
		System.out.println("Should print 1: " + oneL.getIndex());

		// Test linearSearch()
		System.out.println();
		System.out.println("**Testing linearSearch()**");
		System.out.println("Should print 2: " + (L13.linearSearch(1)));
		System.out.println("Should print -1: " + (L13.linearSearch(7)));
		System.out.println("Should print 1: " + (L13.linearSearch(4)));
		System.out.println("Should print -1: " + (emptyL.linearSearch(1)));
		System.out.println("Should print 1: " + (oneL.linearSearch(0)));
		System.out.println("Should print -1: " + (oneL.linearSearch(1)));

		// Test binarySearch()
		System.out.println();
		System.out.println("**Testing binarySearch()**");
		List<Integer> L = new List<Integer>();
		L.addLast(2);
		L.addLast(5);
		L.addLast(7);
		L.addLast(10);
		L.addLast(12);
		L.addLast(15);
		System.out.println("Should print 1: " + L.binarySearch(2));
		System.out.println("Should print 6: " + L.binarySearch(15));
		System.out.println("Should print 3: " + L.binarySearch(7));
		System.out.println("Should print -1: " + L.binarySearch(9));
		System.out.println("Should print -1: " + oneL.binarySearch(9));
		System.out.println("Should print 1: " + oneL.binarySearch(0));
		System.out.println("Should print -1: " + emptyL.binarySearch(9));
		System.out.println("Should print an error message: ");
		try {
			L13.binarySearch(0);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
	}
}

/* ListTest.java Output
**Testing printInReverse()**
Should print 4 3 2 1: 4 3 2 1
Should print nothing: 
Should print 0: 0

**Testing inSortedOrder()**
Should print true: true
Should print false: false
Should print true: true
Should print true: true

**Testing advanceToIndex()**
Should print 3: 3
Should print 3: 3
Should print an error message: 
java.lang.IndexOutOfBoundsException: advanceToIndex(): Cannot advance iterator. Index out of bounds.
Should print an error message: 
java.lang.NullPointerException: getIndex: Cannot access. Iterator is null.
Should print an error message: 
java.lang.IndexOutOfBoundsException: advanceToIndex(): Cannot advance iterator. Index out of bounds.
Should print 0: 0
Should print 1: 1

**Testing linearSearch()**
Should print 2: 2
Should print -1: -1
Should print 1: 1
Should print -1: -1
Should print 1: 1
Should print -1: -1

**Testing binarySearch()**
Should print 1: 1
Should print 6: 6
Should print 3: 3
Should print -1: -1
Should print -1: -1
Should print 1: 1
Should print -1: -1
Should print an error message: 
java.lang.IllegalStateException: binarySearch: Cannot do binary search. List is unsorted.
*/
