import java.util.List;

public interface ResourceRepository {
    LibraryResource findByTitle(String title);
    List<LibraryResource> getAllResources();
    void addResource(LibraryResource resource);
    List<LibraryResource> getResourcesByType(String resourceType);
    List<LibraryResource> getAvailableResources();
}