package src.libraryManagment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
	
	
	protected List<Book> books;
	private static final String FILE_NAME = "library_data.ser";
	
	public Library() {
		books = new ArrayList<>();
		loadBooks();
	}
	
	
	private void loadBooks() {
		
		File file = new File(FILE_NAME);
		
		if(!file.exists())return;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			
			books = (List<Book>) ois.readObject();
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}


	public void searchBook(String keyword) {
		
	List<Book> results	= books.stream().filter(book -> book.getTitle().equalsIgnoreCase(keyword)
				|| book.getAuthor().equalsIgnoreCase(keyword)
				).collect(Collectors.toList());
			
		if(results.isEmpty()) {
			System.out.println("No books found with given keyword: "+keyword);
			return; 
		}else {
			System.out.println("books found with given keyword are:"+results);
		}
	}
	
	public void addBook(Book book) {
		
		books.add(book);
		saveBooks();
		System.out.println("Book added successFully to Library");
	}
	
	
	public void displayBooks() {		
		if(books.isEmpty()) {
			System.out.println("No books available in library");
			return;
		}
		books.forEach(System.out::print);	
	}
	
	
	public void returnBooks(int bookId) {	
		for(Book book : books) {
			
			if(book.getId()==bookId) {
				if(book.isBorrowed()) {
					book.returnBook();
					saveBooks();
					System.out.println("You have returned the book: "+book.getTitle());
				}else {
					System.out.println("This book was not borrowed");
				}
			}
			return;
		}
		System.out.println("book not found with given id");
	}
	
	
	public void borrowBooks(int bookId) {
		
		for(Book book : books) {
			if(book.getId()==bookId) {
				if(!book.isBorrowed()) {
					book.borrowBook();
					saveBooks();
					System.out.println("you are borrowed the book: "+book.getTitle());
				}else {
					System.out.println("Sorry! book is not available");
				}
				
			}
		}
	}
	

	public void saveBooks() {		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(books);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
