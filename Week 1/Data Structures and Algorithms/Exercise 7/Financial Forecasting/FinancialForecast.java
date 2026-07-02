public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecast(double initialValue, double growthRate, int years) {

        // Base case
        if (years == 0) {
            return initialValue;
        }

        // Recursive case
        return forecast(initialValue, growthRate, years - 1) * (1 + growthRate);
    }
}