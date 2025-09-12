import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Menu Board
            System.out.println("\n----- Financial Calculator -----");
            System.out.println("1. Discounted Cash Flow");
            System.out.println("2. Weighted Average Cost of Capital");
            System.out.println("3. Earnings Multiplier");
            System.out.println("4. Dividend Discount Model");
            System.out.println("5. Information");
            System.out.println("6. Exit");
            System.out.println("--------------------------------");

            int choice = InputHelper.getInt("Please choose an option (1-6): ");

            switch (choice) {
                case 1 -> {
                    DiscountedCashFlow.test();
                    isRunning = false; // temporary until implemented fully
                }
                case 2 -> {
                    WeightedAverageCostOfCapital.test();
                    isRunning = false;
                }
                case 3 -> {
                    boolean stayIn = true;

                    while (stayIn) {
                        System.out.println("\n\n--- Earnings Multiplier Model ---");
                        System.out.println("1. Calculate P/E Ratio");
                        System.out.println("2. Calculate Intrinsic Value");
                        System.out.println("---------------------------------");

                        int subChoice = InputHelper.getInt("Choose an option (1-2): ");
                        String output = "";

                        switch (subChoice) {
                            case 1 -> {
                                System.out.println();
                                String ticker = InputHelper.getTickerSymbol("Enter the ticker symbol: ");
                                double stockPrice = InputHelper.getDouble("Enter the current stock price: ");
                                double eps = InputHelper.getDouble("Enter the earnings per share (EPS): ");
                                output = EarningsMultiplier.formatPERatio(ticker, stockPrice, eps);
                            }
                            case 2 -> {
                                System.out.println();
                                String ticker = InputHelper.getTickerSymbol("Enter the ticker symbol: ");
                                double stockPrice = InputHelper.getDouble("Enter the current stock price: ");
                                double eps = InputHelper.getDouble("Enter the earnings per share (EPS): ");
                                double peRatio = InputHelper.getDouble("Enter your desired P/E Ratio: ");
                                output = EarningsMultiplier.formatIntrinsicValue(ticker, stockPrice, eps, peRatio);
                            }
                            default -> {
                                System.out.println("Invalid option. Please enter 1 or 2.");
                                continue;
                            }
                        }

                        System.out.println(output);

                        while (true) {
                            System.out.print("Return to main menu? (enter 'yes' to return): ");
                            String response = scanner.nextLine().trim().toLowerCase();
                            if (response.equals("yes")) {
                                stayIn = false;
                                break;
                            }
                            System.out.println(output);
                        }
                    }
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
        scanner.close();
    }
}