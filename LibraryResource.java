public interface LibraryResource {
    String getTitle();
    String getResourceType();
    boolean isAvailable();
    void borrow();
    void returnResource();
    String getDetails();
}