//Class
public class Employee extends Person {
    private String employeeName;
    private int employeeID;

    //Default Constructor
    public Employee () {
        super ();
    }

    //Second Constructor 
    public Employee (String name, String gender, int age, String employeeName. int employeeID) {
        super (name,gender, age);
        this.employeeName = employeeName;
        this.employeeID = employeeID;
    }

    //Getter and Setter
    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID () {
        return employeeID;
    }

    public void setEmployeeID (int employeeID) {
        this.employeeID = employeeID;
    }
}