import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessorImpl();

        CompletableFuture.runAsync(() -> {
            paymentProcessor.addPayment(new Payment(1, new BigDecimal("100.00"), Currency.US, Status.APPROVED));
            paymentProcessor.addPayment(new Payment(2, new BigDecimal("200.00"), Currency.BRL, Status.PENDING));
            paymentProcessor.addPayment(new Payment(3, new BigDecimal("150.00"), Currency.EUR, Status.FAILED));
            paymentProcessor.addPayment(new Payment(4, new BigDecimal("300.00"), Currency.US, Status.APPROVED));
        });

        System.out.println("All Payments:");
        for (Payment payment : paymentProcessor.getAllPayments()) {
            System.out.println(payment);
        }

        System.out.println("Approved Payments:");
        for (Payment payment : paymentProcessor.getPaymentsByStatus(Status.APPROVED)) {
            System.out.println(payment);
        }

        System.out.println("Total Number of Payments: " + paymentProcessor.getTotalNumberOfPayments());
        System.out.println("Total Amount of Successful Payments: " + paymentProcessor.getTotalAmountOfSuccessfulPayments());
        System.out.println("Average Amount of Successful Payments: " + paymentProcessor.getAverageAmountOfSuccessfulPayments());


    }
}