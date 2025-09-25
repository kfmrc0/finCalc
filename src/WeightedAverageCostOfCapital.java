public class WeightedAverageCostOfCapital {

    public static String formatWACC (String ticker, double marketCap, double interestExpense, double totalDebt, double incomeTaxExpense,
                                     double incomeBeforeTax, double beta, double marketReturn, double riskFreeRate) { // here

        double costOfDebt = interestExpense / totalDebt;
        double effectiveTaxRate = incomeTaxExpense / incomeBeforeTax;
        double costOfDebtAfterTax = costOfDebt * (1 - effectiveTaxRate); // calculated valuables that result in percentage need to be fixed wacc

        double costOfEquity = riskFreeRate + beta * (marketReturn - riskFreeRate);

        double DEtotal = totalDebt + marketCap;
        double DEtotalDebt = totalDebt / DEtotal;
        double DEmarketCap = marketCap / DEtotal;
        double WACC = (costOfDebt * DEtotalDebt) + (costOfEquity * DEmarketCap);


        return String.format("""
                \n--- WACC Calculation ---
                Ticker: %s
                WACC: %.2f%%
                -----------------------------
                """, ticker, WACC * 100);
    }
}
