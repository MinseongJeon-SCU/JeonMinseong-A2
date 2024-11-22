public class AssignmentTwo {

  
    public static void main(String[] args) {
      AssignmentTwo assignment = new AssignmentTwo();
      assignment.partThree();
    }

    public void partThree(){
      Employee rideOperator = new Employee ("Minseong", "Male", 29, "Security", 11);
      Ride R1 = new Ride ("SuperMan RollerCoaster", 10, rideOperator);

      Visitor v1 = new Visitor ("John", "Male", 31, "Gold", 1);
      Visitor v2 = new Visitor ("Park", "Female", 30, "Bronze", 2);
      Visitor v3 = new Visitor ("Kim", "Female", 33, "Silver", 3);
      Visitor v4 = new Visitor ("Eun", "Female", 31, "Gold", 4);
      Visitor v5 = new Visitor ("Hwan", "Female", 36, "Bronze", 5);

     R1.addVisitorToQueue(v1);
     R1.addVisitorToQueue(v2);
     R1.addVisitorToQueue(v3);
     R1.addVisitorToQueue(v4);
     R1.addVisitorToQueue(v5);

     R1.printQueue();
    
     R1.removeVisitorFromQueue(); //Since a queue is being used, the first object in the queue will be removed.
    
     R1.printQueue();

    }

    public void partFourA(){

    }

    public void partFourB(){
    }


    public void partFive(){

    }

    public void partSix(){

    }

    public void partSeven(){

    }


    }
    


