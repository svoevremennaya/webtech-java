package lab1.classes.task13;

import lab1.classes.task12.Book;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (null == obj) { return false; }
        if (getClass() != obj.getClass()) { return false; }

        ProgrammerBook prBook = (ProgrammerBook)obj;
        if (!super.equals(prBook)) { return false; }

        if (null == language) { return (language == prBook.language); }
        else {
            if (!language.equals(prBook.language)) { return false; }
        }
        if (level != prBook.level) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 * level + ((null == language) ? 0 : language.hashCode()));
    }

    @Override
    public String toString() {
        return this.language;
    }
}
