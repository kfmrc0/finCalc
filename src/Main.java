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
                    boolean stayIn = true;
                    String output = "";

                    while (stayIn) {
                        System.out.println("\n\n--- Weighted Average Cost of Capital Model ---");
                        String ticker = InputHelper.getTickerSymbol("Enter the ticker symbol: ");
                        double marketCap = InputHelper.getDouble("Enter the market cap of " + ticker + ": ");
                        System.out.println("----------------------------------------------");

                        System.out.println("\n--- Cost of Debt ---");
                        double interestExpense = InputHelper.getDouble("Enter the interest expense of " + ticker + ": ");
                        double totalDebt = InputHelper.getDouble("Enter the total debt of " + ticker + ": ");
                        // cost of debt = interest expense / total debt
                        double incomeTaxExpense = InputHelper.getDouble("Enter the tax provision of " + ticker + ": ");
                        double incomeBeforeTax = InputHelper.getDouble("Enter the pretax income of " + ticker + ": ");
                        // effective tax rate = income tax expense / income before tax
                        // cost of debt after tax = cost of debt * (1 - effective tax rate)
                        System.out.println("--------------------");

                        System.out.println("\n--- Cost of Equity ---");
                        double beta = InputHelper.getDouble("Enter the beta of " + ticker + ": ");
                        double marketReturn = InputHelper.getDouble("Enter the expected return on the market (7% - 10%): ");
                        double riskFreeRate = InputHelper.getDouble("Enter the U.S. Treasury Yield on 10 Years (Risk Free Rate): ");
                        // cost of equity = (risk free rate) + (beta) * (market return - risk free rate)
                        System.out.println("----------------------");

                        output = WeightedAverageCostOfCapital.formatWACC(ticker, marketCap, interestExpense, totalDebt, incomeTaxExpense,
                                incomeBeforeTax, beta, marketReturn, riskFreeRate);

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
                                double eps = InputHelper.getDouble("Enter the earnings per share (EPS) of " + ticker + ": ");
                                output = EarningsMultiplier.formatPERatio(ticker, stockPrice, eps);
                            }
                            case 2 -> {
                                System.out.println();
                                String ticker = InputHelper.getTickerSymbol("Enter the ticker symbol: ");
                                double stockPrice = InputHelper.getDouble("Enter the current stock price: ");
                                double eps = InputHelper.getDouble("Enter the earnings per share (EPS) of " + ticker + ": ");
                                double peRatio = InputHelper.getDouble("Enter your desired P/E Ratio of " + ticker + ": ");
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