package CarRental.repositories;

import CarRental.domain.Car;
import java.util.HashSet;
import java.util.Objects;

public class CarRepository {

    private static final HashSet<Car> cars = new HashSet<>();
    private static CarRepository instance = null;

    private CarRepository(){}

    public static CarRepository getInstance(){
        if(Objects.isNull(instance))
            instance = new CarRepository();
        return instance;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public HashSet<Car> getCars() {
        return cars;
    }
}
