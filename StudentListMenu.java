// This class is responsible for taking input from the user to create a list of students.
// It also contains the menu to perform operations on the student list.
// Contains error handling for invalid inputs
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList; 

public class StudentListMenu {
    // Create a StudentList object to store the students
    StudentList studentList = new StudentList();
    // Testing below: TESTING methods may be removed
    // TESTING
    // Constructor to add initial test students
    public StudentListMenu() {
        addTestStudents();
    }
    // TESTING
    // Method to add predefined test students
    private void addTestStudents() {
        studentList.addStudent(new Student(101, "Alice Smith", "123 Maple St"));
        studentList.addStudent(new Student(105, "Bob Johnson", "456 Oak Ave"));
        studentList.addStudent(new Student(103, "Charlie Brown", "789 Pine Ln"));
        studentList.addStudent(new Student(102, "Diana Prince", "101 Cherry Rd"));
        studentList.addStudent(new Student(108, "Ethan Hunt", "202 Birch Blvd"));
        studentList.addStudent(new Student(104, "Fiona Glenanne", "303 Cedar Ct"));
        studentList.addStudent(new Student(107, "George Costanza", "404 Elm Way"));
        studentList.addStudent(new Student(106, "Hannah Abbott", "505 Spruce Dr"));
        studentList.addStudent(new Student(110, "Ian Malcolm", "606 Willow Pl"));
        studentList.addStudent(new Student(109, "Jane Doe", "707 Redwood Cir"));
        System.out.println("Added 10 test students."); // Optional confirmation message
    }
    // Method to print the menu options
    private void printMenu() {
        System.out.println("\n--- Student List Menu ---");
        System.out.println("Enter 1 to add a student");
        System.out.println("Enter 2 to remove a student");
        System.out.println("Enter 3 to get a student by roll number");
        System.out.println("Enter 4 to get all students");
        System.out.println("Enter 5 to sort students by roll number");
        System.out.println("Enter 6 to sort students by name");      
        System.out.println("Enter 0 to exit");
        System.out.println();
        System.out.print("Enter your choice: ");    
    }
    //Method to check if the student roll number is valid to add a student
    private boolean isRollNumberValidForAdd(int rollno) {
            // Check if the roll number is unique using the rollNumberExists method from StudentList
            if (studentList.rollNumberExists(rollno)) {
            System.out.println("\nERROR: Roll number already exists. Please enter a unique roll number.");
            return false; // Roll number already exists
        }
        if (rollno <= 99) {
            System.out.println("\nERROR: Roll numbers start at 100. Your entry " + rollno + " is invalid.");
            return false; // Roll number is not valid
        }
        return true; // Roll number is valid
    }
    // Method to check if the student roll number is valid to remove a student
    private boolean isRollNumberValidForRemove(int rollno) {
        // Check if the roll number exists using the rollNumberExists method from StudentList
        if (!studentList.rollNumberExists(rollno)) {
            System.out.println("\nERROR: Roll number does not exist. Please enter a valid roll number.");
            return false; // Roll number does not exist
        }
        return true; // Roll number is valid
    }
    // Method to add a student
    private void addStudent(Scanner scanner) {
        while (true) { // Loop until a valid roll number is entered
            try {
                // Prompt the user to enter the roll number
                System.out.print("\nEnter roll number (or 0 to cancel): "); 
                int rollno = scanner.nextInt(); // Get the roll number from the user
                scanner.nextLine(); 
                // Gives the user a chance to cancel the operation
                if (rollno == 0) { // If the user enters 0, cancel the operation
                    System.out.println("\nOperation canceled. Returning to menu.");
                    return; 
                }
                // Check if the roll number is invalid
                if (!isRollNumberValidForAdd(rollno)) {
                    continue; // Prompt for roll number again
                }
                // Prompt the user to enter the name and address
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                // Create a new student object and add it to the list 
                Student newStudent = new Student(rollno, name, address);
                studentList.addStudent(newStudent); // Use the addStudent method from StudentList
                System.out.println("\nStudent added successfully.");
                return; // Exit after successful addition
                // Catch block to handle invalid input for roll number
            } catch (InputMismatchException e) { 
                System.out.println("\nERROR: Invalid input for roll number. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    // Method to remove a student
    private void removeStudent(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) { // Loop until a valid roll number is entered
            // Prompt the user to enter the roll number of the student to remove or 0 to return to menu
            System.out.print("\nEnter roll number of the student to remove or 0 to return to menu: ");
            try {
                int rollno = scanner.nextInt(); // Get the roll number from the user
                scanner.nextLine(); 
                // Gives the user a chance to cancel the operation
                if (rollno == 0) { // If the user enters 0, cancel the operation
                    return; 
                }
                // Check if the roll number is valid
                if (!isRollNumberValidForRemove(rollno)) {
                    continue; // Prompt for roll number again
                }
                // Confirm if the user wants to remove the student
                System.out.print("\nAre you sure you want to remove student #" + rollno + "? (y/n): ");
                String confirmation = scanner.nextLine().trim().toLowerCase(); // Convert the input to lowercase and remove leading/trailing spaces
                if (confirmation.equalsIgnoreCase("y")) { // If the user confirms, remove the student
                    // Remove the student from the list 
                    studentList.removeStudent(rollno); // Use the removeStudent method from StudentList
                    System.out.println("\nStudent removed successfully.");
                    validInput = true; // Exit loop after valid input
                    return; 
                } else { // If the user does not confirm, print a message indicating that the student was not removed
                    System.out.println("\nStudent removal canceled. Returning to menu.");
                    validInput = true; // Exit loop after valid input
                    return; 
                }
                // Catch block to handle invalid input for roll number
            } catch (InputMismatchException e) { 
                System.out.println("\nERROR: Invalid input for roll number. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
    // Method to get a student by roll number
    private void getStudentByRollNumber(Scanner scanner) {
        boolean validInput = false;
        // Loop until a valid roll number is entered
        while (!validInput) {
            // Prompt the user to enter the roll number of the student to retrieve or 0 to return to menu
            System.out.print("\nEnter roll number to search or 0 to return to menu: ");
            try {
                int rollno = scanner.nextInt(); // Get the roll number from the user
                scanner.nextLine();
                // Gives the user a chance to cancel the operation 
                if (rollno == 0) { // If the user enters 0, cancel the operation
                    return; 
                }
                // Retrieve the student from the list
                Student student = studentList.getStudent(rollno);
                if (student != null) { // Check if the student retrieved is not null
                    System.out.println("\nStudent found: " + student); // Print the student details
                } else { // If the student is null, print a message indicating that the student was not found
                    System.out.println("\nERROR: Student with roll number " + rollno + " not found.");
                }
                validInput = true; // Exit loop after successful input
            } catch (InputMismatchException e) { // Catch block to handle invalid input for roll number
                System.out.println("\nERROR: Invalid input for roll number. Please enter an integer.");
                scanner.nextLine(); 
            }
        }
    }
    // Method to display all students (returns a copy)
    private void displayAllStudents() {
        // Retrieve all students from the list using the getAllStudents method from StudentList
        ArrayList<Student> allStudents = studentList.getAllStudents(); 
        if (allStudents.isEmpty()) { // Check if the list is empty
            System.out.println("\nERROR: The student list is empty."); // If the list is empty, print a message 
        } else { // If the list is not empty, print the students
            System.out.println("\n--- All Students ---");
            for (Student student : allStudents) {
                System.out.println(student);
            }
            System.out.println("--------------------");
        }
    }
    // Helper method to handle the common sorting order input logic
    private void handleSortOrderInput(String prompt, Runnable sortAscAction, Runnable sortDescAction, Scanner scanner) {
        boolean validInput = false;
        // Loop until a valid sorting order is entered
        while (!validInput) {
            // Prompt the user using the provided prompt
            System.out.print(prompt);
            String order = scanner.nextLine().trim().toUpperCase(); // Convert the input to uppercase and remove leading/trailing spaces
            // Switch case to handle the user's choice
            switch (order) {
                case "A": // If the user enters A, execute the ascending action
                    sortAscAction.run(); // Execute the passed-in ascending sort action
                    validInput = true;
                    break;
                case "D": // If the user enters D, execute the descending action
                    sortDescAction.run(); // Execute the passed-in descending sort action
                    validInput = true;
                    break;
                case "R": // If the user enters R, return to menu
                    return;
                default: // If the user enters anything else, print a message indicating that the sorting order is invalid
                    System.out.println("\nERROR: Invalid sorting order. Please enter A, D, or R.");
                    break; // Continue the loop
            }
        }
    }
    // Method to perform the sorting and display the results
    private void performSortAndDisplay(Runnable sortAction, String sortDescription) {
        sortAction.run(); // Execute the specific sort method (e.g., studentList::sortByRollNumberAsc)
        System.out.println("\nStudents sorted by " + sortDescription + ".");
        displayAllStudents(); // Print the sorted list
    }
    // Method to handle sorting by roll number (Asc/Desc)
    private void handleSortByRollNumber(Scanner scanner) {
        String prompt = "\nSort by Roll Number (Ascending or Descending)? Enter A for Ascending, D for Descending, or R to return to menu: ";
        // Pass lambdas calling the generic sort/display method
        handleSortOrderInput(prompt,
            () -> performSortAndDisplay(studentList::sortByRollNumberAsc, "roll number (Ascending)"),
            () -> performSortAndDisplay(studentList::sortByRollNumberDesc, "roll number (Descending)"),
            scanner
        );
    }
    // Method to handle sorting by name (Asc/Desc)
    private void handleSortByName(Scanner scanner) {
        String prompt = "\nSort by Name (Ascending or Descending)? Enter A for Ascending, D for Descending, or R to return to menu: ";
        // Pass lambdas calling the generic sort/display method
        handleSortOrderInput(prompt,
            () -> performSortAndDisplay(studentList::sortByNameAsc, "name (Ascending)"),
            () -> performSortAndDisplay(studentList::sortByNameDesc, "name (Descending)"),
            scanner
        );
    }
    // This method runs the main menu loop
    // It will keep running until the user chooses to exit
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) { // Create a scanner object to read user input
            while (true) { // Loop until the user chooses to exit
                printMenu(); // Print the menu options
                try { // Added try-catch block for input validation
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    // Switch case to handle the user's choice
                    // Calls the appropriate method based on the user's choice
                    switch (choice) {
                        case 1: // If the user enters 1, add a student
                            addStudent(scanner); 
                            break;
                        case 2: // If the user enters 2, remove a student
                            removeStudent(scanner);
                            break;
                        case 3: // If the user enters 3, get a student by roll number
                            getStudentByRollNumber(scanner);
                            break;
                        case 4: // If the user enters 4, display all students
                            displayAllStudents();
                            break;
                        case 5: // If the user enters 5, sort students by roll number
                            handleSortByRollNumber(scanner);
                            break;
                        case 6: // If the user enters 6, sort students by name
                            handleSortByName(scanner);
                            break;
                        // The user can exit the program by entering 0
                        case 0:
                            System.out.println("\nExiting...");
                            scanner.close(); // Close the scanner
                            return;
                        default: // If the user enters anything else, print a message indicating that the choice is invalid
                            System.out.println("\nERROR: Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nERROR: Invalid input. Please enter a number.");
                    scanner.nextLine(); 
                }
            }
        }   
    }
}