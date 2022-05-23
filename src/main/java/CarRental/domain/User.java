package CarRental.domain;

public abstract class User {
    protected String userName;
    protected String password;
    protected UserType type;

    public User(){

    }

    public User(String userName, String password, UserType type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public UserType getType() {
        return type;
    }


    public boolean doesPassWordMatch(String passWord) {
        return this.password.equals(passWord);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
