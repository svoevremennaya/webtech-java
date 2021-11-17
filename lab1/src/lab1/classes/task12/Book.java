package lab1.classes.task12;

import java.util.Comparator;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private Integer price;
    private static int edition;
    private Integer isbn;

    String getTitle() {return title;}
    String getAuthor() {return author;}
    Integer getPrice() {return price;}

    Integer getIsbn() {
        return isbn;
    }

    public Book() {}
    public Book(String title, String author, int price, Integer isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (null == obj) { return false; }
        if (getClass() != obj.getClass()) { return false; }

        Book book = (Book)obj;
        if (null == title) { return (title == book.title); }
        else {
            if (!title.equals(book.title)) { return false; }
        }

        if (null == author) { return (author == book.author); }
        else {
            if (!author.equals(book.author)) { return false; }
        }

        if (price != book.price) {return false; }
        if (isbn != book.isbn) {return false; }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 * price + ((null == title) ? 0 : title.hashCode()) + ((null == author ? 0 : author.hashCode())) + 31 * isbn);
    }

    @Override
    public String toString() {
        return this.title + this.author;
    }

    @Override
    public Object clone() {
        Book newBook = new Book();
        newBook.title = this.title;
        newBook.author = this.author;
        newBook.price = this.price;
        return newBook;
    }

    @Override
    public int compareTo(Book o) {
        return isbn.compareTo(o.getIsbn());
    }
}
