package interfaceandpackages.library;

import interfaceandpackages.library.books.Books;
import interfaceandpackages.library.members.Members;
import interfaceandpackages.library.transactions.Transactions;

import java.time.LocalDate;

public class LibraryManagement {
    public static void main(String[] args) {
        new LibraryManagement().init();
    }

    private void init() {
        Books books=new Books("ISBN-978-0-545-01022-1","Java","James Gosling");
        Members members=new Members("Ram","ram@gmail.com",9876543211l);
        Transactions transactions=new Transactions(books,members, LocalDate.now(),LocalDate.now().plusDays(10));
        System.out.println(books);
        System.out.println(members);
        System.out.println(transactions);
    }
}
