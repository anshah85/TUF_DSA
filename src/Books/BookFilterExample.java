package Books;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookFilterExample {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Programming", "Java author", 50));
        books.add(new Book("C++ Programming", "C++ author", 150));
        books.add(new Book("Python Programming", "Python Author", 502));

        List<BookFilter> filters = new ArrayList<>();
        filters.add(new TitleFilter("Java"));
        filters.add(new BookSizeFilter(BookSize.BIG));

        Set<Book> filteredBooks = filterBooks(books, filters);

        for (Book book : filteredBooks) {
            System.out.println("Book: " + book.title + " Author: " + book.author + " pages: " + book.pageCount);
        }
    }

    public static Set<Book> filterBooks(List<Book> books, List<BookFilter> filters) {
        Set<Book> filteredBooks = new HashSet<>();

        for (Book book : books) {
            if (bookPassesFilters(book, filters)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public static boolean bookPassesFilters(Book book, List<BookFilter> filters) {
        for (BookFilter filter : filters) {
            if (!filter.apply(book)) {
                return false;
            }
        }
        return true;
    }
}
