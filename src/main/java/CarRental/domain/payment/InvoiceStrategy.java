package CarRental.domain.payment;

public class InvoiceStrategy implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("implementar estratégia Boleto");
    }
}
