package CarRental;

import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.domain.User;
import CarRental.repositories.CarRepository;
import CarRental.service.RepositoryService;
import CarRental.repositories.UserRepository;

import java.math.BigDecimal;

public class FakeData {

    public static void addClients(){
        UserRepository userRepository = UserRepository.getInstance();
        RepositoryService<User> userRepositoryService = new RepositoryService<>();
        userRepositoryService.setRepository(userRepository);
        Client gustavo = new Client("gustavo", "1234");
        userRepositoryService.add(gustavo);
        Client felipe = new Client("felipe", "1234");
        userRepositoryService.add(felipe);
        Client kaique = new Client("kaique", "1234");
        userRepositoryService.add(kaique);
        Client lucas = new Client("lucas", "1234");
        userRepositoryService.add(lucas);
        Client gabriel = new Client("gabriel", "1234");
        userRepositoryService.add(gabriel);

    }

    public static void addCars(){
        CarRepository carRepository = CarRepository.getInstance();
        RepositoryService<Car> carRepositoryService = new RepositoryService<>();
        carRepositoryService.setRepository(carRepository);
        Car ferrari = new Car("Ferrari", "F-50", "abc1234", BigDecimal.valueOf(5000));
        carRepositoryService.add(ferrari);
        Car palio = new Car("Fiat", "Palio", "abc2345", BigDecimal.valueOf(100));
        carRepositoryService.add(palio);
        Car pegeout = new Car("Pegeout", "206", "abc3456", BigDecimal.valueOf(150));
        carRepositoryService.add(pegeout);

    }

}
