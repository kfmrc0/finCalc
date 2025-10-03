public class WeightedAverageCostOfCapital {

    public static String formatWACC
            (String ticker,
             double marketCap,
             double interestExpense,
             double totalDebt,
             double incomeTaxExpense,
             double incomeBeforeTax,
             double beta,
             double marketReturn,
             double riskFreeRate) {

        // core calculations
        double costOfDebt = interestExpense / totalDebt; // testing this variable
        double effectiveTaxRate = incomeTaxExpense / incomeBeforeTax;
        double costOfDebtAfterTax = costOfDebt * (1 - effectiveTaxRate);

        double costOfEquity = riskFreeRate + beta * (marketReturn - riskFreeRate);

        double DEtotal = totalDebt + marketCap;
        double DEtotalDebt = totalDebt / DEtotal;
        double DEmarketCap = marketCap / DEtotal;

        double WACC = (costOfDebtAfterTax * DEtotalDebt) + (costOfEquity * DEmarketCap);


        return String.format("""
                \n--- WACC Calculation ---
                Ticker: %s
                
                Cost of Debt:           %.2f%%
                Effective Tax Rate:     %.2f%%
                After-Tax Cost of Debt: %.2f%%
                Cost of Equity:         %.2f%%
                
                Debt Weight:            %.2f%%
                Equity Weight:          %.2f%%
                
                WACC:                   %.2f%%
                -----------------------------
                """,
                ticker,
                costOfDebt * 100,
                effectiveTaxRate * 100,
                costOfDebtAfterTax * 100,
                costOfEquity * 100,
                DEtotalDebt * 100,
                DEmarketCap * 100,
                WACC * 100
        ); // show calculated variables too later
    }
}
