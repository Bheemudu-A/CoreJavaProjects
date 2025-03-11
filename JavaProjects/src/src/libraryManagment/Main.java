package src.libraryManagment;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n📚 LIBRARY MANAGEMENT SYSTEM 📚");
            System.out.println("1️ Add a Book");
            System.out.println("2️ Display All Books");
            System.out.println("3️ Search a Book");
            System.out.println("4️ Borrow a Book");
            System.out.println("5️ Return a Book");
            System.out.println("6️ Exit");
            System.out.print("👉 Enter your choice: ");
			
            int choice = scanner.nextInt();
            
            switch(choice) {
            	
            	case 1:
            		System.out.println("Enter book title");
            		String title = scanner.next();
            		System.out.println("Enter Author name");
            		String author = scanner.next();
            		System.out.println("Enter Book Id");
            		int id = scanner.nextInt();
            		scanner.nextLine();
            		
            		library.addBook(new Book(id, title, author, false));
            		break;
            		
            	case 2:
            		library.displayBooks();
            		break;
            		
            	case 3:
            		System.out.println("Enter book author");
            		String Bookauthor = scanner.next();
            		library.searchBook(Bookauthor);
            		break;
            	case 4:
            		System.out.println("Enter book Id to borrow");
            		
            		int bookId = scanner.nextInt();
            		library.borrowBooks(bookId);
            		break;
            	case 5:
            		System.out.println("Enter book Id to return");
            		int bookid = scanner.nextInt();
            		library.returnBooks(bookid);
            		break;
            	case 6:
            		System.out.println("Exiting Thank you for choosing the Library System");
            		scanner.close();
            		return;
            		
            	default:
            		System.out.println("Invalid choice. please try again");
            }
			
		}
		
	}

}
