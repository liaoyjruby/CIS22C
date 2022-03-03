import java.util.NoSuchElementException;

/**
 * QueueTest.java
 * 
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen 
 * CIS 22C Lab 5
 */
public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		System.out.println("**Testing enqueue()**");
		q.enqueue("1");
		System.out.println("Should print 1: " + q);
		q.enqueue("2");
		System.out.println("Should print 1 2: " + q);
		q.enqueue("3");
		System.out.println("Should print 1 2 3: " + q);

		System.out.println("\n**Testing dequeue()**");
		q.dequeue();
		System.out.println("Should print 2 3: " + q);

		System.out.println("\n**Testing isEmpty()**");
		Queue<String> q2 = new Queue<>();
		System.out.println("Should print true: " + q2.isEmpty());
		System.out.println("Should print false: " + q.isEmpty());

		System.out.println("\n**Testing append()**");
		q2.enqueue("A");
		q2.enqueue("B");
		q2.enqueue("C");
		q2.enqueue("D");
		q.append(q2);
		System.out.println("Should print 2 3 A B C D: " + q);

		System.out.println("\n**Testing getFront()**");
		System.out.println("Should print A: " + q2.getFront());

		System.out.println("\n**Testing getSize()**");
		System.out.println("Should print 6: " + q.getSize());

		System.out.println("\n**Testing Equals**");
		System.out.println("Should print true: " + q2.equals(q2));
		System.out.println("Should print false: " + q.equals(q2));
		q.dequeue();
		q.dequeue();
		System.out.println("Should print true: " + q.equals(q2));
		q.dequeue();

		System.out.println("\n**Testing Copy Constructor**");
		Queue<String> q3 = new Queue<String>(q2);
		System.out.println("Should print A B C D: " + q3);
		q3.enqueue("E");
		q3.enqueue("F");

		System.out.println("\n**Testing for Deep Copy**");
		System.out.print("Should print A B C D E F: " + q3);
		System.out.print("Should print A B C D: " + q2);

		
		
		System.out.println("\n**Extra Methods for Testing**");
		System.out.println("\n**Testing Enqueue**");

		q.enqueue("A");
		System.out.println("Should print B C D A: " + q);
		q2.enqueue("A");
		System.out.println("Should print A B C D A: " + q2);

		System.out.println("\n**Testing Dequeue**");
		q.dequeue();
		System.out.println("Should print C D A: " + q);
		Queue<String> q4 = new Queue<String>();
		System.out.println("Should print error message");
		try {
			q4.dequeue();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

		System.out.println("\n**Testing isEmpty**");
		System.out.println("Should print true: " + q4.isEmpty());
		System.out.println("Should print false: " + q.isEmpty());

		System.out.println("\n**Testing append**");
		q.append(q4);
		System.out.println("Should print C D A: " + q);
		q.append(q2);
		System.out.println("Should print C D A A B C D A: " + q);

		System.out.println("\n**Testing getFront**");
		System.out.println("Should print error message");
		try {
			q4.dequeue();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		System.out.println("Should print C: " + q.getFront());

		System.out.println("\n**Testing getSize**");
		System.out.println("Should print 0: " + q4.getSize());
		System.out.println("Should print 8: " + q.getSize());

		System.out.println("\n**Testing Equals**");
		System.out.println("Should print true: " + q.equals(q));
		System.out.println("Should print false: " + q.equals(q4));

		System.out.println("\n**Testing Copy Constructor**");
		Queue<String> q5 = new Queue<String>(q);
		System.out.println("Should print C D A A B C D A: " + q5);
		Queue<String> q6 = new Queue<String>(q4);
		System.out.println("Should print nothing: " + q6);

		System.out.println("\n**Testing for Deep Copy**");
		System.out.print("Should print C D A A B C D A: " + q);
		q5.enqueue("E");
		q5.enqueue("F");
		System.out.print("Should print C D A A B C D A E F: " + q5);

	}
}

/* TESTING OUTPUT
**Testing enqueue()**
Should print 1: 1

Should print 1 2: 1
2

Should print 1 2 3: 1
2
3


**Testing dequeue()**
Should print 2 3: 2
3


**Testing isEmpty()**
Should print true: true
Should print false: false

**Testing append()**
Should print 2 3 A B C D: 2
3
A
B
C
D


**Testing getFront()**
Should print A: A

**Testing getSize()**
Should print 6: 6

**Testing Equals**
Should print true: true
Should print false: false
Should print true: true

**Testing Copy Constructor**
Should print A B C D: A
B
C
D


**Testing for Deep Copy**
Should print A B C D E F: A
B
C
D
E
F
Should print A B C D: A
B
C
D

**Extra Methods for Testing**

**Testing Enqueue**
Should print B C D A: B
C
D
A

Should print A B C D A: A
B
C
D
A


**Testing Dequeue**
Should print C D A: C
D
A

Should print error message
java.util.NoSuchElementException: dequeue: Cannot dequeue from empty queue!

**Testing isEmpty**
Should print true: true
Should print false: false

**Testing append**
Should print C D A: C
D
A

Should print C D A A B C D A: C
D
A
A
B
C
D
A


**Testing getFront**
Should print error message
java.util.NoSuchElementException: dequeue: Cannot dequeue from empty queue!
Should print C: C

**Testing getSize**
Should print 0: 0
Should print 8: 8

**Testing Equals**
Should print true: true
Should print false: false

**Testing Copy Constructor**
Should print C D A A B C D A: C
D
A
A
B
C
D
A

Should print nothing: 

**Testing for Deep Copy**
Should print C D A A B C D A: C
D
A
A
B
C
D
A
Should print C D A A B C D A E F: C
D
A
A
B
C
D
A
E
F

*/