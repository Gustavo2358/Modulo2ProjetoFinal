package CarRental.domain;

import java.util.HashSet;

public class Client extends User{

    private HashSet<Car> rentedCars;

    public Client(String userName, String password) {
        super(userName, password);
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
    }

    public void rentCar(Car car){
        if(rentedCars.add(car)){
            System.out.println(car.toString());
        }
    }

    public void returnCar(Car car){
        rentedCars.remove(car);
    }
}
