public class Main {
    public static void main(String[] args) {
        DIP.BankCard visa = new DebitCard();
        DIP.BankCard sbp = new DebitSBP();
        int price_1 = 800;
        int price_2 = 750;
        int amount = 500;

        visa.cardReturn();
        visa.doTransaction(amount);

        sbp.cardReturn();
        sbp.doTransaction(amount);

        Store mag1 = new Store(sbp);
        mag1.toPay(price_1, amount);

        Store mag2 = new Store(sbp);
        mag2.toPay(price_2, amount);
    }
}