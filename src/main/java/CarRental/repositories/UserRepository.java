package CarRental.repositories;

import CarRental.domain.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class UserRepository implements Repository<User>{
    private static final HashSet<User> users = new HashSet<>();
    private static UserRepository instance = null;

    private UserRepository(){}

    public static UserRepository getInstance(){
        if(Objects.isNull(instance))
            instance = new UserRepository();
        return instance;
    }

    @Override
    public Collection<User> getElements() {
        return users;
    }
}
