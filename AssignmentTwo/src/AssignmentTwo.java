public class AssignmentTwo {

  
    public static void main(String[] args) {
      AssignmentTwo assignment = new AssignmentTwo();
      System.out.println("==================================");
      assignment.partThree();
      System.out.println("==================================");
      assignment.partFourA();
      System.out.println("==================================");
      assignment.partFourB();
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
      Employee rideOperator = new Employee("HyeonSeo" , "Female", 30, "Security", 22);
      Ride R2 = new Ride ("BatMan RollerCoaster", 20, rideOperator);

      Visitor v6 = new Visitor ("Bob", "Male", 20, "Gold", 6);
      Visitor v7 = new Visitor ("Jaeyong", "Female", 60, "Bronze", 7);
      Visitor v8 = new Visitor ("Yoonah", "Female", 73, "Silver", 8);
      Visitor v9 = new Visitor ("Sam", "Female", 59, "Gold", 9);
      Visitor v10 = new Visitor ("Dong", "Female", 45, "Bronze", 10);

      R2.addVisitorToHistory(v6);
      R2.addVisitorToHistory(v7);
      R2.addVisitorToHistory(v8);
      R2.addVisitorToHistory(v9);
      R2.addVisitorToHistory(v10);

      R2.checkVisitorFromHistory(v6);
      R2.printRideHistory();

      System.out.println(R2.numberOfVisitors()); //Printing the number of visitors in the ride history. 

    }

    public void partFourB(){
      Employee rideOperator = new Employee("HyeonSeo" , "Female", 30, "Security", 22);
      Ride R2 = new Ride ("BatMan RollerCoaster", 20, rideOperator);

      Visitor v6 = new Visitor ("Bob", "Male", 20, "Gold", 66);
      Visitor v7 = new Visitor ("Jaeyong", "Female", 20, "Bronze", 7);
      Visitor v8 = new Visitor ("Yoonah", "Female", 73, "Silver", 8);
      Visitor v9 = new Visitor ("Sam", "Female", 59, "Gold", 9);
      Visitor v10 = new Visitor ("Dong", "Female", 45, "Bronze", 10);

      R2.addVisitorToHistory(v6);
      R2.addVisitorToHistory(v7);
      R2.addVisitorToHistory(v8);
      R2.addVisitorToHistory(v9);
      R2.addVisitorToHistory(v10);
      System.out.println("==================================");
      R2.printRideHistory();
      
      R2.sortingTheCollection();
      System.out.println("==================================");
      System.out.println("The list below is the sorted list");
      R2.printRideHistory();
    } 


    public void partFive(){

    }

    public void partSix(){

    }

    public void partSeven(){

    }


    }
    


