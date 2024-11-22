import java.util.LinkedList;
import java.util.Queue;


//Class
public class Ride implements RideInterface {
    private String rideName;
    private int rideWaitingTime;
    private Queue<Visitor> waitingLine;
    private Employee rideOperator;
    
    

    //Default Constructor
    public Ride () {
        this.waitingLine = new LinkedList<>();
    }

    //Second Constructor
    public Ride (String rideName, int rideWaitingTime, Employee rideOperator) {
        this.rideName = rideName;
        this.rideWaitingTime = rideWaitingTime;
        this.rideOperator = rideOperator;
        this.waitingLine = new LinkedList<>();
    }

    //Getter and Setter
    public String getRideName () {
        return rideName;
    }

    public void setRideName (String rideName) {
        this.rideName = rideName;
    }

    public int getRideWaitingTime () {
        return rideWaitingTime;
    }

    public void setRideWaitingTime (int rideWaitingTime) {
        this.rideWaitingTime = rideWaitingTime;
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
            System.out.println(visitor.getName() + " has been added to the queue.");
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
                System.out.println("Visitor Name-" + visitor.getName() + " Visitor Gender-" + visitor.getGender() + " Visitor Age-" +
                visitor.getAge() + " Membership Type-" + visitor.getMembershipType() + " Park Member ID-" + visitor.getParkMemberID());
            }
        }
    }
}