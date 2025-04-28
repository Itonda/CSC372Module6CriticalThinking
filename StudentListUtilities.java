// This class contains the utility methods for the student list
// It contains a selection sort algorithm to sort the students
import java.util.ArrayList;
import java.util.Comparator;

public class StudentListUtilities {
    // Method to sort the ArrayList of students using selection sort
    // This method should be mobile for roll number and name
    public static void sortStudents(ArrayList<Student> arr, Comparator<Student> comparator) {
        // bigIndex will store the index of the smallest element found in the array
        int smallIndex = 0;
        /* smallIndex starts at beginning of arrayList
         * once the smallest element is found with j, smallIndex it will be assigned to value of j */
        for (int i = 0; i < arr.size() - 1; i++) {
            smallIndex = i;
            // Start j from the element to the right of i to find the next smallest element
            for (int j = i + 1; j < arr.size(); j++) { 
                // Use the comparator to determine next smallest element
                if (comparator.compare(arr.get(j), arr.get(smallIndex)) < 0) {
                    smallIndex = j;
                }
            }
            // Swap the elements at i and smallIndex
            Student temp = arr.get(i);
            arr.set(i, arr.get(smallIndex));
            arr.set(smallIndex, temp);
        }
    }
}