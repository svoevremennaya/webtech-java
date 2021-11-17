package lab1.classes.task12;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        BookTitleComparator bcompTitle = new BookTitleComparator();
        TreeSet<Book> booksTitle = new TreeSet<>(bcompTitle);
        booksTitle.add(new Book("war and Piece", "Leo Tolstoy", 19, 1));
        booksTitle.add(new Book("we", "Will Die", 45, 2));
        booksTitle.add(new Book("qwer", "asdf", 4, 3));
        booksTitle.add(new Book("qwer", "a number", 33, 4));
        System.out.println("Sorted by title:");
        for (Book obj : booksTitle) {
            System.out.println(obj.getTitle());
        }

        Comparator<Book> bcompTitleAuthor = new BookTitleComparator().thenComparing(new BookAuthorComparator());
        TreeSet<Book> booksTitleAuthor = new TreeSet<Book>(bcompTitleAuthor);
        booksTitleAuthor.add(new Book("war and Piece", "Leo Tolstoy", 19, 1));
        booksTitleAuthor.add(new Book("we", "Will Die", 45, 2));
        booksTitleAuthor.add(new Book("qwer", "asdf", 4, 3));
        booksTitleAuthor.add(new Book("qwer", "a number", 33, 4));
        System.out.println("Sorted by title and author:");
        for (Book obj : booksTitleAuthor) {
            System.out.println(obj.getTitle() + " " + obj.getAuthor());
        }

        Comparator<Book> bcompAuthorTitle = new BookAuthorComparator().thenComparing(new BookTitleComparator());
        TreeSet<Book> booksAuthorTitle = new TreeSet<Book>(bcompAuthorTitle);
        booksAuthorTitle.add(new Book("war and Piece", "Leo Tolstoy", 19, 1));
        booksAuthorTitle.add(new Book("we", "Will Die", 45, 2));
        booksAuthorTitle.add(new Book("qwer", "asdf", 4, 3));
        booksAuthorTitle.add(new Book("qwer", "a number", 33, 4));
        System.out.println("Sorted by author and title:");
        for (Book obj : booksAuthorTitle) {
            System.out.println(obj.getTitle() + " " + obj.getAuthor());
        }

        Comparator<Book> bcompAuthorTitlePrice = new BookAuthorComparator().thenComparing(new BookTitleComparator().thenComparing(new BookPriceComparator()));
        TreeSet<Book> booksAuthorTitlePrice = new TreeSet<Book>(bcompAuthorTitlePrice);
        booksAuthorTitlePrice.add(new Book("war and Piece", "Leo Tolstoy", 19, 1));
        booksAuthorTitlePrice.add(new Book("we", "Will Die", 45, 2));
        booksAuthorTitlePrice.add(new Book("qwer", "asdf", 4, 3));
        booksAuthorTitlePrice.add(new Book("qwer", "a number", 33, 4));
        booksAuthorTitlePrice.add(new Book("qwer", "a number", 37, 5));
        System.out.println("Sorted by author and title and price:");
        for (Book obj : booksAuthorTitlePrice) {
            System.out.println(obj.getTitle() + " " + obj.getAuthor() + " " + obj.getPrice());
        }
    }
}
