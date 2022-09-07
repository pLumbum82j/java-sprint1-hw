public class StepTracker {

    MonthData[] monthToData;
    void getMd(int month){
        System.out.println(monthToData[month]);
    }
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        // Заполните класс самостоятельно
        int[] day = new int[30];

        void monthDay() {
            for (int i = 0; i < day.length; i++) {
                System.out.print("День " + (i + 1) + ": " + day[i] + ", ");
            }
        }

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
        void getMidStep(){
            double midStep = 0;
            for (int i = 0; i < day.length; i++) {
                midStep = midStep + day[i];
            }
            midStep = midStep / day.length;
            System.out.println("Срееднее кол-во шагов в месяце составило: " + midStep);
        }
    }
}