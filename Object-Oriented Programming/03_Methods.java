public class Methods {
    static void StudentGPA(){
        System.out.println("Student GPA is 3.67.");
    }
    public void StudentDepartment(){
        System.out.println("Student Department is Artificial Intelligence.");
    }
    public static void main(String[] args) {
        System.out.println("Methods(Functions) In Java. ");
        System.out.println("============================================");

        System.out.println("This Function is Static.");
        StudentGPA();

        System.out.println("============================================");

        System.out.println("This Function is non static.");
        Methods S=new Methods();
        S.StudentDepartment();
    }
}