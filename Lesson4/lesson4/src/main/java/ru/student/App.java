package ru.student;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Task1.run();
        Task2 customQueue = new Task2();
        queueStarter(customQueue);
    }

    private static void queueStarter(Task2 customQueue) {
        System.out.println(
                "Для добавления элемента в очередь используйте команду add. Например add 8 добавит элеьете 8 в конц очереди\nКоманда remove удалит первый элемент из очереди.\nКоманда first покажет какой сейчас первый элемент не удаляя его\nВведите команду q для выхода из программы");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.printf("Текущая очередь = %s\n", customQueue.toCustomStrig());
            System.out.print("Введите следущую команду: ");
            String request = scan.nextLine();

            if (request.startsWith("add")) {
                String[] argsArray = request.split(" ");
                if (Helper.isDigit(argsArray[argsArray.length - 1]))
                    customQueue.enqueue(Integer.parseInt(argsArray[argsArray.length - 1]));
                else
                    System.out.printf("Аргументом команды add должно быть целое число. Вы ввели %s\n", request);
            } else if (request.equals("remove")) {
                int el = customQueue.dequeue();
                if (el == -1)
                    continue;
                System.out.printf("Элемент %d был удален из очереди\n", el);
            } else if (request.equals("first")) {
                int firstEl = customQueue.first();
                System.out.printf("Первый элемент в очереди = %d\n", firstEl);
            } else if (request.equals("q")) {
                scan.close();
                System.out.println("Программа завершила свою работу");
                return;
            } else
                System.out.println("неизвестная команда. Попробуйте снова.");
            System.out.println();

        }
    }
}
