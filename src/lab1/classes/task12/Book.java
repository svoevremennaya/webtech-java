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
        if (obj instanceof Book) {
            return this.title == ((Book) obj).title && this.author == ((Book) obj).author && this.price == ((Book) obj).price;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode() + this.author.hashCode() + this.price;
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
