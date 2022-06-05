package CarRental.domain.payment;

public class PixStrategy implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("Implementar estratégia Pix");
    }
}
