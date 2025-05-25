public class Thesis implements LibraryResource {
    private final String title;
    private final String author;
    private final String degree;
    private final int year;
    private boolean available;
    
    public Thesis(String title, String author, String degree, int year) {
        this.title = title;
        this.author = author;
        this.degree = degree;
        this.year = year;
        this.available = true;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getResourceType() {
        return "Thesis";
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Thesis '" + title + "' is already borrowed");
        }
        available = false;
    }
    
    @Override
    public void returnResource() {
        if (available) {
            throw new IllegalStateException("Thesis '" + title + "' is not currently borrowed");
        }
        available = true;
    }
    
    @Override
    public String getDetails() {
        return String.format("Thesis: %s by %s (%s, %d) - %s", 
                           title, author, degree, year, available ? "Available" : "Borrowed");
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getDegree() {
        return degree;
    }
    
    public int getYear() {
        return year;
    }
}