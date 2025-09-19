public class WeightedAverageCostOfCapital {

    public static String formatWACC (String ticker, double stockPrice, double interestExpense, double totalDebt, double incomeTaxExpense, double incomeBeforeTax,
                                     double beta, double marketReturn, double riskFreeRate) { // continue later
        double costOfDebt = interestExpense / totalDebt;
        double effectiveTaxRate = incomeTaxExpense / incomeBeforeTax;
        double costOfDebtAfterTax = costOfDebt * (1 - effectiveTaxRate);

        double costOfEquity = riskFreeRate + beta * (marketReturn - riskFreeRate);

        return String.format("""
                \n--- WACC Calculation ---
                Ticker: %s
                Stock Price: $%.2f
                -----------------------------
                """, ticker, stockPrice);
    }
}
