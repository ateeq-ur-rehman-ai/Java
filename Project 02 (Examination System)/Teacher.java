public class Teacher extends User {

    public Teacher(String name, String userID, String password) {
        super(name, userID, password);
    }

    public void showAssignedCourses() {
        System.out.println("Raza has access to all offered courses:");
        System.out.println("- DBT-2001");
        System.out.println("- DBL-2001");
        System.out.println("- OOPT-2002");
        System.out.println("- OOPL-2002");
        System.out.println("- OSL-2003");
        System.out.println("- OS-2003");
        System.out.println("- SDA-2004");
    }
}
