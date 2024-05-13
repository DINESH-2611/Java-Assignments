package Collections;

import java.util.HashMap;
import java.util.Map;

public class LibraryHashmap {
    public static void main(String[] args) {
        Map<String, String> bookAuthors = new HashMap<>();

        bookAuthors.put("The Great Gatsby", "F. Scott Fitzgerald");
        bookAuthors.put("To Kill a Mockingbird", "Harper Lee");
        bookAuthors.put("1984", "George Orwell");
        bookAuthors.put("The Catcher in the Rye", "J.D. Salinger");

        String authorOf1984 = bookAuthors.get("1984");
        System.out.println("Author of '1984': " + authorOf1984);

        System.out.println("Books and Authors:");
        for (Map.Entry<String, String> entry : bookAuthors.entrySet()) {
            System.out.println("Title: " + entry.getKey() + ", Author: " + entry.getValue());
        }
    }
}
