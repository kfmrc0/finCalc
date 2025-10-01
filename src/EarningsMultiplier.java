public class EarningsMultiplier {

    public static String formatPERatio
            (String ticker,
             double stockPrice,
             double eps) {

        // just a simple calculation for pe ratio
        double peRatio = stockPrice / eps;

        return String.format("""
                \n--- P/E Ratio Calculation ---
                Ticker: %s
                Stock Price: $%.2f
                EPS: %.2f
                P/E Ratio: %.2f
                -----------------------------
                """, ticker, stockPrice, eps, peRatio);
    }

    public static String formatIntrinsicValue
            (String ticker,
             double stockPrice,
             double eps,
             double peRatio) {

        // core calculations
        double intrinsicValue = eps * peRatio;
        double percentChange = ((intrinsicValue - stockPrice) / stockPrice) * 100;



        // change here
        return String.format("""
                \n--- Intrinsic Value Calculation ---
                Ticker: %s
                Stock Price: $%.2f
                EPS: %.2f
                Desired P/E Ratio: %.2f
                Intrinsic Value: $%.2f
                Percentage Change: %+.2f%%
                -----------------------------------
                """, ticker, stockPrice, eps, peRatio, intrinsicValue, percentChange);
    }

}
