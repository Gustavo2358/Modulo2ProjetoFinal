package CarRental.repositories;

import CarRental.domain.Car;
import java.util.HashSet;

public class CarRepository {

    private static final HashSet<Car> cars = new HashSet<>();


    public static boolean addCar(Car car) {
        return cars.add(car);
    }

    public static HashSet<Car> getCars() {
        return cars;
    }
}
