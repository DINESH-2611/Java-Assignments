package abstractclassandmethods;

import java.util.Scanner;
import java.util.SplittableRandom;

public class Book {
    Scanner scanner = new Scanner(System.in);
    private String ISBN;
    private String title;
    private String author;
    private String publication;
    private int volume;
    private int availableCount;
    private String edition;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Book() {

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Book(String ISBN, String title, String author, String publication, int volume, int availableCount, String edition) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.volume = volume;
        this.availableCount = availableCount;
        this.edition = edition;
    }


    @Override
    public String toString() {
        return "Book-->" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", volume=" + volume +
                ", availableCount=" + availableCount +
                ", edition='" + edition + '\''
                ;
    }

    public void selectUpdate(Book book) {
        while (true) {
            System.out.println("1.Update Edition\n2.Update Volume\n3.Update Available count\n4.Exit\nEnter the choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    updateEdition(book);
                    break;
                case "2":
                    updateVolume(book);
                    break;
                case "3":
                    updateAvailabeCount(book);
                    break;
                case "4":
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
                    selectUpdate(book);
                    break;
            }
            if (choice.equals("4"))
                break;
        }
    }

    private void updateVolume(Book book) {
        System.out.println("Enter the volume to update");
        book.setVolume(scanner.nextInt());
        scanner.nextLine();
        System.out.println(book);
        System.out.println("Book volume updated");
    }

    private void updateEdition(Book book) {
        System.out.println("Enter the edition to update");
        book.setEdition(scanner.nextLine());
        System.out.println(book);
        System.out.println("Book edition updated");
    }

    private void updateAvailabeCount(Book book) {
        System.out.println("Enter the avilable count to update");
        book.setAvailableCount(scanner.nextInt());
        scanner.nextLine();
        System.out.println(book);
        System.out.println("Book available count updated");
    }
}

class Credentials {
    private String userName = "lion";
    private String password = "lion123";

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

class BookDriver {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Book book = new Book("ISBN-0-123-98765-1", "Java", "James Gosling", "1/4/24", 1, 5, "Java SE");
        System.out.println(book);
        new BookDriver().chooseOption(book);
    }

    private void chooseOption(Book book) {
        System.out.println("Do you want to update book detials\nYes\nNo");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            if (isUser())
                book.selectUpdate(book);
            else
                System.out.println("Invalid UserName or password");
        } else if (choice.equalsIgnoreCase("no"))
            System.out.println("Thank you");
        else
            chooseOption(book);
    }

    private boolean isUser() {
        Credentials credentials = new Credentials();
        System.out.println("Enter the username");
        String userName = scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        return userName.equals(credentials.getUserName()) && password.equals(credentials.getPassword());
    }
}