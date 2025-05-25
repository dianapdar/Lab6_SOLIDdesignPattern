import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Journal implements LibraryResource {
    private final String title;
    private final String issueNumber;
    private final LocalDate publicationDate;
    private boolean available;
    
    public Journal(String title, String issueNumber, LocalDate publicationDate) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.available = true;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getResourceType() {
        return "Journal";
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Journal '" + title + "' is already borrowed");
        }
        available = false;
    }
    
    @Override
    public void returnResource() {
        if (available) {
            throw new IllegalStateException("Journal '" + title + "' is not currently borrowed");
        }
        available = true;
    }
    
    @Override
    public String getDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return String.format("Journal: %s (Issue: %s, Date: %s) - %s", 
                           title, issueNumber, publicationDate.format(formatter), 
                           available ? "Available" : "Borrowed");
    }
    
    public String getIssueNumber() {
        return issueNumber;
    }
    
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}