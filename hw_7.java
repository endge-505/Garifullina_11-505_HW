import java.util.Random;
import java.util.Scanner;

public class hw_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Какие примеры по уровню сложности вы хотите: легкие или сложные (easy / hard)?");
        String uroven = scanner.nextLine();

        System.out.println("Сколько примеров хотите порешать?");
        int kol_vopr = scanner.nextInt();
        scanner.nextLine();

        int oper = 1;
        if (uroven.equalsIgnoreCase("hard")) {
            System.out.println("Какое количество операций хотите, чтоб было в примере?");
            oper = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Хотите ли ввести свои примеры? (yes/no)");
        String answer = scanner.nextLine();
        boolean use = answer.equalsIgnoreCase("yes");
        boolean solv = false;
        if (use) {
            System.out.println("Хотите ли прорешать свои примеры или сгенерировать их? (yes - свои /no - сгенерировать)");
            solv = scanner.nextLine().equalsIgnoreCase("yes");
        }

        for (int i = 0; i < kol_vopr; i++) {
            String expr;
            double correct;

            if (use && solv) {
                System.out.println("Введите пример (например: 2 + 3 * 4):");
                expr = scanner.nextLine();
                correct = val(expr);
            } else {
                int[] nums;
                String[] ops;
                if (uroven.equalsIgnoreCase("easy")) {
                    nums = new int[2];
                    nums[0] = random.nextInt(15) + 1;
                    nums[1] = random.nextInt(15) + 1;
                    ops = new String[1];
                    ops[0] = random.nextBoolean() ? "+" : "-";
                } else {
                    nums = new int[oper + 1];
                    ops = new String[oper];
                    for (int j = 0; j < nums.length; j++) {
                        nums[j] = random.nextInt(20) + 1;
                    }
                    for (int j = 0; j < ops.length; j++) {
                        int opType = random.nextInt(3);
                        if (opType == 0) ops[j] = "+";
                        else if (opType == 1) ops[j] = "-";
                        else ops[j] = "*";
                    }
                }

                StringBuilder simb = new StringBuilder();
                simb.append(nums[0]);
                for (int j = 0; j < ops.length; j++) {
                    simb.append(" ").append(ops[j]).append(" ").append(nums[j + 1]);
                }
                simb.append("= ?");
                expr = simb.toString();
                String va_xpr = expr.substring(0, expr.indexOf("= ?")).trim();
                correct = val(va_xpr);
                System.out.println("Пример: " + expr);
            }

            System.out.println("Ваш ответ:");
            String ansStr = scanner.nextLine().replace(',', '.');
            double user_a = Double.parseDouble(ansStr);

            // Исправление логики сравнения
            if (Math.abs(user_a - correct) < 1e-5) {
                System.out.println("Правильно!");
            } else {
                System.out.println("Неправильно. Правильный ответ: " + correct);
            }
        }
        System.out.println("Примеры закончились :( ");
    }

    public static double val(String expr) {
        String clean_ex = expr.replaceAll("\\s+", "");
        double result = 0;
        String numberStr = "";
        char lastOp = '+'; // Для первого числа

        for (int i = 0; i < clean_ex.length(); i++) {
            if (Character.isDigit(clean_ex.charAt(i)) || clean_ex.charAt(i) == '.') {
                numberStr += clean_ex.charAt(i);
            } else {
                // случай когда встретился оператор
                if (!numberStr.isEmpty()) {
                    double num = Double.parseDouble(numberStr);
                    switch (lastOp) {
                        case '+':
                            result += num;
                            break;
                        case '-':
                            result -= num;
                            break;
                        case '*':
                            result *= num;
                            break;
                        case '/':
                            if (num != 0) { // Проверяем деление на ноль
                                result /= num;
                            } else {
                                System.out.println("Ошибка: деление на ноль!");
                                return Double.NaN; // Возвращаем NaN в случае деления на ноль
                            }
                            break;
                    }
                    numberStr = "";
                }
                lastOp = clean_ex.charAt(i);
            }
        }

        // Обрабатываем последнее число
        if (!numberStr.isEmpty()) {
            double num = Double.parseDouble(numberStr);
            switch (lastOp) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                case '/':
                    if (num != 0) {
                        result /= num;
                    } else {
                        System.out.println("Ошибка: деление на ноль!");
                        return Double.NaN;
                    }
                    break;
            }
        }
        return result;
    }
}