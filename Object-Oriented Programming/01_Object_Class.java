class Employee{
    int id ;
    String name;
    int salary ;
    public void details(){
        System.out.println("Employee Id is " + id + " and Employee Name is " + name + " and his salary is " + salary );
    }
}

public class Object_Class {
    public static void main(String[] args) {
        System.out.println("Employee Details :");

        //Adding new employees  
        Employee Ahmed = new Employee(); 
        Employee Ali = new Employee();
        Employee Qasim = new Employee();

        // Attibutes
        Ahmed.id=738;
        Ahmed.name="Ahmed";
        Ahmed.salary=23000;

        Ali.id=231;
        Ali.name="Ali";
        Ali.salary=30000;

        Qasim.id=89;
        Qasim.name="Qasim";
        Qasim.salary=40000;

        System.out.println(Ahmed.id);
        System.out.println(Ahmed.name);
        System.out.println(Ahmed.salary);

        System.out.println(Ali.id);
        System.out.println(Ali.name);
        System.out.println(Ali.salary);

        System.out.println(Qasim.id);
        System.out.println(Qasim.name);
        System.out.println(Qasim.salary);

        //Printing Attributes
        Qasim.details();
        Ali.details();
        Ahmed.details();
        
    }
      
}
