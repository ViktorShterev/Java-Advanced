package IteratorsAndComparators.Lab.Book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.title + ", " + this.year + ", " + this.authors);
        return sb.toString();
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());

//        if (authors.length == 0) {
//            this.authors = new ArrayList<>();
//        } else {
//            this.authors = new ArrayList<>(Arrays.asList(authors));
//        }
    }

    @Override
    public int compareTo(Book other) {
        int compared = this.title.compareTo(other.title);

        if (compared == 0) {
            compared = Integer.compare(this.year, other.year);
        }
        return compared;
    }
}
