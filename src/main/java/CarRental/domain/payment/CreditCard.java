package CarRental.domain.payment;

import java.time.LocalDate;
import java.util.Objects;

public class CreditCard {
    public CreditCard(long cardNumber, CardType type, LocalDate expireDate, int securityCode, String nameOnCard) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
        this.nameOnCard = nameOnCard;
    }

    private long cardNumber;
    private CardType type;
    private LocalDate expireDate;
    int securityCode;
    private String nameOnCard;

    public CardType getType() {
        return type;
    }


    public long getCardNumber() {
        return cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", type=" + type +
                ", expireDate=" + expireDate +
                ", nameOnCard='" + nameOnCard + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return cardNumber == that.cardNumber && Objects.equals(nameOnCard, that.nameOnCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, nameOnCard);
    }
}
