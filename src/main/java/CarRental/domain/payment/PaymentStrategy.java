package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(Client client, BigDecimal dueValue);

}
