import java.util.Scanner;

/**
 * «Счётчик калорий»
 *
 * @version 1.2
 * @autor Смирнов Илья
 */
public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker(); // Создаём объект класса stepTracker
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu(); // Выводим меню
            int userInput = scanner.nextInt(); // Получаем значение от пользователя
            switch (userInput) {
                case 1:
                    case1(stepTracker);
                    break;
                case 2:
                    case2(stepTracker);
                    break;
                case 3:
                    case3(stepTracker);
                    break;
                case 4:
                    case4(stepTracker);
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Вы ввели несуществующее значение");
            }
        }
    }

    // Проверка на отрицательное значение
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        while (value < 0) {
            value = scanner.nextInt();
            if (value < 0) {
                System.out.println("Вы ввели отрицательное число. Введите положительное значение");
            }
        }
        return value;
    }

    // Меню #1 - Добавление шагов
    public static void case1(StepTracker stepTracker) {
        System.out.println("Вы выбрали: Добавление кол-ва шагов за определенный день");
        System.out.println("Введите месяц");
        int month = getInt();
        while (month > 11 || month < 1) {
            errorMonth();
            month = getInt();
        }
        System.out.println("Введите день");
        int day = getInt();
        while (day > 30 || day < 1) {
            errorDay();
            day = getInt();
        }
        System.out.println("Введите кол-во шагов");
        int step = getInt();
        boolean isSuccses = stepTracker.inStepDay(month - 1, day - 1, step);
        if (isSuccses) {
            System.out.println("Данные по шагам за месяц: " + month + ", день: " + day + " - записаны");
        } else {
            System.out.println("Данные за этот день уже есть");
        }
    }

    // Меню #2 - Статистика шагов за месяц
    public static void case2(StepTracker stepTracker) {
        System.out.println("Вы выбрали: Вывод статистика шагов за месяц");
        System.out.println("Введите месяц");
        int month = getInt();
        while (month > 11 || month < 1) {
            errorMonth();
            month = getInt();
        }
        stepTracker.printMonthStat(month - 1);
    }

    // Меню #3 - Статистика шагов за день
    public static void case3(StepTracker stepTracker) {
        System.out.println("Вы выбрали: Вывод статистика шагов за день");
        System.out.println("Введите месяц");
        int month = getInt();
        while (month > 11 || month < 1) {
            errorMonth();
            month = getInt();
        }
        System.out.println("Введите день");
        int day = getInt();
        while (day > 30 || day < 1) {
            errorDay();
            day = getInt();
        }
        stepTracker.printDayStat(month - 1, day - 1);
    }

    // Меню #4 - Изменение цели по количеству шагов в день
    public static void case4(StepTracker stepTracker) {
        System.out.println("Вы выбрали изменение цели по количеству шагов в день");
        System.out.println("Текущая цель шагов в день составляет: " + stepTracker.taregetDay);
        int targt = getInt();
        System.out.println("Теперь цель шагов в день составляет: " + stepTracker.changeTrgetStep(targt));
    }

    // Метод ошибки при неправильном значении месяцев
    public static void errorMonth() {
        System.out.println("Вы ввели неправильное значение, введите число от 1 до 11");
    }

    // Метод ошибки при неправильном значении дней
    public static void errorDay() {
        System.out.println("Вы ввели неправильное значение, введите число от 1 до 30");
    }

    // Меню
    private static void printMenu() {
        System.out.println("");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Напечатать статистику за определённый день");
        System.out.println("4 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
} 