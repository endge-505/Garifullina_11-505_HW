public class Order implements Print, SaveDatabase{
    private String product;
    private int amount;
    public Order(String product, int amount){
        this.product = product;
        this.amount = amount;
    }
    public void print(String product){
        System.out.println(product);
    }
    public void save(){
        System.out.println("The data has been saved");
    }
}
