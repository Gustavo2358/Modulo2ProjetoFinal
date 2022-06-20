package CarRental.domain;

import CarRental.domain.payment.CreditCard;

import java.util.ArrayList;
import java.util.HashSet;

public class Client extends User{

    private HashSet<Car> rentedCars = null;
    private ArrayList<CreditCard> creditCards = null;

    public Client(){
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
        creditCards = new ArrayList<>();
    }

    public Client(String userName){
        super(userName);
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
        creditCards = new ArrayList<>();
    }

    public Client(String userName, String password) {
        super(userName, password);
        super.type = UserType.CLIENT;
        rentedCars = new HashSet<>();
        creditCards = new ArrayList<>();
    }

    public HashSet<Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(HashSet<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public boolean addCreditCard(CreditCard creditCard){
        return this.creditCards.add(creditCard);

    }

}
