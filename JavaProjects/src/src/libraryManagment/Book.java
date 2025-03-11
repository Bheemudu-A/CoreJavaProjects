package src.libraryManagment;

import java.io.Serializable;

public class Book implements Serializable{
	
	private int id;
	private String title;
	private String author;
	private boolean isBorrowed;
	
	public Book(int id, String title, String author, boolean isBorrowed) {
		this.id=id;
		this.title=title;
		this.author=author;
		this.isBorrowed=isBorrowed;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}
	
	
	public void borrowBook() {
		isBorrowed = true;
	}
	
	public void returnBook() {
		isBorrowed = false;
	}
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isBorrowed=" + isBorrowed + "]";
	}

}
