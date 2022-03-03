import java.util.NoSuchElementException;

/**
 * Queue.java
 * 
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen 
 * CIS 22C Lab 5
 */

public class Queue<T> {
	private Stack<T> s1;
	private Stack<T> s2;

	/** Constructors **/

	/**
	 * Default constructor for the Queue class
	 */
	public Queue() {
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
	}

	/**
	 * Copy constructor for the Queue class
	 * 
	 * @param q the original Queue to copy
	 */
	public Queue(Queue<T> q) {
		if (q == null) {
			this.s1 = new Stack<>();
			this.s2 = new Stack<>();
		} else {
			this.s1 = new Stack<>();
			this.s2 = new Stack<>();
			T temp;
			for (int i = 0; i < q.getSize(); i++) {
				temp = q.getFront();
				this.enqueue(temp);
				q.dequeue();
				q.enqueue(temp);
			}
		}
	}

	/** Mutators **/

	/**
	 * Inserts new data to the end of the Queue
	 * 
	 * @param data the value to insert
	 */
	public void enqueue(T data) {
		s1.push(data);
	}

	/**
	 * Removes data from the front
	 * 
	 * @precondition length != 0
	 */
	public void dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("dequeue: Cannot dequeue from empty queue!");
		}

		if (s2.isEmpty()) { // Move everything from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}
		s2.pop();
	}

	/**
	 * Appends the values of a a new Queue onto the end of this Queue
	 * 
	 * @param q the Queue whose values to append
	 */
	public void append(Queue<T> q) {
		T temp;
		for (int i = 0; i < q.getSize(); i++) {
			temp = q.getFront();
			this.enqueue(temp);
			q.dequeue();
			q.enqueue(temp);
		}
	}

	/** Accessors **/

	/**
	 * Returns the data at the front
	 * 
	 * @precondition length != 0
	 * @return the front of the Queue
	 */
	public T getFront() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("getFront: Cannot get front of empty queue!");
		}
		if (s2.isEmpty()) { // Move everything from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}
		return s2.peek();
	}

	/**
	 * Returns the current size of this Queue
	 * 
	 * @return the current size
	 */
	public int getSize() {
		return s1.getLength() + s2.getLength();
	}

	/**
	 * Returns whether this Queue is currently empty
	 * 
	 * @return whether the Queue is empty
	 */
	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	/**
	 * Determines whether two Queues have the data stored in the same order
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Queue)) {
			return false;
		} else {
			@SuppressWarnings("unchecked")
			Queue<T> Q = (Queue<T>) o;
			if (this.getSize() != Q.getSize()) {
				return false;
			} else {
				T qFront, thisFront;
				boolean equal = true;
				// To iterate through the queues, move front to the back of the queues.
				// Then compare the new fronts. Repeat until queues return to original state.
				for (int i = 0; i < Q.getSize(); i++) {
					qFront = Q.getFront();
					thisFront = this.getFront();
					if (!qFront.equals(thisFront)) {
						equal = false;
					}
					// Move front to back of queue
					Q.dequeue();
					Q.enqueue(qFront);
					this.dequeue();
					this.enqueue(thisFront);
				}
				return equal;
			}
		}
	}

	/** Additional Operations **/

	/**
	 * Creates a String to store the values the Queue,separated with spaces and
	 * ending with a new line character
	 */
	@Override
	public String toString() {
		String qStr;
		if (s2.isEmpty()) { // Move everything from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
			qStr = s2.toString();
		} else if (s1.isEmpty()) {
			qStr = s2.toString();
		} else { // Both stacks not empty
			qStr = s2.toString();
			int s1Length = s1.getLength();

			// Move s1 to s2 to for correct sequential order
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
			// Return s1 to original state from s2 while concatenating to string
			for (int i = 0; i < s1Length; i++) {
				qStr += s2.peek() + "\n";
				s1.push(s2.peek());
				s2.pop();
			}
		}
		return qStr;
	}
}