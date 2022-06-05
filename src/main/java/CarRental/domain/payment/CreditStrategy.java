package CarRental.domain.payment;

public class CreditStrategy implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("implementar estratégia Crédito");
    }
}
