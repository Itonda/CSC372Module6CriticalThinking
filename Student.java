/* This class is the blueprint for the student object
 * It contains the attributes of the student object, which are roll number, name, and address.
 * It also contains the constructor to initialize the student object and the getter methods to retrieve the values of the attributes.
 * It also contains the toString method to return the string representation of the student object.
 * The objects of this class are immutable, meaning that once the object is created, its attributes cannot be changed.
 */
public class Student {
    private final int rollno;
    private final String name;
    private final String address;
    // Constructor to initialize the student object with default values
    public Student() {
        this.rollno = 0;
        this.name = "Null Entry";
        this.address = "Null Entry";
    }
    // Constructor to initialize the student object with given values
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    // Getter method to retrieve the roll number of the student
    public int getRollno() {
        return rollno;
    }
    // Getter method to retrieve the name of the student
    public String getName() {
        return name;
    }
    // Getter method to retrieve the address of the student
    public String getAddress() {
        return address;
    }
    // Method to return the string representation of the student object
    @Override
    public String toString() {
        return "{Student # " +
                rollno +
                "| Name: '" + name + '\'' +
                ", Address: '" + address + '\'' +
                '}';
    }
} 
