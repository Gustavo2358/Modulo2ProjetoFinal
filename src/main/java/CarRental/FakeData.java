package CarRental;

import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.domain.User;
import CarRental.repositories.GenericRepository;

import java.math.BigDecimal;

public class FakeData {

    public static void addClients(){
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        Client gustavo = new Client("gustavo", "1234");
        userRepository.add(gustavo);
        Client felipe = new Client("felipe", "1234");
        userRepository.add(felipe);
        Client kaique = new Client("kaique", "1234");
        userRepository.add(kaique);
        Client lucas = new Client("lucas", "1234");
        userRepository.add(lucas);
        Client gabriel = new Client("gabriel", "1234");
        userRepository.add(gabriel);

    }

    public static void addCars(){
        GenericRepository<Car> carRepository = GenericRepository.getInstance();
        Car ferrari = new Car("Ferrari", "F-50", "abc1234", BigDecimal.valueOf(5000));
        carRepository.add(ferrari);
        Car palio = new Car("Fiat", "Palio", "abc2345", BigDecimal.valueOf(100));
        carRepository.add(palio);
        Car pegeout = new Car("Pegeout", "206", "abc3456", BigDecimal.valueOf(150));
        carRepository.add(pegeout);

    }

}
