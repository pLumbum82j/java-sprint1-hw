public class StepTracker {
    MonthData[] monthToData;

    int monthNum;
    int daysNum;
    int taregetDay;


    public StepTracker() {
        monthNum = 12;
        daysNum = 30;
        taregetDay = 10000;

        monthToData = new MonthData[monthNum];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    boolean inStepDay(int month, int day, int step) {
        int stepWrite = monthToData[month].days[day];
        if (stepWrite == 0) {
            monthToData[month].days[day] = step;
            return true;
        } else {
            return false;
        }
    }

    void printMonthStat(int month) {
        int[] days = monthToData[month].days;

        for (int i = 0; i < days.length; i++) {
            System.out.print(i + 1 + " день: " + days[i] + ", ");
        }
        System.out.println("");
        int monthStep = 0;
        for (int i = 0; i < days.length; i++) {
            monthStep = monthStep + days[i];
        }
        System.out.println("Общее количество шагов за " + month + " месяц: " + monthStep);

        int maxStep = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxStep) {
                maxStep = days[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в " + month + " месяце составило: " + maxStep);

        double midStep = 0;
        for (int i = 0; i < days.length; i++) {
            midStep = midStep + days[i];
        }
        midStep = midStep / days.length;
        System.out.println("Срееднее количество шагов в месяце " + month + " составило: " + midStep);

        System.out.println("Лучшая серия: максимальное количество подряд идущих дней: " + bestSeries(month));

    }

    int bestSeries(int month) {
        int[] days = monthToData[month].days;

        int maxSeries = 0;
        int curSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] == 0) {
                curSeries = 0;
            } else {
                curSeries++;
            }
            if (curSeries > maxSeries){
                maxSeries = curSeries;
            }
        }
        return maxSeries;
    }


    class MonthData {
        int[] days;

        MonthData() {
            days = new int[daysNum];
            for (int i = 0; i < days.length; i++) {
            }
        }
    }
}
