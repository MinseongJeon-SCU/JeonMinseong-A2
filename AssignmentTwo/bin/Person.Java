//Class
Public abstract class Person {
    private String name;
    private String gender;
    private int age;

    //Default Constructor
    public Person {

    }

    //Second Constructor
    public Person (String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //Getter and Setter
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }
}