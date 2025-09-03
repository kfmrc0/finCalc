import java.util.HashMap;

public class DiscountedCashFlow {

    public static void test() {
        System.out.println("1. dcf received");
    }

    // variables ----
    int numOfYearsData = 0;

    HashMap<Integer, Integer> yearData = new HashMap<>();
    // (year/data) pair

    HashMap<Integer, Double> YoYGrowth = new HashMap<>();
    // (year, growth rate) pair

    double averageGrowthRateYoY = 0.0;
    // avg of all growth rate

    double conservativeGrowth = 0.0;
    // conservative growth rate




}
    // -------------------------------------------------------------------------------------------------------------------
    // example:      https://www.macrotrends.net/stocks/charts/AAPL/apple/free-cash-flow


    // -------------------------------------------------------------------------------------------------------------------
    // enter number of years of data: #
        // # of years prior to current year
        // user input of free cash flows, double

            // YoY growth rate formula:
            // growthRateForYear# = (yearFcf - yearBeforeFcf) / yearBeforeFcf
            // averageGrowthRateYoY  = (all YoY growthRates combined) / (num of years - 1)


    // -------------------------------------------------------------------------------------------------------------------
    // show avg growthRate
        // prompt for a more conservative growth rate, double


    // -------------------------------------------------------------------------------------------------------------------
    // project future free cash flows
        // start at current year + 9 more years = 10 future free cash flow projections

            // ffcf formula:
            // futureFreeCashFlowYear# = (yearBeforeFcf * (1 + conservativeGrowthRate)
                // for ten years


    // -------------------------------------------------------------------------------------------------------------------
    // terminal value
        // sum of all ffcf past 10 years of projection, remaining lifespan of business

        // perpetual growth rate & discount rate
            // perpetual = typically the rate of economy (2.5, fluctuates)
            // discount  = WACC

            // TV formula:
            // terminalValue = futureFreeCashFlowYear10 * (1 + perpetualGrowthRate) / (discountRate - perpetualGrowthRate)


    // -------------------------------------------------------------------------------------------------------------------
    // present value for ffcf
        // formula:
            // presentValueFutureFreeCashFlow = FFCFYear# / (1 + discountRate) ^ #
                // for ten years


    // -------------------------------------------------------------------------------------------------------------------
    // remaining numbers
        // sum of all pv ffcf = just add the pv ffcf  (10 years)

    // just go on yahoo finance for this stuf
        // cash and cash equivalents = asset in balance sheet
        // total debt = total debt in balance sheet
            // equity value = sumPvFFCF  + cash & cash equivalents - debt

        // shares outstanding = find this on a stock statistics list


    // -------------------------------------------------------------------------------------------------------------------
    // dcf price per share formula

        // dcf formula:
            // dcf pps = equityVal / sharesOutstanding



