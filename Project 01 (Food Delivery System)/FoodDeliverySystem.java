import java.util.*;

abstract class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPassword() { 
        return password; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }
}

class Customer extends User {
    public Customer(String name, String email, String password) {
        super(name, email, password);
    }
}

abstract class Vehicle {
    private static int scooterCount = 0;
    private static int bicycleCount = 0;

    public static void incrementScooter() { 
        scooterCount++; 
    }
    public static void incrementBicycle() { 
        bicycleCount++; 
    }

    public static int getScooterCount() { 
        return scooterCount; 
    }
    public static int getBicycleCount() { 
        return bicycleCount; 
    }
}

class Scooter extends Vehicle {
    public Scooter() {
        Vehicle.incrementScooter();
    }
}

class Bicycle extends Vehicle {
    public Bicycle() {
        Vehicle.incrementBicycle();
    }
}

class DeliveryAgent extends User {
    private static int agentCount = 0;
    private Vehicle vehicle;

    public DeliveryAgent(String name, String email, String password, Vehicle vehicle) {
        super(name, email, password);
        this.vehicle = vehicle;
        agentCount++;
    }

    public Vehicle getVehicle() { 
        return vehicle; 
    }

    public static int getAgentCount() { 
        return agentCount; 
    }
}

class FoodItem {
    private String itemName;
    private double price;
    private String category;

    public FoodItem(String itemName, double price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public String getItemName() { 
        return itemName; 
    }
    public double getPrice() { 
        return price; 
    }
    public String getCategory() { 
        return category; 
    }
}

interface PaymentMethod {
    void processPayment(double amount);
}

class WalletPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " via Wallet.");
    }
}

class CardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " via Card.");
    }
}

class CashPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " in Cash.");
    }
}

class Order {
    private List<FoodItem> items;
    private Date orderTime;
    private double totalAmount;
    private Customer customer;
    private DeliveryAgent agent;
    private String deliveryAddress;

    public Order(Customer customer, DeliveryAgent agent, List<FoodItem> items, String address) {
        this.customer = customer;
        this.agent = agent;
        this.items = items;
        this.deliveryAddress = address;
        this.orderTime = new Date();
        this.totalAmount = calculatePrice();
    }

    public double calculatePrice() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void makePayment(PaymentMethod method) {
        method.processPayment(totalAmount);
    }

    public void displayOrder() {
        System.out.println("Order for: " + customer.getName());
        for (FoodItem item : items) {
            System.out.println("- " + item.getItemName() + ": ₹" + item.getPrice());
        }
        System.out.println("Delivery by: " + agent.getName());
        System.out.println("Total Amount: ₹" + totalAmount);
    }
}

interface OrderService {
    void placeOrder(Order order);
    void cancelOrder(Order order);
    void completeOrder(Order order);
}

class OrderManager implements OrderService {
    private List<Order> activeOrders = new ArrayList<>();

    public void placeOrder(Order order) {
        activeOrders.add(order);
        System.out.println("Order placed successfully!");
    }

    public void cancelOrder(Order order) {
        activeOrders.remove(order);
        System.out.println("Order cancelled.");
    }

    public void completeOrder(Order order) {
        activeOrders.remove(order);
        System.out.println("Order completed.");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ali", "ali@gmail.com", "12345");
        Customer customer2 = new Customer("Ahmed", "ahmed@gmail.com", "67890");

        DeliveryAgent agent1 = new DeliveryAgent("Qasim", "qasim@del.com", "11111", new Scooter());
        DeliveryAgent agent2 = new DeliveryAgent("Zain", "zain@del.com", "22222", new Bicycle());

        // Creating food items
        FoodItem item1 = new FoodItem("Burger", 250, "MainCourse");
        FoodItem item2 = new FoodItem("Fries", 100, "Snacks");
        FoodItem item3 = new FoodItem("Pizza", 500, "MainCourse");

        List<FoodItem> orderItems1 = new ArrayList<>();
        orderItems1.add(item1);
        orderItems1.add(item2);

        List<FoodItem> orderItems2 = new ArrayList<>();
        orderItems2.add(item3);

        Order order1 = new Order(customer1, agent1, orderItems1, "Gulshan, Karachi");
        Order order2 = new Order(customer2, agent2, orderItems2, "DHA, Karachi");

        OrderManager manager = new OrderManager();

        manager.placeOrder(order1);
        order1.displayOrder();
        order1.makePayment(new WalletPayment());
        manager.completeOrder(order1);

        System.out.println();

        manager.placeOrder(order2);
        order2.displayOrder();
        order2.makePayment(new CardPayment());
        manager.completeOrder(order2);

        System.out.println("\n--- System Stats ---");
        System.out.println("Total Delivery Agents: " + DeliveryAgent.getAgentCount());
        System.out.println("Total Scooters: " + Vehicle.getScooterCount());
        System.out.println("Total Bicycles: " + Vehicle.getBicycleCount());
    }
}
