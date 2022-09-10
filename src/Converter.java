public class Converter {

    // Конвертируем шаги в километры
    double convertKm(double nSteps, int oneStep) {
        return nSteps * oneStep / 100 / 1000;
    }
    // Конвертируем шаги в килокалории
    double convertCal(double nSteps, int cal) {
        return nSteps * cal / 1000;
    }
}
