package CarRental;

import CarRental.domain.User;
import CarRental.factory.UserFactory;
import CarRental.domain.UserType;
import CarRental.service.RepositoryService;
import CarRental.repositories.UserRepository;


public class Main {

    public static void main(String[] args) {

        FakeData.addClients();
        FakeData.addCars();
        UserRepository userRepository = UserRepository.getInstance();
        RepositoryService<User> userRepositoryService = new RepositoryService<>();
        userRepositoryService.setRepository(userRepository);
        userRepositoryService.add(UserFactory.createUser("admin", "admin", UserType.ADMIN));

        ApplicationContext.start();
    }
}

