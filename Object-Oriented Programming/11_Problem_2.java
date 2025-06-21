/*
Create a class cellphone with method o print Ringing,Vibrating,calling.... 
*/

class CellPhone{
    public void ring(){
        System.out.println("Ringing...");
        
    }

    public void vibrate(){
        System.out.println("Vibrating...");
        
    }

    public void call(){
        System.out.println("Calling...");
        
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        System.out.println("Problem 02");
        System.out.println("-----------");

        CellPhone vivo =new CellPhone();
        vivo.call();
        vivo.vibrate();
        vivo.ring();
    }
    
}
