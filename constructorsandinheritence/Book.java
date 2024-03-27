package constructorsandinheritence;

import java.util.Scanner;

public class Book {
    Scanner scanner=new Scanner(System.in);
    private String ISBN;
    private String title;
    private String author;
    private String publication;
    Book[] books;

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
    public Book(){

    }


    public Book(String ISBN, String title, String author, String publication) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publication = publication;
    }

    public static void main(String[] args) {
        Book book=new Book();
        book.addBook();
        book.printBook();

    }

    private void printBook() {
        System.out.printf("%-25s %-20s %-20s %-20s","Book ISBN","Title","Author","Pulblication");
        for(Book book:books){
            System.out.printf("%-25s %-20s %-20s %-20s",book.getISBN(),book.getTitle(),book.getAuthor(),book.getPublication());
        }
    }

    public void addBook(){
        System.out.println("Enter no of books need to be add");
        int n=scanner.nextInt();
        scanner.nextLine();
        books=new Book[n];
        for (int i = 0; i <n ; i++) {
            System.out.println("Enter ISBN");
            String ISBN=scanner.nextLine();
            System.out.println("Enter the title of the book");
            String title=scanner.nextLine();
            System.out.println("Enter author name");
            String author=scanner.nextLine();
            System.out.println("Enter publication");
            String publication=scanner.nextLine();
            books[i]=new Book(ISBN,title,author,publication);
        }
    }
}
