package CarRental;

import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.repositories.CarRepository;
import CarRental.repositories.UserRepository;

import java.math.BigDecimal;

public class FakeData {

    public static void addClients(){
        UserRepository userRepository = UserRepository.getInstance();
        Client gustavo = new Client("gustavo", "1234");
        userRepository.addUser(gustavo);
        Client felipe = new Client("felipe", "1234");
        userRepository.addUser(felipe);
        Client kaique = new Client("kaique", "1234");
        userRepository.addUser(kaique);
        Client lucas = new Client("lucas", "1234");
        userRepository.addUser(lucas);
        Client gabriel = new Client("gabriel", "1234");
        userRepository.addUser(gabriel);

    }

    public static void addCars(){
        Car ferrari = new Car("Ferrari", "F-50", "abc1234", BigDecimal.valueOf(5000));
        CarRepository.addCar(ferrari);
        Car palio = new Car("Fiat", "Palio", "abc2345", BigDecimal.valueOf(100));
        CarRepository.addCar(palio);
        Car pegeout = new Car("Pegeout", "206", "abc3456", BigDecimal.valueOf(150));
        CarRepository.addCar(pegeout);

    }

}
