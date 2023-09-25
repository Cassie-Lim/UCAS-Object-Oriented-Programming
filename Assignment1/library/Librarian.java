public class Librarian {
    private String name;
    private String employeeId;

    public Librarian(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void checkOutBook(Student student, Book book) {
        if (!book.isBorrowed()) {
            student.borrowBook(book);
            book.setBorrowed(true);
        } else {
            System.out.println("This book has been borrowed.");
        }
    }

    public void checkInBook(Student student, Book book) {
        if (student.getBorrowedBooks().contains(book)) {
            student.returnBook(book);
            book.setBorrowed(false);
            System.out.println(student.getName() + " returned " + book.getTitle());

        } else {
            System.out.println(student.getName() +" has not borrow " + book.getTitle());
        }
    }
}
