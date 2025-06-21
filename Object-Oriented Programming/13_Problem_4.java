/*
Create a class Tommy vecetti for rockstar games capable of hitting ,running, firing ...
*/

class Tommy{
    public void run(){
        System.out.println("Runing From the Oppostion ");
    }

    public void hit(){
        System.out.println("Hitting the Oppostion ");
    }

    public void Fire(){
        System.out.println("Firing on the Oppostion ");
    }
}

public class Problem_4{
    public static void main(String[] args) {
        System.out.println("Problem 04");
        System.out.println("------------");

        Tommy tom = new Tommy();
        tom.run();
        tom.hit();
        tom.Fire();
    }
}