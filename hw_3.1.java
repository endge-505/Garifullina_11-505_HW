import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] name = {"user1", "user2", "user3", "user4", "user5"};
        int age[] = new int[5];
        String[] mail = {"user1", "user2", "user3", "user4", "user5"};
        String[] unst = {"user1", "user2", "user3", "user4", "user5"};
        String[] kyrc = {"user1", "user2", "user3", "user4", "user5"};


        for (int i = 0; i < 5; i++) {

            System.out.println("Введите ваше имя: ");
            name[i] = scan.nextLine();

            System.out.println("Ваш возраст: ");
            age[i] = scan.nextInt();
            scan.nextLine(); // для очистки буфера


            System.out.println("Введите вашу почту ");
            mail[i] = scan.nextLine();

            System.out.println("Название университета ");
            unst[i] = scan.nextLine();

            System.out.println("Курс обучения ");
            kyrc[i] = scan.nextLine();
            System.out.println();

        }
        String long_name = name[0];
        for (String names : name) {
            if (names.length() > long_name.length()) {
                long_name = names;
            }

            int user_age = 0;
            for (int ages : age) {
                user_age += ages;
            }
            double averageGe = user_age / 5.0;
            System.out.println("Самое длинное имя: " + long_name);
            System.out.println("Средний возраст: " + user_age);


            System.out.print("Все почты до значка '@': ");
            for (String email : mail) {
                String emails = email.split("@")[0];
                System.out.println(emails + "");
            }
            System.out.print(Arrays.toString(unst));
            System.out.print(Arrays.toString(kyrc));


        }
    }
}