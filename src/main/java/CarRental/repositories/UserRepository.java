package CarRental.repositories;
import CarRental.domain.User;

import java.util.HashSet;
import java.util.Objects;

public class UserRepository {

    private static final HashSet<User> users = new HashSet<>();
    private static UserRepository instance = null;

    private UserRepository(){}

    public static UserRepository getInstance(){
        if(Objects.isNull(instance))
            instance = new UserRepository();
        return instance;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
