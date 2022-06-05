package CarRental.domain.payment;

import CarRental.domain.Client;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceStrategy implements PaymentStrategy {

    @Override
    public void pay(Client client, BigDecimal dueValue) {
        System.out.println("Gerando Boleto...");
        System.out.println("BANCO 000 |001-9| 00190.00009 09876.543001 00000.040113 1 7468000000014990");
        System.out.println("##########################################################################");
        System.out.println("Local do pagamento: Pagável em qualquer banco até a data do vencimento");
        System.out.println("Data do processamento: " + LocalDate.now());
        System.out.println("Vencimento: " + LocalDate.now().plusDays(3));
        System.out.println("Beneficiário: LOCar CO.");
        System.out.println("Valor do documento: " + dueValue);
        System.out.println("Pagador: " + client.getUserName());
        System.out.println("Código de Barras");
        System.out.println("|||| || || |||| | || |||||| | |||||| || ||||||||| | || ||| ||||");

    }
}
