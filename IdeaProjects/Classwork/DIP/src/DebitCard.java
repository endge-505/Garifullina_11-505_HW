public class DebitCard implements DIP.BankCard {
    @Override
    public void cardReturn() {
        System.out.println("Debit card returned.");
    }

    @Override
    public void doTransaction(int amount) {
        System.out.println("Debit card: " + amount);
    }
}