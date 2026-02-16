import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessorImpl implements PaymentProcessor {

    private static final List<Payment> payments = new ArrayList<>();


    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return payments;
    }

    @Override
    public List<Payment> getPaymentsByStatus(Status status) {
        return payments.stream().filter(p -> p.getStatus() == status).toList();
    }

    @Override
    public Integer getTotalNumberOfPayments() {
        return payments.size();
    }

    @Override
    public BigDecimal getTotalAmountOfSuccessfulPayments() {
        return payments.stream().filter(p -> p.getStatus() == Status.APPROVED)
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getAverageAmountOfSuccessfulPayments() {
        return payments.stream().filter(p -> p.getStatus() == Status.APPROVED)
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(getPaymentsByStatus(Status.APPROVED).size())
                        , 2
                        , BigDecimal.ROUND_HALF_UP);
    }


}
