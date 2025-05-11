// This class creates the student list and contains the methods to add, remove, and retrieve students
// It also contains the methods to sort the students by roll number and name in ascending and descending order
import java.util.ArrayList;
import java.util.Comparator;

public class StudentList {
    // ArrayList to store the students
    private ArrayList<Student> students;
    // Constructor to initialize the student list
    public StudentList() {
        this.students = new ArrayList<>();
    }
    // Method to add a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }
    // Method to remove a student from the list by roll number
    public void removeStudent(int rollno) {
        students.removeIf(student -> student.getRollno() == rollno); // Using lambda expression to remove the student with the given roll number
    }
    // Method to retrieve a student from the list by roll number
    public Student getStudent(int rollno) {
        for (Student student : students) {
            if (student.getRollno() == rollno) { // Using lambda expression to retrieve the student with the given roll number
                return student;
            }
        }
        return null;
    }
    // Method to retrieve all students from the list
    // Returns a new ArrayList to avoid exposing the internal list
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    //Helper method to sort students by roll number and name
    public void sortStudents(Comparator<Student> comparator) {
        this.students.sort(comparator); // Using the built-in sort method of ArrayList
        }
    // Method to sort students by roll number in ascending order
    // Uses custom selection sort algorithm
    public void sortByRollNumberAsc() {
        sortStudents(Comparator.comparing(Student::getRollno));
    }
    // Method to sort students by roll number in descending order
    // Reverses the order of the comparator
    public void sortByRollNumberDesc() {
        sortStudents(Comparator.comparing(Student::getRollno).reversed());  
    }
    // Method to sort students by name in ascending order
    // Uses custom selection sort algorithm
    public void sortByNameAsc() {
        sortStudents(Comparator.comparing(Student::getName));  
    }
    // Method to sort students by name in descending order
    // Reverses the order of the comparator
    public void sortByNameDesc() {
        sortStudents(Comparator.comparing(Student::getName).reversed()); 
    }
    // Method to check if a roll number exists in the list
    public boolean rollNumberExists(int rollno) {
        return students.stream().anyMatch(student -> student.getRollno() == rollno); // Using lambda expression to check if the roll number exists in the list
    }
}
