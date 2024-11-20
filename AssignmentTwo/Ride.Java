//Class
public class Ride {
    private String rideName;
    private int rideWaitingTime;
    private Employee rideOperator;

    //Default Constructor
    public Ride {

    }

    //Second Constructor
    public Ride (String rideName, int rideWaitingTime, Employee rideOperator) {
        this.rideName = rideName;
        this.rideWaitingTime = rideWaitingTime;
        this.rideOperator = rideOperator;
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

}