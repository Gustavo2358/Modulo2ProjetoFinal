package CarRental.domain;

import CarRental.domain.payment.CreditCard;

import java.util.ArrayList;
import java.util.HashSet;

public class Client extends User{

    private HashSet<Car> rentedCars;
    private ArrayList<CreditCard> creditCards;

    public Client(String userName, String password) {
        super(userName, password);
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
        creditCards = new ArrayList<>();
    }

    public void rentCar(Car car){
        if(rentedCars.add(car)){
            System.out.println(car.toString());
        }
    }

    public void returnCar(Car car){
        rentedCars.remove(car);
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public boolean addCreditCard(CreditCard creditCard){
        return this.creditCards.add(creditCard);

    }

}
