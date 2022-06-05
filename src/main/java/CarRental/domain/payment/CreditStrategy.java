package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;

public class CreditStrategy implements PaymentStrategy {

    @Override
    public void pay(Client client, BigDecimal dueValue) {
        System.out.println("Pagamento via crédito");
    }
}
