package CarRental.repositories;

import CarRental.domain.Admin;
import CarRental.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void addUsersReturnsFalseWhenNameIsEqual1() {
        UserRepository userRepository = UserRepository.getInstance();
        Admin admin1 = new Admin("admin", "admin");
        userRepository.addUser(admin1);

        Admin admin2 = new Admin("admin", "admin");
        assertFalse(userRepository.addUser(admin2));

    }
    @Test
    void addUsersReturnsFalseWhenNameIsEqual2() {
        UserRepository userRepository = UserRepository.getInstance();
        Client john1 = new Client("John", "1234");
        userRepository.addUser(john1);

        Client john2 = new Client("John", "4321");
        assertFalse(userRepository.addUser(john2));

    }

}