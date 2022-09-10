public class StepTracker {
    Converter converter = new Converter();  // Создаём объект класса converter
    MonthData[] monthToData;

    int monthNum;
    int daysNum;
    int oneStep;
    int taregetDay;
    int cal;


    public StepTracker() {
        monthNum = 12; // Количество месяцев 12
        daysNum = 30; // Количество дней в месяце 30
        oneStep = 75; // 1 шаг равен 75см
        taregetDay = 10000; // Цель на день 10000
        cal = 50; // 1 шаг равен 50 калорий

        // Массив месяцев
        monthToData = new MonthData[monthNum];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Запись шагов в определённый день месяца
    boolean inStepDay(int month, int day, int step) {
        int stepWrite = monthToData[month].days[day];
        if (stepWrite == 0) { // Проверка, есть ли в определенный день какое-либо значение
            monthToData[month].days[day] = step;
            return true;
        } else {
            return false;
        }
    }

    // Вывод на экран информации за определённый месяц
    void printMonthStat(int month) {
        int[] days = monthToData[month].days;

        // Выводим в консоль массив дней с количеством шагов за определённый месяц
        for (int i = 0; i < days.length; i++) {
            System.out.print(i + 1 + " день: " + days[i] + ", ");
        }
        System.out.println("");

        // Выводим в консоль общее количество шагов за определённый месяц
        int monthStep = 0;
        for (int i = 0; i < days.length; i++) {
            monthStep = monthStep + days[i];
        }
        System.out.println("Общее количество шагов за " + month + " месяц: " + monthStep);

        // Выводим в консоль максимальное количество шагов за определённый месяц
        int maxStep = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxStep) {
                maxStep = days[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в " + month + " месяце составило: " + maxStep);

        // Выводим в консоль среднее количество шагов за определённый месяц
        double midStep = 0;
        for (int i = 0; i < days.length; i++) {
            midStep = midStep + days[i];
        }
        midStep = midStep / days.length;
        System.out.println("Срееднее количество шагов в месяце " + month + " составило: " + midStep);

        // Выводим в консоль конвертируемые значения за определённый месяц
        System.out.println("Пройденная дистанция (в км): " + converter.convertKm(monthStep, oneStep));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertCal(monthStep, cal));

        // Выводим в консоль лучшую серию подряд идущих шагов за определённый месяц
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней: " + bestSeries(month));

        // Выводим в консоль информацию по цели шагов за один день
        System.out.println("Ваша ежедневная цель по шагам равна " + taregetDay + " шагов");
    }

    // Вывод на экран информации за определённый день
    void printDayStat(int month, int day) {
        // Выводим в консоль количество шагов за определённый день с проверкой на ежедневную цель
        int daysStep = monthToData[month].days[day];
        System.out.println("В " + month + " месяце, за " + day + 1 + " день пройдено: " + daysStep);
        if (daysStep > taregetDay) {
            System.out.println("Ваша ежедневная цель по шагам в этот день выполнена");
        } else {
            System.out.println("Ваша ежедневная цель по шагам в этот день не выполнена");
        }
        // Выводим в консоль информацию по цели шагов за один день
        System.out.println("Ваша ежедневная цель по шагам равна " + taregetDay + " шагов");

        // Выводим в консоль конвертируемые значения за определённый день
        System.out.println("Пройденная дистанция (в км): " + converter.convertKm(daysStep, oneStep));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertCal(daysStep, cal));
    }

    // Запись новой цели шагов за один день изменённой пользователем
    int changeTrgetStep(int target) {
        return taregetDay = target;
    }

    // Поиск лучшей серии подряд идущих шагов за определённый месяц
    int bestSeries(int month) {
        int[] days = monthToData[month].days;

        int maxSeries = 0;
        int curSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= taregetDay) {
                curSeries++;
            } else {
                curSeries = 0;
            }
            if (curSeries > maxSeries) {
                maxSeries = curSeries;
            }
        }
        return maxSeries;
    }


    class MonthData {

        int[] days;

        MonthData() {
            // Массив дней
            days = new int[daysNum];
            for (int i = 0; i < days.length; i++) {
            }
        }
    }
}
