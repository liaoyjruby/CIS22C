
/**
* StackTest.java
* @author Yi Jou (Ruby) Liao
* @author Alvin Nguyen
* CIS 22C Lab 3
*/

import java.util.NoSuchElementException;

public class StackTest {

	public static void main(String[] args) {
		// Test constructor
		System.out.println("**Testing constructor**");
		Stack<Character> S = new Stack<>();
		Stack<Character> S2 = new Stack<>();

		// Test copy constructor
		System.out.println("**Testing copy constructor**");
		Stack<Character> S3 = new Stack<>(S);
		System.out.println("Should print true: " + S.equals(S3));
		S2.push('a');
		S2.push('b');
		Stack<Character> S4 = new Stack<>(S2);
		System.out.println("Should print true: " + S2.equals(S4));
		
		// Test peek()
		System.out.println("**Testing peek()**");
		System.out.println("Should print an error message for an empty Stack: ");
		try { // Place in a try-catch so program does not end when exception thrown
			S.peek(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Should print 'b': " + S2.peek());
		
		// Test getLength()
		System.out.println("**Testing getLength()**");
		System.out.println("Should print 2: " + S2.getLength());
		System.out.println("Should print 0: " + S.getLength());
		
		// Test isEmpty()
		System.out.println("**Testing isEmpty()**");
		System.out.println("Should print true: " + S.isEmpty());
		System.out.println("Should print false: " + S2.isEmpty());
		
		// Test equals()
		System.out.println("**Testing equals()**");
		Stack<Character> S5 = S;
		System.out.println("Should print true: " + S.equals(S5));
		int number = 1234;
		System.out.println("Should print false: " + S.equals(number));
		System.out.println("Should print false: " + S.equals(S2));
		S.push('a');
		S.push('b');
		System.out.println("Should print true: " + S.equals(S2));
		
		// Test push()
		System.out.println("**Testing push()**");
		S3.push('a'); // Testing Edge case: length == 0
		System.out.println("Should print a: " + S3);
		S3.push('c'); // Testing General case: length >= 1
		System.out.println("Should print c a: " + S3); // Data entries should be displayed on its own line
		
		// Test pop()
		System.out.println("**Testing pop()**");
		S.pop(); // Testing General case: length >1
		System.out.println("Should print 'a': " + S);
		System.out.println("Should print 1: " + S.getLength());
		S.pop(); // Testing Edge case: length == 1
		System.out.println("Should print an empty Stack: " + S);
		System.out.println("Should print 0: " + S.getLength());
		System.out.println("Should print an error message for an empty Queue: ");
		try { // Place in a try-catch so program does not end when exception thrown
			S.pop(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Test toString()
		System.out.println("**Testing toString()**");
		System.out.println("Should print nothing (an empty Stack): " + S);
		System.out.println("Should print b a: " + S2);
		
	}

}

/*
**Testing constructor**
**Testing copy constructor**
Should print true: true
Should print true: true
**Testing peek()**
Should print an error message for an empty Stack: 
peek: Stack is empty. No data to access.
Should print 'b': b
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
**Testing push()**
Should print a: a

Should print c a: c
a

**Testing pop()**
Should print 'a': a

Should print 1: 1
Should print an empty Stack: 
Should print 0: 0
Should print an error message for an empty Queue: 
pop(): Cannot remove from an empty Stack
**Testing toString()**
Should print nothing (an empty Stack): 
Should print b a: b
a
*/
