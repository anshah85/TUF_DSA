package Books;

public class BookSizeFilter implements BookFilter {
    private BookSize desiredBookSize;

    public BookSizeFilter(BookSize bookSizeIn) {
        desiredBookSize = bookSizeIn;
    }

    @Override
    public boolean apply(Book book) {
        int minPages = 0;
        int maxPages = 0;

        switch (desiredBookSize) {
            case BIG:
                minPages = 0;
                maxPages = 100;
                break;
            case MEDIUM:
                minPages = 101;
                maxPages = 500;
                break;
            case SMALL:
                minPages = 501;
                maxPages = 1000;
                break;
        }
        return book.pageCount >= minPages && book.pageCount < maxPages;
    }
}
