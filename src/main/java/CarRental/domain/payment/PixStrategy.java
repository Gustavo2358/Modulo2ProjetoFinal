package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;
import java.util.Random;

public class PixStrategy implements PaymentStrategy{

    @Override
    public void pay(Client client, BigDecimal dueValue) {
        int code = new Random().nextInt();
        System.out.println("Pagamento via Pix");
        System.out.println("Nome: " + client.getUserName());
        System.out.println("Total a pagar: " + dueValue.toString());
        System.out.println("Utilize o código para efetuar o pagamento via Pix:");
        System.out.println("Código Pix: " + code);

    }
}
