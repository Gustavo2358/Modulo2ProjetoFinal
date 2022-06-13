package CarRental;

import CarRental.domain.User;
import CarRental.factory.UserFactory;
import CarRental.domain.UserType;
import CarRental.repositories.GenericRepository;


public class Main {

    public static void main(String[] args) {

        FakeData.addClients();
        FakeData.addCars();
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        userRepository.add(UserFactory.createUser("admin", "admin", UserType.ADMIN));

        ApplicationContext.start();
    }
}

