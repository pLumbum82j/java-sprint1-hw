import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("вы выбрали 1");
                System.out.println("Введите месяц (начиная с нуля)");
                int month = scanner.nextInt();
                System.out.println("Введите день");
                int day = scanner.nextInt();
                System.out.println("Введите кол-во шагов");
                int step = scanner.nextInt();
                System.out.println(stepTracker.monthToData[month]);
            } else if (userInput == 2) {
                System.out.println("вы выбрали 2");
            } else if (userInput == 3) {
                System.out.println("вы выбрали 3");
            } else if (userInput > 3) {
                System.out.println("Вы ввели несуществующее значение");
            }

            // обработка разных случаев

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
} 