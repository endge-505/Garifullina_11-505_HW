public interface Transaction {
    void doTransactoin(int amount);
    default int getAvaibleAmount(int amount){
        return amount;
    }
}
