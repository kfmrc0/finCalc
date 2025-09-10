public class EarningsMultiplier {

    public static String formatPERatio (String ticker, double stockPrice, double eps) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n--- P/E Ratio Calculation ---\n");
        sb.append(String.format("Ticker: %s%n", ticker));
        sb.append(String.format("Stock Price: $%.2f%n", stockPrice));
        sb.append(String.format("EPS: %.2f%n", eps));

        double peRatio = stockPrice / eps;
        sb.append(String.format("P/E Ratio: %.2f%n", peRatio));
        sb.append("-----------------------------");

        return sb.toString();
    }

    public static String formatIntrinsicValue (String ticker, double stockPrice, double eps, double peRatio) {
        StringBuilder sb = new StringBuilder();


        return ticker;
    }

}
