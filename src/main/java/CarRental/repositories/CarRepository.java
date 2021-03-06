package CarRental.repositories;

import CarRental.domain.Car;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class CarRepository implements Repository<Car>{
    private static final HashSet<Car> cars = new HashSet<>();
    private static CarRepository instance = null;

    private CarRepository(){}

    public static CarRepository getInstance(){
        if(Objects.isNull(instance))
            instance = new CarRepository();
        return instance;
    }

    @Override
    public Collection<Car> getElements() {
        return cars;
    }
}

