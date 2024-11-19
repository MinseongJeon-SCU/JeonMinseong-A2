//Class
public class Visitor extends Person {
    private String membershipType;
    private int parkMemberID;
    
    //Default Constructor 
    public Visitor {
        super ();
    }

    //Second Constructor
    public Visitor ((String name, String gender, int age, String membershipType, int parkMemberID) {
        super (String name, String gender, int age);
        this.membershipType = membershipType;
        this.parkMemberID = parkMemberID;
    }

    //Getter and Setter
    public getMembershipType () {
        return membershipType;
    }

    public void setMembershipType (String membershipType) {
        this.membershipType = membershipType;
    }

    public getParkMemberID () {
        return parkMemberID;
    }

    public void setParkMemberID (int parkMemberID) {
        this.parkMemberID = parkMemberID;
    }
}