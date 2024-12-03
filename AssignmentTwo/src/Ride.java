import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Ride Class
public class Ride implements RideInterface {
    private String rideName;
    private int averageRideWaitingTime;
    private Queue<Visitor> waitingLine;
    private Employee rideOperator;
    private LinkedList<Visitor> rideHistory;
    private int maxRider = 5; //By default, up to 5 visitors can ride in one cycle. 
    private int numOfCycles;
    
    

    //Default Constructor
    public Ride () {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    //Second Constructor
    public Ride (String rideName, int averageRideWaitingTime, Employee rideOperator) {
        this.rideName = rideName;
        this.averageRideWaitingTime = averageRideWaitingTime;
        this.rideOperator = rideOperator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    //Getter and Setter
    public String getRideName () {
        return rideName;
    }

    public void setRideName (String rideName) {
        this.rideName = rideName;
    }

    public int getAverageRideWaitingTimeime () {
        return averageRideWaitingTime;
    }

    public void setAaverageRideWaitingTime (int averageRideWaitingTime) {
        this.averageRideWaitingTime = averageRideWaitingTime;
    }

    public Employee getRideOperator () {
        return rideOperator;
    }

    public void setRideOperator (Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    //Adding visitors in the queue. 
    //visitor (Object) will be stored to the waitingLine (Instance variable). 
    @Override
    public void addVisitorToQueue (Visitor visitor) { //Part 3
        if (visitor != null) { 
            waitingLine.add(visitor); 
            System.out.println(visitor.getName() + " has been added to the queue  for the " + this.rideName);
        } else {
            System.out.println("No visitors in the queue");
        }
    }

    //Removing visitors from the queue
    //visitor (Object) will be removed from the waitingLine (Instance variable). 
    //poll has been used to remove visitor (Object) from the waitingLine (Instance Variable). 
    @Override
    public void removeVisitorFromQueue() {  //Part 3
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println(removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("There is no visitor in the queue");
        }
    }

    //Printing the queue
    @Override
    public void printQueue() {  //Part 3
        if (waitingLine.isEmpty()) {
            System.out.println("There are no visitors in the queue for the " + this.rideName);
        } else {
            System.out.println("The list below shows the visitors who are in the queue for the " + this.rideName);
            for (Visitor visitor : waitingLine) {
                System.out.println("Visitor Name-" + 
                visitor.getName() + 
                " Visitor Gender-" + 
                visitor.getGender() + 
                " Visitor Age-" +
                visitor.getAge() + 
                " Membership Type-" + 
                visitor.getMembershipType() + 
                " Park Member ID-" + 
                visitor.getParkMemberID());
            }
                System.out.println("The average wating time of this ride is " + this.getAverageRideWaitingTimeime() + " minuetes.");
                System.out.println("Ride operator: " + this.getRideOperator());
        }
    }

    //Adding a visitor to the rideH history
    @Override
    public void addVisitorToHistory (Visitor visitor) { //Part 4A
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to the ride history");
        }
        else {
            System.out.println("No ride history");
        }
    }

    //Checking whether the visitor is in the ride history
    @Override
    public boolean checkVisitorFromHistory (Visitor visitor) { //Part 4A
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " is in the ride history");
            return true;
        }
        else {
            System.out.println(visitor.getName() + " cannot be found in the ride history ");
            return false;
        }
    }

    //Method for printing the number of visitors in the collection
    //Counting the number of visitors who have ridden a ride by using the size method.
    //The size method counts the number of elements stored in rideHistory.
    @Override
    public int numberOfVisitors () { //Part 4A
        System.out.println("The number of visitors is: ");
        return rideHistory.size(); 
    }

    //Printing a ride history
    //Using an Iterator to access the values stored in rideHistory and using hasNext() to check whether there is another value in the collection.
    @Override
    public void printRideHistory () { //Part 4A
        System.out.println("The list below shows the visitors who have ridden an attraction");
        Iterator <Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
                System.out.println("Visitor Name-" + 
                visitor.getName() + 
                " Visitor Gender-" + 
                visitor.getGender() + 
                " Visitor Age-" +
                visitor.getAge() + 
                " Membership Type-" + 
                visitor.getMembershipType() + 
                " Park Member ID-" + 
                visitor.getParkMemberID());
        }
    }

    //Method for sorting the collection
    public void sortingTheCollection () { //Part 4B
        Collections.sort(rideHistory, new Sorting()); //Sorting the ride history collection by age and membership ID. 
    }

    @Override
    public void runOneCycle () { //Part 5
        if (rideOperator == null) {  
            System.out.println ("Due to the absence of the ride operator, the ride is unavailable"); 
            return;
        }

        if (waitingLine.isEmpty()) {
            System.out.println("The ride is unavailable. No one is in the queue.");
            return;
        }

        int riders = maxRider; //Max rider is set to 5. It means that 5 visitors can ride in one cycle. 
        if (waitingLine.size() < maxRider) {
            riders = waitingLine.size();
        }

        for (int i = 0; i < riders; i++) {
            Visitor visitor = waitingLine.poll(); 
            rideHistory.add(visitor);
            System.out.println (visitor.getName() + " has been added to the ride history.");
        }

        numOfCycles++; //By using this operator, the number of cycles will be increased by 1.
        System.out.println("Total Cycles: " + numOfCycles);
    }
 
    //Exporting the ride history
    //Using BufferedWriter to export the rideHistory data to a file.
    public void exportRideHistory(String visitorFile) { //Part 6
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(visitorFile))) {
            for (Visitor visitor : rideHistory) {
                bw.write(visitor.getName() + ","  +
                visitor.getGender() + "," +
                visitor.getAge() + "," +
                visitor.getMembershipType() + "," +
                visitor.getParkMemberID());
                bw.newLine();  
            }

            System.out.println("Ride history has been stored into the " + visitorFile +" file.");
        } 

        //By using IOException, errors can be caught, and by using printStackTrace(), error details will be displayed.
        catch (IOException e) { 
            e.printStackTrace();
        }
    }

    //Importing the ride history
    //Using BufferReader to read the file. 
    public void importRideHistory(String visitorFile) { //Part 7
        try (BufferedReader br = new BufferedReader(new FileReader(visitorFile))) {
            String line;
            while ((line = br.readLine()) != null) { //Reading a file
                String[] data = line.split(",");
                String name = data[0];
                String gender = data[1];
                int age = Integer.parseInt(data[2].trim());  //To handle the integer value, trim() and parseInt() have been used.
                String membershipType = data[3];
                int parkMemberID = Integer.parseInt(data[4].trim()); //To handle the integer value, trim() and parseInt() have been used.
    
                Visitor visitor = new Visitor(name, gender, age, membershipType, parkMemberID);
                rideHistory.add(visitor);  
            }
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
