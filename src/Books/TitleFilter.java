package Books;

public class TitleFilter implements BookFilter {
    private String title;

    public TitleFilter(String titleIn) {
        title = titleIn;
    }

    @Override
    public boolean apply(Book book) {
        return book.title.contains(title);
    }
}
