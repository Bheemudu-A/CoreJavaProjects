package urlproject;

import java.util.Scanner;

public class URLShortenerApp {
	

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Shorten URL\n2. Retrieve Original URL\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longURL = scanner.nextLine();
                    System.out.println("Shortened URL: " + urlShortener.shortenURL(longURL));
                    break;
                case 2:
                    System.out.print("Enter the short URL: ");
                    String shortURL = scanner.nextLine();
                    System.out.println("Original URL: " + urlShortener.getOriginalURL(shortURL));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }


}
