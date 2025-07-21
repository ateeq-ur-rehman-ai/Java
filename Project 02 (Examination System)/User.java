public class User {
    protected String name;
    protected String userID;
    protected String password;

    public User(String name, String userID, String password) {
        this.name = name;
        this.userID = userID;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userID);
    }
}
 
    

