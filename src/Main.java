import java.time.Year;

public class Main {
    public static void main(String[] args) {

        DividendDiscountModel.test();
        EarningsMultiplier.test();
        WeightedAverageCostOfCapital.test();

        System.out.println(Year.now()); // test

    }
}