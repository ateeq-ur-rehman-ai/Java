public class Method_Overloading {
    static int AddMethod(int x , int y){
        return x + y;    
    }
    static double AddMethod(double a , double  b , double c){
        return a + b + c;
    }
    public static void main(String[] args) {
        System.out.println("Method Overloading.");
        System.out.println("=====================================");

        int num1= AddMethod(67, 38);
        double num2 = AddMethod(2.4, 5.86, 9.26);

        System.out.println( "Int:" + num1);

        System.out.println("======================================");

        System.out.println("Double:" +num2);
    }
}
