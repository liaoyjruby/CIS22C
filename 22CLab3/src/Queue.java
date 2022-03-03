
/**
 * Queue.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 */

import java.util.NoSuchElementException;

public class Queue<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node front;
	private Node end;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Queue class
	 * 
	 * @postcondition a new Queue object with all fields assigned default values
	 */
	public Queue() {
		front = null;
		end = null;
		length = 0;
	}

	/**
	 * Copy constructor for the Queue class
	 * 
	 * @param original the Queue to copy
	 * @postcondition a new Queue object which is an identical, but distinct, copy
	 *                of original
	 */
	public Queue(Queue<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			front = null;
			end = null;
		} else {
			Node temp = original.front;
			while (temp != null) {
				enqueue(temp.data);
				temp = temp.next;
			}
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored at the front of the Queue
	 * 
	 * @return the value at the front of the queue
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T getFront() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFront(): Queue is empty. No data to access.");
		}
		return front.data;
	}

	/**
	 * Returns the length of the Queue
	 * 
	 * @return the length from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Determines whether a Queue is empty
	 * 
	 * @return whether the Queue is empty
	 */
	public boolean isEmpty() {
		return (length == 0);
	}

	/**
	 * Determines whether two Queues contain the same values in the same order
	 * 
	 * @param o the Object to compare to this
	 * @return whether o and this are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Queue)) {
			return false;
		} else {
			Queue<T> Q = (Queue<T>) o;
			if (this.length != Q.length) {
				return false;
			} else {
				Node temp1 = this.front;
				Node temp2 = Q.front;
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
	 * Inserts a new value at the end of the Queue
	 * 
	 * @param data the new data to insert
	 * @postcondition a new node at the end of the Queue
	 */
	public void enqueue(T data) {
		if (length == 0) { // Edge case: queue is empty
			front = end = new Node(data);
		} else { // General case: queue is not empty
			Node N = new Node(data);
			end.next = N; // Update end Node's next to point to new end Node
			end = N; // Update end pointer to new end Node
		}
		length++;
	}

	/**
	 * Removes the front element in the Queue
	 * 
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the precondition is violated
	 * @postcondition the front element has been removed
	 */
	public void dequeue() throws NoSuchElementException {
		if (length == 0) { // Queue is empty; precondition
			throw new NoSuchElementException("dequeue(): Cannot remove from an empty Queue");
		} else if (length == 1) { // Queue has one node; edge case
			front = end = null; // Return Queue to empty state, where front and end are null and length is 0
		} else { // Queue has 1+ node; general case
			front = front.next; // Advance front reference variable to link to the second Node
		}
		length--;
	}

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Queue as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Queue values
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = front;
		while (temp != null) {
			result += temp.data + "\n";
			temp = temp.next;
		}
		return result;
	}

}
