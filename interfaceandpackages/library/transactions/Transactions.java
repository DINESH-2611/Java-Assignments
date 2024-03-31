package interfaceandpackages.library.transactions;

import interfaceandpackages.library.books.Books;
import interfaceandpackages.library.members.Members;

import java.time.LocalDate;

public class Transactions {
    private Books books;
    private Members members;
    private LocalDate isuuedDate;
    private LocalDate returnDate;
    public Transactions(Books books, Members members, LocalDate isuuedDate, LocalDate returnDate) {
        this.books = books;
        this.members = members;
        this.isuuedDate = isuuedDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transactions-->" +
                "books=" + books +
                ", members=" + members +
                ", isuuedDate=" + isuuedDate +
                ", returnDate=" + returnDate
                ;
    }
}
