public class DebitSBP implements DIP.BankCard {
    @Override
    public void cardReturn() {
        System.out.println("Online card");
    }

    @Override
    public void doTransaction(int amount) {
        System.out.println("Payment by SBP " + amount);
    }
}