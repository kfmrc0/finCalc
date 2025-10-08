public class DividendDiscountModel {

    public static String formatDDM
            (String ticker,
             double[] quarterlyDividends,
             double requiredReturn,
             double stockPrice) {

        int years = quarterlyDividends.length;

        double[] annualDividends = new double[years];
        for (int i = 0; i < years; i++) {
            annualDividends[i] = quarterlyDividends[i] * 4;
        }

        double[] growthRates = new double[years - 1];
        for (int i = 1; i < years; i++) {
            growthRates[i - 1] = (annualDividends[i] - annualDividends[i - 1]) / annualDividends[i - 1];
        }

        double avgGrowthRate = 0;
        for (double g : growthRates) {
            avgGrowthRate += g;
        }
        avgGrowthRate /= growthRates.length;

        double latestDividend = annualDividends[years - 1];
        double ddmPrice = latestDividend / (requiredReturn - avgGrowthRate);
        double percentDiff = ((ddmPrice - stockPrice) / stockPrice) * 100;

        return String.format("""
                \n--- DDM Calculation ---
                Ticker: %s
                Stock Price: $%.2f
                Average Dividend Growth: %.2f%%
                Intrinsic Value: $%.2f
                Percentage Change: %+.2f%%
                -----------------------------
                """, ticker, stockPrice, avgGrowthRate * 100, ddmPrice, percentDiff);
    }
}
