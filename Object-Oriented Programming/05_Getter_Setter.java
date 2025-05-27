/*
Access Modifiers And Getter And Setter
*/

class MyEmployee{
    private int id;
    private String name;

    public void setName(String n){
        this.name=n;
    }

    public void setId(int i ){
        this.id=i;
    }

    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
}

public class Getter_Setter {
    public static void main(String[] args) {
        System.out.println("Getter And Setter(Access and Modifiers)");
        System.out.println("-------------------");

        MyEmployee emp = new MyEmployee();
        emp.setId(682);
        emp.setName("ateeq");

        System.out.println(emp.getId());
        System.out.println(emp.getName());
    }
}
