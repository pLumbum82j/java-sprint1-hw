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

    class MonthData {
        int[] days;

        MonthData() {
            days = new int[daysNum];
            for (int i = 0; i < days.length; i++) {
            }
        }
    }
}

/*

    void getMothStep() {
        int monthStep = 0;
        for (int i = 0; i < day.length; i++) {
            monthStep = monthStep + day[i];
        }
        System.out.println("Всего шагов за месяц" + monthStep);
    }

    void getMaxStep() {
        int maxStep = 0;
        for (int i = 0; i < day.length; i++) {
            if (day[i] > maxStep) {
                maxStep = day[i];
            }
        }
        System.out.println("Максимальное кол-во шагов за месяц составило: " + maxStep);
    }

    void getMidStep() {
        double midStep = 0;
        for (int i = 0; i < day.length; i++) {
            midStep = midStep + day[i];
        }
        midStep = midStep / day.length;
        System.out.println("Срееднее кол-во шагов в месяце составило: " + midStep);
    }

 */