public class Store {
    private DIP.BankCard paymentMethod;

    public Store(DIP.BankCard paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void toPay(int price, int amount) {
        if (amount >= price) {
            System.out.println("Payment successful.");
            paymentMethod.doTransaction(price);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}