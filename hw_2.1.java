public class Cinema{
    
    public static void main(String[] args){
    
        // Вводим переменные, которые показывают идут ли ребята в кино, цена
        boolean Vain3D = true;
        boolean Andrey2D = true;
        boolean Katya2Dor3D = true;
        boolean Vikago = true;
        int Vainprice = 500;
        int Andreyprice = 400;
        int Katyeprice = 200;
        double studprice = 0.15;
        
        // Вводим примерные цена на билеты в кино
        int price3D = 175;
        int price2D = 140;

        // Узнаём на какой фильм пойдут ребята
        boolean go3D = false;
        if (Vain3D && price3D <= Vainprice && price3D >= Katyeprice) {
            go3D = true;
        } else if (Andreyprice >= 200) {
            go3D = false;}
        else {go3D = false;}

        // Вводим переменные нач. и фин. цены
        double startprice;
        double endprice;

        // Определяем формат фильма и его цену
        if (go3D) {
            startprice = price3D;
            endprice = startprice * (1 - studprice);
            System.out.println("Идут на 3D");
        } else {
            startprice = price2D;
            endprice = startprice * (1 - studprice);
            System.out.println("Идут на 2D");
        }

        // Вывод нач. и фин. цену
        System.out.println("Цена билета без скидки: " + startprice + " руб.");
        System.out.println("Цена билета со скидкой: " + endprice + " руб.");

    }
}