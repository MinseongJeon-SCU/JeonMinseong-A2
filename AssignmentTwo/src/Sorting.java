import java.util.Comparator;

public class Sorting implements Comparator <Visitor> {
    @Override
    public int compare (Visitor v1, Visitor v2) {
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison; 
        }
        else {
            return Integer.compare(v1.getParkMemberID(), v2.getParkMemberID());
        }
    }
}






