package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;

public class InvoiceStrategy implements PaymentStrategy {

    @Override
    public void pay(Client client, BigDecimal dueValue) {
        System.out.println("implementar estratégia Boleto");
    }
}
