import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Newspaper implements LibraryResource {
    private final String title;
    private final String publisher;
    private final LocalDate publicationDate;
    private boolean available;
    
    public Newspaper(String title, String publisher, LocalDate publicationDate) {
        this.title = title;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.available = true;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getResourceType() {
        return "Newspaper";
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Newspaper '" + title + "' is already borrowed");
        }
        available = false;
    }
    
    @Override
    public void returnResource() {
        if (available) {
            throw new IllegalStateException("Newspaper '" + title + "' is not currently borrowed");
        }
        available = true;
    }
    
    @Override
    public String getDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return String.format("Newspaper: %s by %s (%s) - %s", 
                           title, publisher, publicationDate.format(formatter), 
                           available ? "Available" : "Borrowed");
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}