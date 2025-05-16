/*
 Constructor and Overloading
*/
class MainEmployee {
    private int id;
    private String name;

    public MainEmployee(String myName, int myId) {
        id = myId;
        name = myName;
    }

    public MainEmployee() {
        id = 0;
        name = "Enter Your Name:";
    }

    public MainEmployee(int ID){
        id =ID;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setId(int i) {
        this.id = i;
    }
}

public class Constructor {
    public static void main(String[] args) {
        System.out.println("Constructors");
        System.out.println("-------------------");

        MainEmployee emp = new MainEmployee("ALI",73627);
        System.out.println(emp.getId());
        System.out.println(emp.getName());
    }
}

