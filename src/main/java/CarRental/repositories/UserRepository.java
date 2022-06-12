package CarRental.repositories;

import CarRental.domain.User;

import java.util.HashSet;

public class UserRepository {

    private static final HashSet<User> users = new HashSet<>();

    public static boolean addUser(User user) {
        return users.add(user);
    }

    public static HashSet<String> getAllUserNames(){
        HashSet<String> names = new HashSet<>();
        for(User user : users){
            names.add(user.getUserName());
        }
        return names;
    }

    //TODO mover checkPassword para service
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

}
