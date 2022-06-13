package CarRental.repositories;

import CarRental.domain.Admin;
import CarRental.domain.Client;
import CarRental.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void addUsersReturnsFalseWhenNameIsEqual1() {
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        Admin admin1 = new Admin("admin", "admin");
        userRepository.add(admin1);

        Admin admin2 = new Admin("admin", "admin");
        assertFalse(userRepository.add(admin2));

    }
    @Test
    void addUsersReturnsFalseWhenNameIsEqual2() {
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        Client john1 = new Client("John", "1234");
        userRepository.add(john1);

        Client john2 = new Client("John", "4321");
        assertFalse(userRepository.add(john2));

    }

}