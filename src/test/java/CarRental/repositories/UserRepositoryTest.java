package CarRental.repositories;

import CarRental.domain.Admin;
import CarRental.domain.Client;
import CarRental.domain.User;
import CarRental.service.RepositoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository = UserRepository.getInstance();
    private RepositoryService<UserRepository, User> userRepositoryService = new RepositoryService<>();

    @Test
    void addUsersReturnsFalseWhenNameIsEqual1() {
        userRepositoryService.setRepository(userRepository);
        Admin admin1 = new Admin("admin", "admin");
        userRepositoryService.add(admin1);

        Admin admin2 = new Admin("admin", "admin");
        assertFalse(userRepositoryService.add(admin2));

    }
    @Test
    void addUsersReturnsFalseWhenNameIsEqual2() {
        userRepositoryService.setRepository(userRepository);
        Client john1 = new Client("John", "1234");
        userRepositoryService.add(john1);

        Client john2 = new Client("John", "4321");
        assertFalse(userRepositoryService.add(john2));

    }

}