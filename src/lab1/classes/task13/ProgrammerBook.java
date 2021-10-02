package lab1.classes.task13;

import lab1.classes.task12.Book;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProgrammerBook) {
            return this.language == ((ProgrammerBook)obj).language && this.level == ((ProgrammerBook)obj).level;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.language.hashCode();
    }

    @Override
    public String toString() {
        return this.language;
    }
}
