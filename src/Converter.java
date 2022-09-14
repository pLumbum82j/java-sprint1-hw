public class Converter {
    int cal = 50; // 1 шаг равен 50 калорий
    int oneStep = 75; // 1 шаг равен 75см

    // Конвертируем шаги в километры
    double convertKm(double nSteps) {
        return nSteps * oneStep / 100 / 1000;
    }
    // Конвертируем шаги в килокалории
    double convertCal(double nSteps) {
        return nSteps * cal / 1000;
    }
}
