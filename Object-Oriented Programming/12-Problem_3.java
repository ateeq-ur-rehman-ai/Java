/*
Create a class square with a method to initiallize its side calculating area , parameter ...
*/

class square{
    int side ;
    public int area(){
        return side * side;
    }

    public int parimeter(){
        return 4 * side ;
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        System.out.println("Problem 03");
        System.out.println("-----------");

        square sq =new square();
        sq.side=6;
        System.out.println(sq.area());
        System.out.println(sq.parimeter());
    }
    
}
