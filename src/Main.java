import java.util.Scanner;

        // Вроде что-то накодил из своей головы.
        // Приятно с Вами познакомиться мой ревьювер!

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker(); // Создаём объект класса stepTracker
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu(); // Выводим меню
            int userInput = scanner.nextInt(); // Получаем значение от пользователя
            if (userInput == 1) {
                System.out.println("Вы выбрали: Добавление кол-ва шагов за определенный день");
                System.out.println("Введите месяц (начиная с нуля)");
                int month = getInt();
                while (month > 11) {
                    System.out.println("Вы ввели число больше, чем месяцев, введите число от 0 до 11");
                    month = getInt();
                }
                System.out.println("Введите день");
                int day = getInt();
                while (day > 30) {
                    System.out.println("Вы ввели число больше, чем дней в месяце, введите число от 1 до 30");
                    day = getInt();
                }
                System.out.println("Введите кол-во шагов");
                int step = getInt();
                boolean isSuccses = stepTracker.inStepDay(month, day - 1, step);
                if (isSuccses) {
                    System.out.println("Данные по шагам за месяц: " + month + ", день: " + day + " - записаны");
                } else {
                    System.out.println("Данные за этот день уже есть");
                }
            } else if (userInput == 2) {
                System.out.println("Вы выбрали: Вывод статистика шагов за месяц");
                System.out.println("Введите месяц (начиная с нуля)");
                int month = getInt();
                while (month > 11) {
                    System.out.println("Вы ввели число больше, чем месяцев, введите число от 0 до 11");
                    month = getInt();
                }
                stepTracker.printMonthStat(month);
            } else if (userInput == 3) {
                System.out.println("Вы выбрали: Вывод статистика шагов за день");
                System.out.println("Введите месяц (начиная с нуля)");
                int month = getInt();
                while (month > 11) {
                    System.out.println("Вы ввели число больше, чем месяцев, введите число от 0 до 11");
                    month = getInt();
                }
                System.out.println("Введите день");
                int day = getInt();
                while (day > 30) {
                    System.out.println("Вы ввели число больше, чем дней в месяце, введите число от 1 до 30");
                    day = getInt();
                }
                stepTracker.printDayStat(month, day - 1);
            } else if (userInput == 4) {
                System.out.println("вы выбрали изменение цели по количеству шагов в день");
                System.out.println("Текущая цель шагов в день состовляет: " + stepTracker.taregetDay);
                int targt = getInt();
                System.out.println("Теперь цель шагов в день состовляет: " + stepTracker.changeTrgetStep(targt));
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                return;
            } else {
                System.out.println("Вы ввели несуществующее значение");
            }
        }

    }

    public static int getInt() { // Проверка на отрицательное значение
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