
class parent{

    public int x;

    public int getX(){
        return x ;
    }
    public void setX(int x){
        System.out.println("I am In Parent Class And Setting X.");
        this.x=x;
    }
    public void printMe(){
        System.out.println(" I am In constructor ");
    }
}

class child extends parent{

    public int y;

    public int getY(){
        return y; 
    }
    public void setY(int y){
        this.y=y;
    }
}


public class Inheritence {
    public static void main(String[] args) {

        parent p =new parent();
        p.setX(67);
        System.out.println(p.getX());

        child c=new child();
        c.setX(57);
        System.out.println(c.getX());

    }
}
