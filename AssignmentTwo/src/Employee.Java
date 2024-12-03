//Employee Class. 
//Since extends has been used, the Employee class inherits from the Person class.
public class Employee extends Person {
    private String employeePosition;
    private int employeeID;

    //Default Constructor
    public Employee () {
        super();
    }

    //Second Constructor. 
    public Employee (String name, String gender, int age, String employeePosition, int employeeID) {
        super (name, gender, age);
        this.employeePosition = employeePosition;
        this.employeeID = employeeID;
    }

    //Getter and Setter
    public String getEmployeePosition () {
        return employeePosition;
    }

    public void setEmployeePosition (String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeID () {
        return employeeID;
    }

    public void setEmployeeID (int employeeID) {
        this.employeeID = employeeID;
    }

    //Method to return a string representation of the Employee object for printing.
    public String toString() {
        return "Name: " + getName() + 
            " Gender: " + getGender() + 
            " Age: " + getAge() + 
            " Employee Position: " + employeePosition + 
            " EmployeeID: " + employeeID;
    }
}