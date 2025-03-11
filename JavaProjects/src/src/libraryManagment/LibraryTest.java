package src.libraryManagment;

import org.junit.*;
import java.io.File;
import java.util.List;
import static org.junit.Assert.*;

public class LibraryTest {

    private static Library library;

    @BeforeClass
    public static void setup() {
        library = new Library(); // Create a new library instance before tests
    }

    @Test
    public void testAddBook() {
        Book book = new Book(1, "Java Programming", "Bheem", false);
        library.addBook(book);

        
        // Verify the book is added
        List<Book> books = library.books;
        System.out.println("books size : "+books.size());
        assertEquals(7, books.size());
        assertEquals("Java Programming", books.get(0).getTitle());
    }

    @Test
    public void testSearchBook() {
        library.searchBook("Java Programming"); // Should find the book
    }

    @Test
    public void testSearchBookNotFound() {
        library.searchBook("Unknown Book"); // Should print "No books found"
    }

    @Test
    public void testDisplayBooks() {
        library.displayBooks(); // Should print at least one book
    }

    @Test
    public void testBorrowBook() {
        library.borrowBooks(123);
        assertTrue(library.books.get(0).isBorrowed());
    }

    @Test
    public void testBorrowBookNotFound() {
        library.borrowBooks(999); // Should print "Book not found"
    }

    @Test
    public void testBorrowBookAlreadyBorrowed() {
        library.borrowBooks(1234567); // Should print "Sorry! book is not available"
    }

    @Test
    public void testReturnBook() {
        library.returnBooks(1);
        assertFalse(library.books.get(0).isBorrowed());
    }

    @Test
    public void testReturnBookNotBorrowed() {
        library.returnBooks(1); // Should print "This book was not borrowed"
    }

    @Test
    public void testFilePersistence() {
        // Ensure file is created
        File file = new File("library_data.ser");
        assertTrue(file.exists());

        // Reload the library from file
        Library newLibrary = new Library();
        assertFalse(newLibrary.books.isEmpty());
    }

    @AfterClass
    public static void cleanup() {
        // Delete test file after tests
        File file = new File("library_data.ser");
        if (file.exists()) {
            file.delete();
        }
    }
}
