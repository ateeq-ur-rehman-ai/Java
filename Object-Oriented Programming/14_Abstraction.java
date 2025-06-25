abstract class Food {
    abstract void sound();

    void eat() {
        System.out.println("Jack eats food");
    }
}

class Burger extends Food {
    void sound() {
        System.out.println("Burger Is Tasty");
    }
}


public class Abstraction {
    public static void main(String[] args) {
        Burger f = new Burger();
        f.sound(); 
        f.eat();   
    }
}
