import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Есть ли мороженое в магазине?");
        String answer_1 = scan.nextLine();
        if (answer_1.equals("Да")) {
            choose(answer_1);
        }
        if (answer_1.equals("Нет")) {
            exit(answer_1);
        }

    }

    public static void choose(String chs) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Хватает ли денег?");
        String answer_2 = scan.nextLine();
        if (answer_2.equals("Да")) {
            go_boxoffice(answer_2);
        }
        if (answer_2.equals("Нет")) {
            choose_anotherone(answer_2);
        }
    }

    public static void exit(String ex) {
        System.out.println("Спасибо за визит!");
    }

    public static void go_boxoffice(String box) {
        System.out.println("Покупаем мороженое!");
    }

    public static void choose_anotherone(String anot) {
        System.out.println("Выберите другое мороженое!");
        choose(anot);
    }
}