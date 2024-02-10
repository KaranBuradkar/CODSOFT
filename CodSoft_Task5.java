import java.util.*;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    List<String> schedule;

    public Course(String code, String title, String description, int capacity, List<String> schedule) 
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String toString() 
    {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student 
{
    String id;
    String name;
    List<String> registeredCourses;

    public Student(String id, String name) 
    {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String toString() 
    {
        return "Student ID: " + id + "\nName: " + name + "\nRegistered Courses: " + registeredCourses;
    }
}

public class CodSoft_Task5 
{
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) 
    {
        initializeCourses();
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("\n1. Course Listing\n2. Student Registration\n3. Course Removal\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    removeCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    static void initializeCourses() 
    {
        courses.add(new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30, Arrays.asList("Monday, Wednesday, Friday - 9:00 AM")));
        courses.add(new Course("MAT201", "Linear Algebra", "Study of vectors and matrices", 25, Arrays.asList("Tuesday, Thursday - 11:00 AM")));
        courses.add(new Course("ENG301", "English Literature", "Exploration of classic literature", 20, Arrays.asList("Monday, Wednesday - 2:00 PM")));
    }

    static void displayCourses() 
    {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) 
        {
            System.out.println(course);
            System.out.println("---------------------------");
        }
    }

    static void registerStudent(Scanner scanner) 
    {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        students.add(student);

        System.out.println("\nAvailable Courses for Registration:");
        displayCourses();

        System.out.print("\nEnter course code to register: ");
        String courseCode = scanner.nextLine();

        Course course = findCourse(courseCode);
        if (course != null && course.capacity > 0) 
        {
            student.registeredCourses.add(courseCode);
            course.capacity--;
            System.out.println("Registration successful!");
        } else {
            System.out.println("Course not found or no available slots!");
        }
    }

    static void removeCourse(Scanner scanner) 
    {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.nextLine();

        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);

        if (student != null && course != null && student.registeredCourses.contains(courseCode)) 
        {
            student.registeredCourses.remove(courseCode);
            course.capacity++;
            System.out.println("Course dropped successfully!");
        } else 
        {
            System.out.println("Student or course not found, or student not registered for the course!");
        }
    }

    static Course findCourse(String code) 
    {
        for (Course course : courses) 
        {
            if (course.code.equals(code)) 
            {
                return course;
            }
        }
        return null;
    }

    static Student findStudent(String id) 
    {
        for (Student student : students) 
        {
            if (student.id.equals(id)) 
            {
                return student;
            }
        }
        return null;
    }
}
