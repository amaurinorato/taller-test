import java.math.BigDecimal;
import java.util.List;

public interface PaymentProcessor {

    void addPayment(Payment payment);
    List<Payment> getAllPayments();
    List<Payment> getPaymentsByStatus(Status status);
    Integer getTotalNumberOfPayments();
    BigDecimal getTotalAmountOfSuccessfulPayments();
    BigDecimal getAverageAmountOfSuccessfulPayments();

}
