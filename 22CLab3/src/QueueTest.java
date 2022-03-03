
/**
* QueueTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import java.util.NoSuchElementException;

public class QueueTest {

	public static void main(String[] args) {
		// Test constructor
		System.out.println("**Testing constructor**");
		Queue<Character> Q = new Queue<>();
		Queue<Character> Q2 = new Queue<>();

		// Test copy constructor
		System.out.println("**Testing copy constructor**");
		Queue<Character> Q3 = new Queue<>(Q);
		System.out.println("Should print true: " + Q.equals(Q3));
		Q2.enqueue('a');
		Q2.enqueue('b');
		Queue<Character> Q4 = new Queue<>(Q2);
		System.out.println("Should print true: " + Q2.equals(Q4));

		// Test getFront()
		System.out.println("**Testing getFront()**");
		System.out.println("Should print an error message for an empty Queue: ");
		try { // Place in a try-catch so program does not end when exception thrown
			Q.getFront(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Should print 'a': " + Q2.getFront());

		// Test getLength()
		System.out.println("**Testing getLength()**");
		System.out.println("Should print 2: " + Q2.getLength());
		System.out.println("Should print 0: " + Q.getLength());

		// Test isEmpty()
		System.out.println("**Testing isEmpty()**");
		System.out.println("Should print true: " + Q.isEmpty());
		System.out.println("Should print false: " + Q2.isEmpty());

		// Test equals()
		System.out.println("**Testing equals()**");
		Queue<Character> Q5 = Q;
		System.out.println("Should print true: " + Q.equals(Q5));
		int number = 1234;
		System.out.println("Should print false: " + Q.equals(number));
		System.out.println("Should print false: " + Q.equals(Q2));
		Q.enqueue('a');
		Q.enqueue('b');
		System.out.println("Should print true: " + Q.equals(Q2));

		// Test enqueue()
		System.out.println("**Testing enqueue()**");
		Q3.enqueue('a'); // Testing Edge case: length == 0
		System.out.println("Should print a: " + Q3);
		Q3.enqueue('c'); // Testing General case: length >= 1
		System.out.println("Should print a c: " + Q3); // Data entries should be displayed on its own line

		// Test dequeue()
		System.out.println("**Testing dequeue()**");
		Q.dequeue(); // Testing General case: length >1
		System.out.println("Should print 'b': " + Q);
		Q.dequeue(); // Testing Edge case: length == 1
		System.out.println("Should print an empty Queue: " + Q);
		System.out.println("Should print an error message for an empty Queue: ");
		try { // place in a try-catch so program does not end when exception thrown
			Q.dequeue(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Test toString()
		System.out.println("**Testing toString()**");
		System.out.println("Should print nothing (an empty queue): " + Q);
		System.out.println("Should print a b: " + Q2);
	}

}

/*
**Testing constructor**
**Testing copy constructor**
Should print true: true
Should print true: true
**Testing getFront()**
Should print an error message for an empty Queue: 
getFront: Queue is empty. No data to access.
Should print 'a': a
**Testing getLength()**
Should print 2: 2
Should print 0: 0
**Testing isEmpty()**
Should print true: true
Should print false: false
**Testing equals()**
Should print true: true
Should print false: false
Should print false: false
Should print true: true
**Testing enqueue()**
Should print a: a

Should print a c: a
c

**Testing dequeue()**
Should print 'b': b

Should print an empty Queue: 
Should print an error message for an empty Queue: 
dequeue(): Cannot remove from an empty Queue
**Testing toString()**
Should print nothing (an empty queue): 
Should print a b: a
b

 */
