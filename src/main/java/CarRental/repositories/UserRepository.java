package CarRental.repositories;

import CarRental.domain.Guest;
import CarRental.domain.User;

import java.util.HashSet;

public class UserRepository {

    private static final HashSet<User> users = new HashSet<>();
    private static User CurrentUser = new Guest();

    public static boolean addUser(User user) {
        return users.add(user);
    }

    public static HashSet<String> getUserNames(){
        HashSet<String> names = new HashSet<>();
        for(User user : users){
            names.add(user.getUserName());
        }
        return names;
    }

    public static boolean checkPassword(String userName, String passWord){
        for(User user: users){
            if(user.getUserName().equals(userName)){
                return user.doesPasswordMatch(passWord);
            }
        }
        return false;
    }

    public static HashSet<User> getUsers() {
        return users;
    }

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }
}
