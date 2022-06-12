package CarRental;

import CarRental.factory.UserFactory;
import CarRental.repositories.UserRepository;
import CarRental.domain.UserType;


public class Main {

    public static void main(String[] args) {

        FakeData.addClients();
        FakeData.addCars();

        UserRepository.addUser(UserFactory.createUser("admin", "admin", UserType.ADMIN));

        ApplicationContext.start();
    }
}

