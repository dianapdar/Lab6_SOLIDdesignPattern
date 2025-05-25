import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryRepository implements ResourceRepository {
    private final List<LibraryResource> resources;
    
    public LibraryRepository() {
        this.resources = new ArrayList<>();
    }
    
    @Override
    public LibraryResource findByTitle(String title) {
        return resources.stream()
                .filter(resource -> resource.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<LibraryResource> getAllResources() {
        return new ArrayList<>(resources);
    }
    
    @Override
    public void addResource(LibraryResource resource) {
        if (resource != null) {
            resources.add(resource);
        }
    }
    
    @Override
    public List<LibraryResource> getResourcesByType(String resourceType) {
        return resources.stream()
                .filter(resource -> resource.getResourceType().equalsIgnoreCase(resourceType))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<LibraryResource> getAvailableResources() {
        return resources.stream()
                .filter(LibraryResource::isAvailable)
                .collect(Collectors.toList());
    }
    
    // Additional utility methods for testing
    public int getTotalResourceCount() {
        return resources.size();
    }
    
    public int getAvailableResourceCount() {
        return (int) resources.stream()
                .filter(LibraryResource::isAvailable)
                .count();
    }
    
    public void displayAllResources() {
        System.out.println("All Library Resources:");
        if (resources.isEmpty()) {
            System.out.println("No resources available");
        } else {
            for (int i = 0; i < resources.size(); i++) {
                System.out.println((i + 1) + ". " + resources.get(i).getDetails());
            }
        }
    }
}