
/**
 * MovieDatabase.java
 * @author Yi Jou (Ruby) Liao
 * @author Alvin Nguyen
 * CIS 22C, Lab 7
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MovieDatabase {
	private final int NUM_MOVIES = 26;
	Hash<Movie> ht = new Hash<>(NUM_MOVIES * 2);
	BST<Movie> bst = new BST<>();
	static Scanner in = new Scanner(System.in).useDelimiter(";|\r?\n|\r");

	public static void main(String[] args) throws IOException {

		String title;
		String director;
		int year;
		double grossMillions;
		File file = new File("movies.txt");
		Scanner input = new Scanner(file);

		MovieDatabase md = new MovieDatabase();

		while (input.hasNext()) {
			title = input.nextLine();
			director = input.nextLine();
			year = Integer.parseInt(input.nextLine());
			grossMillions = Double.parseDouble(input.nextLine());
			if (input.hasNext()) {
				input.nextLine();
			}

			Movie m = new Movie(title, director, year, grossMillions);
			md.ht.insert(m);
			md.bst.insert(m);
		}

		System.out.println("Welcome to the Bond Movie Database!\n\n");
		boolean loop = true;
		do {
			System.out.print("Please select from one of the following options:\n" + "\n" + "A. Add a Movie\n"
					+ "D. Display all Movies\n" + "R. Remove a Movie\n" + "S. Search for a Movie\n" + "X. Exit\n" + "\n"
					+ "Enter your choice: ");
			String choice = in.next();

			switch (choice) {
				case "A": md.add();
					break;
				case "D":
					md.display();
					break;
				case "R": md.remove();
					break;
				case "S": md.search();
					break;
				case "X": loop = false;
					break;
				default:
					System.out.println("\nInvalid Selection!\n");
					break;
			}
		} while (loop);
		
		System.out.println("\nGoodbye!");
		input.close();
	}
	
	public void add() {
		System.out.println("\nAdding a movie!\n");
		System.out.print("Enter the title: ");
		String title = in.next();
		System.out.print("Enter the director: ");
		String director = in.next();
		System.out.print("Enter the year: ");
		int year = in.nextInt();
		System.out.print("Enter the gross in millions: $");
		double gross = in.nextDouble();
		
		Movie m = new Movie(title, director, year, gross);
		bst.insert(m);
		ht.insert(m);
		System.out.println("\n" + title + " was added!\n");
	}

	public void display() {
		boolean invalid = false;
		do {
			System.out.print("\nPlease select one of the following options: \n\n" + "S. Sorted\n" + "U. Unsorted\n\n"
					+ "Enter your choice: ");
			String choice = in.next();
			if (choice.equals("S")) {
				System.out.println("\nDisplaying Movies: \n");
				bst.inOrderPrint();
			} else if (choice.equals("U")) {
				System.out.println("\nDisplaying Movies: \n");
				System.out.println(ht);
			} else {
				System.out.println("\nInvalid Selection!\n");
				invalid = true;
			}
		} while (invalid);
	}
	
	public void remove() {
		System.out.println("\nRemoving a movie!\n");
		System.out.print("Enter the title: ");
		String title = in.next();
		System.out.print("Enter the director: ");
		String director = in.next();
		Movie m = new Movie(title, director, 0, 0);
		if(ht.search(m) != -1) {
			bst.remove(m);
			ht.remove(m);
			System.out.println("\n" + director +"'s " + title + " was removed!\n");
		} else {
			System.out.println("\nI cannot find " + director +"'s " + title + " in the database.\n");
		}	
	}
	public void search() {
		System.out.println("\nSearching for a movie!\n");
		System.out.print("Enter the title: ");
		String title = in.next();
		System.out.print("Enter the director: ");
		String director = in.next();
		Movie m = new Movie(title, director, 0, 0);
		if(ht.search(m) != -1) {
			System.out.println("\n" + director +"'s " + title + " is in the database!\n");
		} else {
			System.out.println("\n" + director +"'s " + title + " is not in the database.\n");
		}
	}
}