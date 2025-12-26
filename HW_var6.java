import java.time.LocalDate;

public class Invoicehw {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000.0, LocalDate.now());
        System.out.println(invoice);

        invoice.setAmount(1200.0);
        invoice.sign();
        System.out.println(invoice);

        InternationalInvoice intlInvoice = new InternationalInvoice(500.0, LocalDate.of(2025, 12, 1), "USD");
        System.out.println(intlInvoice);

        intlInvoice.convert(0.93, "EUR");
        System.out.println(intlInvoice);

        intlInvoice.sign();

        if (intlInvoice.isSigned()) {
            System.out.println("Статус: подписан");
        } else {
            System.out.println("Статус: черновик");
        }    }
}

class Invoice {
    protected double amount;
    protected LocalDate date;
    protected boolean isSigned;

    public Invoice(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
        this.isSigned = false;
    }

    public void setAmount(double amount) {
        if (isSigned) {
            throw new IllegalStateException("В подписанном документе сумму менять нельзя");
        }
        this.amount = amount;
    }

    public void sign() {
        if (isSigned) {
            throw new IllegalStateException("Документ подписан");
        }
        this.isSigned = true;
    }

    public boolean isDraft() {
        return !isSigned;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        String status;
        if (isSigned) {
            status = "подписан";
        } else {
            status = "черновик";
        }
        return String.format("amount=%.2f, date=%s, status=%s",
                amount, date, status);
    }
}
class InternationalInvoice extends Invoice {
    private String currency;

    public InternationalInvoice(double amount, LocalDate date, String currency) {
        super(amount, date);
        this.currency = currency;
    }

    public void convert(double exchangeRate, String targetCurrency) {
        if (isSigned) {
            throw new IllegalStateException("В подписанном документе изменять сумму нельзя");
        }
        this.amount = this.amount * exchangeRate;
        this.currency = targetCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public String toString() {
        String status;
        if (isSigned) {
            status = "подписан";
        } else {
            status = "черновик";
        }
        return String.format("amount=%.2f, currency='%s', date=%s, status=%s",
                amount, currency, date, status);
    }
}
