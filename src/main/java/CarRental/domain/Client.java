package CarRental.domain;

import CarRental.domain.payment.CreditCard;

import java.util.ArrayList;
import java.util.HashSet;

public class Client extends User{

    private final HashSet<Car> rentedCars;
    private final ArrayList<CreditCard> creditCards;

    public Client(String userName, String password) {
        super(userName, password);
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
        creditCards = new ArrayList<>();
    }

    public HashSet<Car> getRentedCars() {
        return rentedCars;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public boolean addCreditCard(CreditCard creditCard){
        return this.creditCards.add(creditCard);

    }

}
