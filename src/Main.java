import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Menu Board
            System.out.println("----- Financial Calculator -----");
            System.out.println("1. Discounted Cash Flow");
            System.out.println("2. Weighted Average Cost of Capital");
            System.out.println("3. Earnings Multiplier");
            System.out.println("4. Dividend Discount Model");
            System.out.println("5. Information");
            System.out.println("6. Exit");
            System.out.println("--------------------------------");

            // User Prompt
            System.out.println("\nPlease choose an option (1-6): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        DiscountedCashFlow.test();
                        isRunning = false; // cases 1 - 5 temporarily have isRunning to false
                    }
                    case 2 -> {
                        WeightedAverageCostOfCapital.test();
                        isRunning = false;
                    }
                    case 3 -> {
                        EarningsMultiplier.test();
                        isRunning = false;
                    }
                    case 4 -> {
                        DividendDiscountModel.test();
                        isRunning = false;
                    }
                    case 5 -> {
                        Information.test();
                        isRunning = false;
                    }
                    case 6 -> {
                        System.out.println("Now exiting the Java program...");
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("""
                                \n!!!--------------------------------------!!!
                                Invalid option. Please enter a number (1-6).
                                !!!--------------------------------------!!!
                                """);
                    }
                }
            }
            catch (Exception e) {
                System.out.println("""
                        \n!!!--------------------------------------!!!
                        Invalid input!. Please enter a number (1-6).
                        !!!--------------------------------------!!!
                        """);
            }
        }
        scanner.close();
    }
}