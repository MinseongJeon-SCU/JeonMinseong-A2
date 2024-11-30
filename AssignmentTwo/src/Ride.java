import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



//Class
public class Ride implements RideInterface {
    private String rideName;
    private int averageRideWaitingTime;
    private Queue<Visitor> waitingLine;
    private Employee rideOperator;
    private LinkedList<Visitor> rideHistory;
    private int maxRider = 3;
    private int numOfCycles;
    
    

    //Default Constructor
    public Ride () {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
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

    //Adding visitors in the queue
    @Override
    public void addVisitorToQueue (Visitor visitor) {
        if (visitor != null) { 
            waitingLine.add(visitor); 
            System.out.println(visitor.getName() + " has been added to the queue  for the " + this.rideName);
        } else {
            System.out.println("No visitors in the queue");
        }
    }

    //Removing visitors from the queue
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll();
            System.out.println(removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("There is no visitor in the queue");
        }
    }

    //Printing the queue
    @Override
    public void printQueue() {
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
    public void addVisitorToHistory (Visitor visitor) {
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
    public boolean checkVisitorFromHistory (Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " is in the ride history");
            return true;
        }
        else {
            System.out.println(visitor.getName() + " cannot be found in the ride history ");
            return false;
        }
    }

    //Printing a ride history
    @Override
    public void printRideHistory () {
        System.out.println("The list below shows the visitors who have ridden an attraction");
        Iterator <Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
                System.out.println("Visitor Name-" 
                + visitor.getName() + 
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

    //Method for printing the number of visitors in the collection
    @Override
    public int numberOfVisitors () {
        System.out.println("The number of visitors is: ");
        return rideHistory.size(); //Counting the number of visitors who have ridden an attraction. 
    }

    //Method for sorting the collection
    public void sortingTheCollection () {
        Collections.sort(rideHistory, new Sorting()); //Sorting the ride history collection by age and membership ID. 
    }

    @Override
    public void runOneCycle () {
        if (rideOperator == null) { 
            System.out.println ("Due to the absence of the ride operator, the ride is unavailable"); 
            return;
        }

        if (waitingLine.isEmpty()) {
            System.out.println("The ride is unavailable. No one is in the queue.");
            return;
        }

        int riders = maxRider;
        if (waitingLine.size() < maxRider) {
            riders = waitingLine.size();
        }

        for (int i = 0; i < riders; i++) {
            Visitor visitor = waitingLine.poll(); 
            rideHistory.add(visitor);
            System.out.println (visitor.getName() + " has been added to the ride history.");
        }

        numOfCycles++;
        System.out.println("Total Cycles: " + numOfCycles);
    }

    //Exporting the ride history
    public void exportRideHistory(String visitorFile) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter(visitorFile))) {
            for (Visitor visitor : rideHistory) {
                file.write(visitor.getName() + " , "  +
                visitor.getGender() + " , " +
                visitor.getAge() + " , " +
                visitor.getMembershipType() + " , " +
                visitor.getParkMemberID());
                file.newLine();  
            }

            System.out.println("Ride history has been stored into the " + visitorFile +" file.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Importing the ride history
    public void importRideHistory(String visitorFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(visitorFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" , ");
                try {
                    String name = data[0];
                    String gender = data[1];
                    int age = Integer.parseInt(data[2]); 
                    String membershipType = data[3];
                    int parkMemberID = Integer.parseInt(data[4]); 

                    Visitor visitor = new Visitor(name, gender, age, membershipType, parkMemberID);
                    rideHistory.add(visitor);  
                } 
                
                catch (NumberFormatException e) {
                    System.out.println("Wrong Value" + line);
                }
            }
        } 
            catch (IOException e) {
            e.printStackTrace();
        }
    }
}
