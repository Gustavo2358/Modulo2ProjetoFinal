package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;

public class Payment {

    Client client;
    BigDecimal dueValue;
    PaymentStrategy paymentStrategy;

    public Payment(Client client, BigDecimal dueValue) {
        this.client = client;
        this.dueValue = dueValue;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void execute(){
        this.paymentStrategy.pay(client, dueValue);
    }
}
