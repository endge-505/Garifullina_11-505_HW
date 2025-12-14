public class Main{
    public static void main(String[] args){
        String product = "marshmallows";
        Order newOrder_1 = new Order(product, 2);
        OrderSaved newOrder_2 = new OrderSaved();

        newOrder_1.print(product);
        newOrder_1.save();

        newOrder_2.print(product);
    }
}