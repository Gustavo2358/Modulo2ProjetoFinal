package CarRental.repositories;

import CarRental.domain.Admin;
import CarRental.domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void addUsersReturnsFalseWhenNameIsEqual1() {
        Admin admin1 = new Admin("admin", "admin");
        UserRepository.addUser(admin1);

        Admin admin2 = new Admin("admin", "admin");
        assertFalse(UserRepository.addUser(admin2));

    }
    @Test
    void addUsersReturnsFalseWhenNameIsEqual2() {
        Client john1 = new Client("John", "1234");
        UserRepository.addUser(john1);

        Client john2 = new Client("John", "4321");
        assertFalse(UserRepository.addUser(john2));

    }

}