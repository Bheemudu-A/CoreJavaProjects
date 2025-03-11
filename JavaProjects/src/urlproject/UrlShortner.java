package urlproject;

/*
*  5. URL Shortener (Like Bit.ly)
	💡 Why?: Helps in algorithmic thinking, hashing, and database integration.
	
	Requirements:
	Create a system that generates short URLs for long URLs.
	Store URL mappings using Java’s HashMap (or DB for persistence).
	Implement custom URL generation logic using Base62 encoding.
	Implement a CLI or GUI for user input.
	Tech Used:
	Java HashMap for in-memory storage
	Base62 Encoding for URL shortening
	File Handling or DB for persistence
 */
import java.util.*;
import java.nio.file.*;
import java.io.*;

class URLShortener {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = CHARACTERS.length();
    private static final String STORAGE_FILE = "url_mappings.txt";
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private int counter;
    
    public URLShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
        counter = 100000;
        loadMappings();
    }
    
    private String encode(int num) {
        StringBuilder sb = new StringBuilder();
        System.out.println("num: "+num);
        while (num > 0) {
            sb.append(CHARACTERS.charAt(num % BASE));
            System.out.println("SB: "+num%BASE+" "+sb);
            num /= BASE;
        }
        return sb.reverse().toString();
    }
    
    public String shortenURL(String longURL) {
        if (longToShortMap.containsKey(longURL)) {
            return longToShortMap.get(longURL);
        }
        String shortURL = encode(counter++);
        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);
        saveMappings();
        return shortURL;
    }
    
    public String getOriginalURL(String shortURL) {
        return shortToLongMap.getOrDefault(shortURL, "URL not found");
    }
    
    private void saveMappings() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(STORAGE_FILE))) {
            for (Map.Entry<String, String> entry : shortToLongMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving mappings: " + e.getMessage());
        }
    }
    
    private void loadMappings() {
        try {
            if (!Files.exists(Paths.get(STORAGE_FILE))) return;
            for (String line : Files.readAllLines(Paths.get(STORAGE_FILE))) {
                String[] parts = line.split(" ", 2);
                shortToLongMap.put(parts[0], parts[1]);
                longToShortMap.put(parts[1], parts[0]);
            }
        } catch (IOException e) {
            System.out.println("Error loading mappings: " + e.getMessage());
        }
    }
}

