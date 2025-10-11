mport java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String username = scan.nextLine();

        System.out.println("Введите 1 число: ");
        int num1 = scan.nextInt();

        System.out.println("Введите 2 число: ");
        int num2 = scan.nextInt();

        int res;

        System.out.println("Действие: ");
        String action = scan.nextLine();
        action = scan.nextLine();

        switch (action) {
            case "+":
                res = num1 + num2;
                System.out.println(username + ", ваш результат " + res);
                break;
            case "-":
                res = num1 - num2;
                System.out.println(username + ", ваш результат " + res);
                break;
            case "*":
                res = num1 * num2;
                System.out.println(username + ", ваш результат " + res);
                break;
            case "/":
                if (num2 == 0)
                    System.out.println("Error");
                else {
                    res = num1 + num2;
                    System.out.println(username + ", ваш результат " + res);
                }
                break;
            default:
                System.out.println(username + ", вы ввели что-то не то");
        }
    }