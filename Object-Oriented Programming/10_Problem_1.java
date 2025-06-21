/*
Create a class Employee with following properties and methods .
1. salary (property)(int)
2.get salary (method returning it)
3.name (property)(string)
4.getname (method returning string)
5.setname (method changing name)
*/

class Employee1 {
    int salary;
    String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        System.out.println("Problem 01");
        System.out.println("-------------");

        Employee1 jack = new Employee1();
        jack.setName("Will Jack");
        jack.salary= 30000;
        System.out.println("Name: " +jack.getName());
        System.out.println("Salary: "+jack.getSalary());
    }
}
