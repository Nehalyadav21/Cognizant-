public class Exercise7Main {

    public static void main(String[] args) {

        double initialValue = 10000.0;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue = FinancialForecast.forecast(initialValue, growthRate, years);

        System.out.println("Initial Value : " + initialValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.printf("Forecast Value: %.2f%n", futureValue);
    }
}