package CarRental.factory;

import CarRental.domain.Admin;
import CarRental.domain.Client;
import CarRental.domain.User;
import CarRental.domain.UserType;

public class UserFactory {


    public static User createUser(String userName, String password, UserType type) {
        if(type == UserType.CLIENT)
            return new Client(userName, password);
        else if(type == UserType.ADMIN)
            return new Admin(userName, password);
        else
            return new Client(userName,password);
    }

}
