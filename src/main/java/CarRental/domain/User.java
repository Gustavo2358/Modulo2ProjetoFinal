package CarRental.domain;

import java.util.Objects;

public abstract class User {
    protected String userName;
    protected String password;
    protected UserType type;

    public User(){

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
                //", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
