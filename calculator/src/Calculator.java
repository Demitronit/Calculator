import java.util.Scanner;

public class Calculator {
    private static double[] results = new double[100];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Введите операцию (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            double result = calculate(operation, num1, num2);
            System.out.println("Результат: " + result);

            saveResult(result);

            System.out.print("Вычислить факториал? (да/нет): ");
            String calculateFactorial = scanner.next();
            if (calculateFactorial.equalsIgnoreCase("да")) {
                System.out.print("Введите число для вычисления факториала: ");
                int number = scanner.nextInt();
                long factorialResult = calculateFactorial(number);
                System.out.println("Факториал числа " + number + ": " + factorialResult);
            }

            System.out.print("Хотите продолжить? (да/нет): ");
        } while (scanner.next().equalsIgnoreCase("да"));

        scanner.close();
    }

    private static double calculate(char operation, double num1, double num2) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль");
                    return 0;
                }
            default:
                System.out.println("Ошибка: неверная операция");
                return 0;
        }
    }

    private static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    private static void saveResult(double result) {
        for (int i = 0; i < results.length; i++) {
            if (results[i] == 0) {
                results[i] = result;
                break;
            }
        }
    }
}