
/**
 * Stack.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 */

import java.util.NoSuchElementException;

public class Stack<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node top;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Stack class
	 * 
	 * @postcondition a new Stack object with all fields assigned default values
	 */
	public Stack() {
		top = null;
		length = 0;
	}

	/**
	 * Copy constructor for the Stack class
	 * 
	 * @param original the Stack to copy
	 * @postcondition a new Stack object which is an identical, but distinct, copy
	 *                of original
	 */
	public Stack(Stack<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			top = null;
		} else {
			Stack<T> tempStack = new Stack<T>();
			Node temp = original.top;
			while (temp != null) {
				tempStack.push(temp.data);
				temp = temp.next;
			}
			temp = tempStack.top;
			while (temp != null) {
				push(temp.data);
				temp = temp.next;
			}
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored at the top of the Stack
	 * 
	 * @return the value at the top of the Stack
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T peek() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("peek(): Stack is empty. No data to access.");
		}
		return top.data;
	}

	/**
	 * Returns the length of the Stack
	 * 
	 * @return the length from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Determines whether a Stack is empty
	 * 
	 * @return whether the Stack is empty
	 */
	public boolean isEmpty() {
		return (length == 0);
	}

	/**
	 * Determines whether two Stacks contain the same values in the same order
	 * 
	 * @param Q the Stack to compare to this
	 * @return whether Q and this are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Stack)) {
			return false;
		} else {
			Stack<T> S = (Stack<T>) o;
			if (this.length != S.length) {
				return false;
			} else {
				Node temp1 = this.top;
				Node temp2 = S.top;
				while (temp1 != null) {
					if (temp1.data != temp2.data) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}
	}

	/**** MUTATORS ****/

	/**
	 * Inserts a new value at the top of the Stack
	 * 
	 * @param data the new data to insert
	 * @postcondition a new node at the end of the Stack
	 */
	public void push(T data) {
		Node N = new Node(data); // Create new Node
		N.next = top; // Update new Node's next to point to current top Node
		top = N; // Update top to new Node
		length++;
	}

	/**
	 * Removes the top element of the Stack
	 * 
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 * @postcondition the top element has been removed
	 */
	public void pop() throws NoSuchElementException {
		if (length == 0) { // Stack is empty; precondition
			throw new NoSuchElementException("pop(): Cannot remove from an empty Stack");
		} else { // General case
			top = top.next; // Advance top reference variable to link to the second Node
		}
		length--;
	}

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Stack as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Stack values
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = top;
		while (temp != null) {
			result += temp.data + "\n";
			temp = temp.next;
		}
		return result;
	}

}