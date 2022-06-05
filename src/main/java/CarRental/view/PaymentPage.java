package CarRental.view;

import CarRental.domain.Car;
import CarRental.domain.payment.CreditStrategy;
import CarRental.domain.payment.InvoiceStrategy;
import CarRental.domain.payment.Payment;
import CarRental.domain.payment.PixStrategy;

import java.math.BigDecimal;
import java.util.Random;

public class PaymentPage {
    public static void execute(Car car) {

        //generate random number of days beetween 1 and 10
        int days = new Random().nextInt(9) + 1;

        System.out.printf("Valor por dia R$%.2f%n", car.getValuePerDay());
        System.out.println("Quantidade de dias: " + days);
        System.out.printf("Valor a pagar: R$%.2f%n", car.getValuePerDay().multiply(BigDecimal.valueOf(days)));

        System.out.println("Escolha a forma de pagamento: ");
        System.out.println("1 - Crédito");
        System.out.println("2 - Boleto");
        System.out.println("3 - Pix");
        int option = EntryPage.getEntryPageOption(1, 3);

        Payment payment = new Payment();
        switch (option){
            case 1:
                payment.setPaymentStrategy(new CreditStrategy());
                payment.execute();
                break;
            case 2:
                payment.setPaymentStrategy(new InvoiceStrategy());
                payment.execute();
                break;
            case 3:
                payment.setPaymentStrategy(new PixStrategy());
                payment.execute();
                break;

        }
    }
}
