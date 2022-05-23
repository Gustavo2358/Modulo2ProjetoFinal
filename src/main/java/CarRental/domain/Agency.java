package CarRental.domain;

import java.util.HashSet;

public class Agency {

    private final HashSet<User> users = new HashSet<>();
    private User CurrentUser = new Guest();

    public boolean addUsers(User user) {
        return this.users.add(user);
    }

    public HashSet<String> getUserNames(){
        HashSet<String> names = new HashSet<>();
        for(User user : users){
            names.add(user.getUserName());
        }
        return names;
    }

    public boolean checkPassword(String userName, String passWord){
        for(User user: users){
            if(user.getUserName().equals(userName)){
                return user.doesPassWordMatch(passWord);
            }
        }
        return false;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public User getCurrentUser() {
        return CurrentUser;
    }

    public void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }
}
