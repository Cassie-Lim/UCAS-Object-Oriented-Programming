import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LibrarySystem {
    // 创建书列表
    static private ArrayList<Book> books = new ArrayList<>();
    // 创建图书馆管理员
    static private Librarian librarian = new Librarian("Java", "LIB001");
    // 创建学生列表
    static private ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        // 创建书
        Random rand = new Random();
        for(int i=0; i<26; i++){
            char tmp = (char)('A'+i);
            books.add(new Book("book"+tmp, "author"+tmp, rand.nextInt(1990, 2023)));
        }

        // 交互式控制台界面
        Scanner scanner = new Scanner(System.in);
        Student student = null;
        String bookTitle = null;
        Book currentBook = null;
        while (true) {
            System.out.println("*****************************************");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Quit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    student = find_student(studentName);
                    // 未匹配到学生，新建档案
                    if(student==null){
                        System.out.println(studentName+" is not registered. Registering...");
                        System.out.print("Enter student id: ");
                        int id = Integer.valueOf(scanner.nextLine()).intValue();
                        student = new Student(studentName, id);
                        students.add(student);
                    }
                    System.out.print("Enter the title of the book to borrow: ");
                    // 根据书名找书
                    bookTitle = scanner.nextLine();
                    currentBook = find_book(bookTitle);
                    // 提示找不到书
                    if (currentBook==null){
                        System.out.println(bookTitle+" is not available in the library!");
                        break;
                    }
                    // 图书管理员处理书籍
                    librarian.checkOutBook(student, currentBook);
                    System.out.println(student.getName() + " borrowed " + currentBook.getTitle());
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    student = find_student(studentName);
                    if(student==null){
                        System.out.println(studentName+" is not registered.");
                        break;
                    }
                    System.out.print("Enter the title of the book to return: ");
                    bookTitle = scanner.nextLine();
                    currentBook = find_book(bookTitle);
                    if (currentBook==null){
                        System.out.println(bookTitle+" does not belong to this library!");
                        break;
                    }
                    librarian.checkInBook(student, currentBook);
                    break;

                case 3:
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    public static Book find_book(String bookTitle){
        Book currentBook = null;
        for(Book b:books){
        if(bookTitle.equals(b.getTitle())){
                currentBook = b;
                break;
            }
        }
        return currentBook;
    }
    public static Student find_student(String name){
        Student currentStudent = null;
        for(Student s:students){
        if(name.equals(s.getName())){
                currentStudent = s;
                break;
            }
        }
        return currentStudent;
    }
}
