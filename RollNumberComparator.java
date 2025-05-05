// This class implements the Comparator interface to compare students based on their roll numbers
import java.util.Comparator;

public class RollNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getRollno(), student2.getRollno());
    }
}