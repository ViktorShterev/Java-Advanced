package IteratorsAndComparators.Lab.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book get(int index) {
       return this.books.get(index);
    }

    public int size() {
        return this.books.size();
    }

    public List<Book> getBooks() {
        return this.books;
    }

    private class LibIterator implements Iterator<Book> {
        private int begin = 0;

        @Override
        public boolean hasNext() {
            return begin < books.size();
        }

        @Override
        public Book next() {
            Book nextBook = books.get(begin);
            begin++;
            return nextBook;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
