package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String publication;

    public Book(String ISBN, String title, String author, String publication) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publication = publication;
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                '}';
    }
}
class BookDriver{
    void init(ArrayList<Book> bookList,Scanner sc){
        while (true) {
            System.out.println("1.Add Book\n2.Update Book\n3.Delete Book\n4.Show Books\n5.Exit\nEnter the choice");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addBook(bookList, sc);
                    break;
                case "2":
                    updateBook(bookList, sc);
                    break;
                case "3":
                    deleteBook(bookList, sc);
                    break;
                case "4":
                    showBooks(bookList);
                    break;
                case "5":break;
                default:showAlert("Invalid choice,Enter valid choice");
                    init(bookList,sc);
                    return;
            }
            if(choice.equals("5")) {
                showAlert("Thank You");
                break;
            }

        }
    }

    private void deleteBook(ArrayList<Book> bookList, Scanner sc) {
        if(bookList.size()==0){
            showAlert("Book list is empty");
            return;
        }
        showBooks(bookList);
        System.out.println("Enter ISBN");
        String ISBN=sc.nextLine();
        Book book=getBook(ISBN,bookList);
        if(book==null){
            showAlert("No Book exist");
            return;
        }
        bookList.remove(book);
        showBooks(bookList);
        showAlert("Book Removed successfully");
    }

    void addBook(ArrayList<Book> bookList, Scanner sc) {
        System.out.println("Enter no of book to be added");
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        if (n <= 0) {
            System.out.println("No Books added");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Enter ISBN");
            String ISBN = sc.nextLine();
            Book book = getBook(ISBN, bookList);
            if (book != null) {
                showAlert("Book ISBN must be unique");
                return;
            }
            System.out.println("Enter the Title of the book");
            String title = sc.nextLine();
            System.out.println("Enter the author of the book");
            String author = sc.nextLine();
            System.out.println("Enter the publication of the book");
            String publication = sc.nextLine();
            Book book1 = new Book(ISBN, title, author, publication);
            bookList.add(book1);
        }
        showBooks(bookList);
        System.out.println("\t\t\t"+n + " Books added successfully");
    }

    void updateBook(ArrayList<Book> bookList, Scanner sc) {
        if(bookList.size()==0){
            showAlert("Book list is empty");
            return;
        }
        showBooks(bookList);
        System.out.println("Enter book ISBN");
        String ISBN = sc.nextLine();
        Book book = getBook(ISBN, bookList);
        if (book == null) {
            showAlert("No book exist");
            return;
        }
        System.out.println("1.Update Book Title\n2.Update Author name\n3.Update Publication\nEnter the choice");
        String choice = sc.nextLine();
        switch (choice) {
            case "1": {
                System.out.println("Enter book Title to update");
                book.setTitle(sc.nextLine());
                showBooks(bookList);
                showAlert("Book title updated successfully");
                break;
            }
            case "2": {
                System.out.println("Enter Author name to update");
                book.setAuthor(sc.nextLine());
                showBooks(bookList);
                showAlert("Author name updated successfully");
                break;
            }
            case "3": {
                System.out.println("Enter publication to update");
                book.setPublication(sc.nextLine());
                showBooks(bookList);
                showAlert("Book publication  updated successfully");
                break;
            }
            default: {
                showAlert("Invalid choice,Enter valid choice");
            }
        }
    }

    private void showAlert(String alert) {
        System.out.println("\t\t\t"+alert);
    }

    private Book getBook(String isbn, ArrayList<Book> bookList) {
        for (Book book : bookList) {
            if (isbn.equals(book.getISBN()))
                return book;
        }
        return null;
    }

    void showBooks(ArrayList<Book> bookList) {
        if(bookList.size()==0){
            showAlert("Book list is empty");
            return;
        }
        System.out.printf("%-25s %-15s %-20s %-15s", "ISBN", "Title", "Author", "Publication");
        System.out.println();
        for (Book book : bookList) {
            System.out.printf("%-25s %-15s %-20s %-15s", book.getISBN(), book.getTitle(), book.getAuthor(), book.getPublication());
            System.out.println();
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        new BookDriver().init(bookList,sc);
    }
}

