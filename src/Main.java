import java.time.Year;

public class Main {
    public static void main(String[] args) {

        DiscountedCashFlow.test();
        DividendDiscountModel.test();
        EarningsMultiplier.test();
        WeightedAverageCostOfCapital.test();

        System.out.println(Year.now()); // test

    }
}