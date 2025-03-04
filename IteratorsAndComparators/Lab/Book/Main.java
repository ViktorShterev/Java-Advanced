package IteratorsAndComparators.Lab.Book;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Matrix", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        Library library = new Library();
        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);

        List<Book> books = library.getBooks();

        books.stream().sorted(new BookComparator())
                .forEach(System.out::println);

        Collections.sort(books);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
