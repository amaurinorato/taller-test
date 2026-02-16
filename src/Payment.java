import java.math.BigDecimal;

public class Payment {

    private Integer id;
    private BigDecimal amount;
    private Currency currency;
    private Status status;

    public Payment() {

    }

    public Payment(Integer id, BigDecimal amount, Currency currency, Status status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "Payment{id=" + id + ", amount=" + amount + ", currency=" + currency + ", status=" + status + "}";
    }

}
