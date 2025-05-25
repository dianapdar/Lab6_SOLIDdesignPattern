import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String studentId;
    private final ResourceRepository repository;
    private final List<LibraryResource> borrowedResources;
    
    public Student(String name, String studentId, ResourceRepository repository) {
        this.name = name;
        this.studentId = studentId;
        this.repository = repository;
        this.borrowedResources = new ArrayList<>();
    }
    
    public boolean borrowResource(String title) {
        LibraryResource resource = repository.findByTitle(title);
        
        if (resource == null) {
            System.out.println("Resource '" + title + "' not found");
            return false;
        }
        
        if (!resource.isAvailable()) {
            System.out.println("Resource '" + title + "' is not available");
            return false;
        }
        
        try {
            resource.borrow();
            borrowedResources.add(resource);
            System.out.println(name + " borrowed: " + resource.getDetails());
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean returnResource(String title) {
        LibraryResource resourceToReturn = borrowedResources.stream()
                .filter(resource -> resource.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        
        if (resourceToReturn == null) {
            System.out.println("Resource '" + title + "' is not borrowed by you");
            return false;
        }
        
        try {
            resourceToReturn.returnResource();
            borrowedResources.remove(resourceToReturn);
            System.out.println(name + " returned: " + resourceToReturn.getDetails());
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public List<LibraryResource> getBorrowedResources() {
        return new ArrayList<>(borrowedResources);
    }
    
    public void displayBorrowedResources() {
        System.out.println(name + "'s Borrowed Resources:");
        if (borrowedResources.isEmpty()) {
            System.out.println("No resources borrowed");
        } else {
            for (int i = 0; i < borrowedResources.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedResources.get(i).getDetails());
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String getStudentId() {
        return studentId;
    }
}