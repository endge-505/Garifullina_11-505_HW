import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: "); //1
        String palid = scan.nextLine();
        System.out.println("Палиндром: " + isPalindrome(palid));
        System.out.println("Введите строку с повторяющимися символами: "); //2
        String rem = scan.nextLine();
        System.out.println("Строка без повторяющихся символов: " + removerepeatsimb(rem));
        System.out.println("Введите строку: "); //3
        String fin = scan.nextLine();
        System.out.println("Первый неповторяющийся символ: " + findfirstsimb(fin));
        System.out.println("Введите слово, в котором есть буква а: "); //4
        String simb = scan.nextLine();
        System.out.println("Изменённая строка: " + replacesimb(simb));
        System.out.println("Введите предложение: "); //5
        String pred = scan.nextLine();
        System.out.println("Количество слов: " + count_word(pred));
        System.out.println("Введите две строки: "); //6
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println("Строки равны: " + reg(str1, str2));
        System.out.println("Введите номер телефона (необязательно вводить свой): "); //7
        String phone = scan.nextLine();
        System.out.println("Корректный номер: " + cheknumb(phone));
        System.out.println("Введите строку вместе с числами (можно вводить строку без пробелов): "); //8
        String probel = scan.nextLine();
        findnumb(probel);
        System.out.println("Введите строку с несколькими пробелами: "); //9
        String probel2 = scan.nextLine();
        System.out.println("Строка с одним пробелом: " + replaceprob(probel2));
        System.out.println("Введите почту (необязательно вводить свою): "); //10
        String mail = scan.nextLine();
        System.out.println("Валидный email: " + val(mail));  // Добавлен вывод
        System.out.println("Введите название товара:" ); //11
        String n_pr = scan.nextLine();
        System.out.println("Введите цену товара: ");
        double pr_n = Double.parseDouble(scan.nextLine());  // Преобразовано в double
        System.out.println(formatnameprice(n_pr, pr_n));  // Добавлен вывод
        System.out.println("Введите строки через пробел: "); //12
        String mass = scan.nextLine();
        String[] arr = mass.split("\\s+");  // Разбито на массив
        System.out.println(join(arr));  // Добавлен вывод
    }

    // 1. Проверка на палиндром
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversedStr);
    }

    // 2. Удаление повторяющихся символов
    public static String removerepeatsimb(String str) {
		StringBuilder result = new StringBuilder();
		for (char c : str.toCharArray()) {
          if (result.indexOf(String.valueOf(c)) == -1) {
              result.append(c);
			}
		}
      return result.toString();
	}

    // 3. Поиск первого неповторяющегося символа
    public static Character findfirstsimb(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return null;
    }

    // 4. Замена 'a' на '@'
    public static String replacesimb(String str) {
        return str.replace('a', '@');
    }

    // 5. Подсчет количества слов
    public static int count_word(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // 6. Сравнение строк без учета регистра
    public static boolean reg(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    // 7. Проверка формата российского номера телефона
    public static boolean cheknumb(String phone) {
        return phone.matches("^(\\+7\\s?\\d{3}\\s?\\d{3}-\\d{2}-\\d{2}|8\\d{10})$");
    }

    // 8. Поиск и вывод всех чисел из текста
    public static void findnumb(String numb) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(numb);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 9. Замена нескольких пробелов на один
    public static String replaceprob(String str) {
        return str.replaceAll("\\s{2,}", " ");
    }

    // 10. Валидация email с помощью regex
    public static boolean val(String email) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        return pattern.matcher(email).matches();
    }

    // 11. Форматирование имени и цены
    public static String formatnameprice(String name, double price) {
        return String.format("Товар: %s, Цена: %.2f руб.", name, price);
    }

    // 12. Объединение строк из массива с разделителем
    public static String join(String[] arr) {
        return String.join("; ", arr);
    }
}
