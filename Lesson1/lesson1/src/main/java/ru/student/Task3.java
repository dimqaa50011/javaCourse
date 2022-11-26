package ru.student;

import java.util.Scanner;

public class Task3 {
    public static void runTask() {
        Scanner scan = new Scanner(System.in);
        String operation;
        int num1 = inputArg("Введите первое число", scan);
        int num2 = inputArg("Введите второе число", scan);
        System.out.print("Введите операцию +, -, *, / : ");
        operation = scan.next();
        scan.close();
        int result = calculator(num1, num2, operation);
        System.out.printf("Результат вычислений: %d %s %d = %d\n", num1, operation, num2, result);

    }

    private static int calculator(int num1, int num2, String operation) {
        int result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                try {
                    result = num1 / num2;
                } catch (ArithmeticException e) {
                    System.out.println("!!! Нелья делить на ноль !!!");
                    break;
                } finally {
                    result = 0;
                }

            default:
                result = 0;
        }
        return result;
    }

    private static int inputArg(String msg, Scanner scan) {
        System.out.printf("%s : ", msg);
        return scan.nextInt();
    }
}
