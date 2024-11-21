import java.util.Queue;
import java.util.LinkedList;

//Class
public class Ride implements RideInterface {
    private String rideName;
    private int rideWaitingTime;
    private Employee rideOperator;
    private Queue <Visitor> waitingLine;

    //Default Constructor
    public Ride {

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

    public void setEmployeeName (Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    @Override
    public void AddVisitorToQueue (Visitor visitor) {
        waitingLine.add (visitor); //add a Visitor to the Queue
    }

    @Override
    public void RemoveVisitorFromQueue () {
        Visitor removeVisitor = waitingLine.poll (); //remove a Visitor from the Queue
    }

    @Override
    public void PrintQueue () {
        
    }

}