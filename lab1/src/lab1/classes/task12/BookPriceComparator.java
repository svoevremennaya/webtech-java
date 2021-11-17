package lab1.classes.task12;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
