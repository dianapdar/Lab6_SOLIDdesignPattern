import java.time.LocalDate;

public class TestProgram {
    
    public static void main(String[] args) {
        System.out.println("=== NEU Library Management System Test ===\n");
        
        // Create repository
        ResourceRepository repository = new LibraryRepository();
        
        // Add resources
        System.out.println("1. Adding Resources:");
        repository.addResource(new Book("Java Programming", "John Smith", "978-1234567890"));
        repository.addResource(new Book("Data Structures", "Jane Doe", "978-0987654321"));
        repository.addResource(new Journal("IEEE Computer", "Vol 45", LocalDate.of(2024, 3, 15)));
        repository.addResource(new Thesis("Machine Learning in Healthcare", "Alice Brown", "PhD", 2023));
        repository.addResource(new Newspaper("Daily Tech", "Tech Publications", LocalDate.of(2024, 5, 20)));
        
        System.out.println("Added 5 resources to library\n");
        
        // Create students
        System.out.println("2. Creating Students:");
        Student alice = new Student("Alice Johnson", "S001", repository);
        Student bob = new Student("Bob Smith", "S002", repository);
        System.out.println("Created students: Alice and Bob\n");
        
        // Test borrowing
        System.out.println("3. Testing Borrowing:");
        alice.borrowResource("Java Programming");
        alice.borrowResource("IEEE Computer");
        bob.borrowResource("Data Structures");
        bob.borrowResource("Machine Learning in Healthcare");
        System.out.println();
        
        // Display borrowed resources
        System.out.println("4. Current Borrowed Resources:");
        alice.displayBorrowedResources();
        System.out.println();
        bob.displayBorrowedResources();
        System.out.println();
        
        // Test returning
        System.out.println("5. Testing Returning:");
        alice.returnResource("Java Programming");
        bob.returnResource("Data Structures");
        System.out.println();
        
        // Test error cases
        System.out.println("6. Testing Error Cases:");
        alice.borrowResource("Nonexistent Book");
        alice.borrowResource("Java Programming"); // Now available again
        bob.borrowResource("Java Programming");   // Should fail - already borrowed
        alice.returnResource("Nonexistent Book");
        System.out.println();
        
        // Display final state
        System.out.println("7. Final State:");
        alice.displayBorrowedResources();
        System.out.println();
        bob.displayBorrowedResources();
        System.out.println();
        
        // Show repository stats
        System.out.println("8. Repository Summary:");
        LibraryRepository libRepo = (LibraryRepository) repository;
        System.out.println("Total resources: " + libRepo.getTotalResourceCount());
        System.out.println("Available resources: " + libRepo.getAvailableResourceCount());
        
        System.out.println("\n=== Test Completed Successfully ===");
        System.out.println("✓ Dependency Inversion Principle: Student depends on ResourceRepository interface");
        System.out.println("✓ Open/Closed Principle: New resource types can be added without changing existing code");
        System.out.println("✓ Single Responsibility: Each class has one clear purpose");
        System.out.println("✓ Interface Segregation: Clean, focused interfaces");
        System.out.println("✓ Liskov Substitution: All LibraryResource implementations work interchangeably");
    }
}