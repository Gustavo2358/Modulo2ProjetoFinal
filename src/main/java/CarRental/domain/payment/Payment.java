package CarRental.domain.payment;

public class Payment {

    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void execute(){
        this.paymentStrategy.pay();
    }
}
