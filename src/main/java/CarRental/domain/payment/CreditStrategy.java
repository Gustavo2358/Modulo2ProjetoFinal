package CarRental.domain.payment;

import CarRental.domain.Client;
import CarRental.utils.Utils;
import CarRental.view.EntryPage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class CreditStrategy implements PaymentStrategy {

    @Override
    public void pay(Client client, BigDecimal dueValue) {
        System.out.println("Pagamento via crédito");
        System.out.println("1 - Usar cartão salvo");
        System.out.println("2 - Salvar novo cartão");
        switch (Utils.getPageOption(1,2)){
            case 1:
                CreditCard card = selectCard(client, dueValue);
                executePayment(card, dueValue);
                break;
            case 2:
                saveCard(client);
                pay(client, dueValue);
                break;
        }

    }

    private void saveCard(Client client) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número do cartão:");
        long cardNumber = Long.parseLong(sc.nextLine());
        System.out.println("Bandeira: ");
        CardType type = CardType.valueOf(sc.nextLine());
        System.out.println("Data de vencimento: ");
        System.out.println("Número do mês: ");
        Month month = Month.of(Utils.getPageOption(1, 12));
        System.out.println("Ano: ");
        int year = Integer.parseInt(sc.nextLine());
        LocalDate expireDate = LocalDate.of(year, month, 1);
        System.out.println("Código de segurança: ");
        int securityCode = Integer.parseInt(sc.nextLine());
        System.out.println("Nome (como escrito no cartão):");
        String nameOnCard = sc.nextLine();
        boolean isCardSaved = client.addCreditCard(new CreditCard(cardNumber, type, expireDate, securityCode, nameOnCard));
        if (isCardSaved) {
            System.out.println("Cartão Salvo com sucesso");
            return;
        }
        System.out.println("Erro: Não foi possível salvar o cartão");
    }

    private void executePayment(CreditCard card, BigDecimal dueValue) {
        System.out.println("Pagamento concluído");
        System.out.println("Valor pago: R$" + dueValue.toString());
        System.out.println("Cartão utilizado: " + card.getCardNumber() + " - " + card.getType().toString());
        System.out.println();
    }

    private CreditCard selectCard(Client client, BigDecimal dueValue) {
        int index = 1;
        for(CreditCard card : client.getCreditCards() ){
            System.out.println(client.getCreditCards().indexOf(card)+ 1 + "- número:" + card.getCardNumber() + " nome:" + card.getNameOnCard());
        }
        System.out.println("Selecione o cartão desejado: ");
        int option = Utils.getPageOption(1, client.getCreditCards().size());
        return client.getCreditCards().get(option - 1);

    }
}
