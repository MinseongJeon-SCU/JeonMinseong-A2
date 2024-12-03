import java.util.Comparator;

//This method will compare the visitors (object) based on the visitor's age. 
//The youngest visitor will be printed first, and the other visitors will be printed in the order of their age.
//If the visitors' ages are the same, the code will sort them based on their park member IDs
public class Sorting implements Comparator <Visitor> { //Part 4B
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






