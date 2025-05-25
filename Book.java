public class Book implements LibraryResource {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean available;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getResourceType() {
        return "Book";
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Book '" + title + "' is already borrowed");
        }
        available = false;
    }
    
    @Override
    public void returnResource() {
        if (available) {
            throw new IllegalStateException("Book '" + title + "' is not currently borrowed");
        }
        available = true;
    }
    
    @Override
    public String getDetails() {
        return String.format("Book: %s by %s (ISBN: %s) - %s", 
                           title, author, isbn, available ? "Available" : "Borrowed");
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
}