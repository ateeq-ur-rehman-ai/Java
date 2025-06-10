public class Static_Variables {
    int id ;
    String name ;
    static String university = "DHA Suffa University";

    public Static_Variables(int id, String name) {
        this.id = id;
        this.name = name;
    }

    

    void Display(){
        System.out.println("Id No: " + id + " Student Name: " + name + " University Name: " + university );
    }

    public static void main(String[] args) {
        System.out.println("Static Variables:");
        System.out.println("=====================================");

        Static_Variables s1 = new Static_Variables(243 , "Ali");
        Static_Variables s2 = new Static_Variables(232,"Ahmed");
        Static_Variables s3 = new Static_Variables(989, "Munir");

        s1.Display();
        s2.Display();
        s3.Display();

    }
}
