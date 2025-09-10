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

            // User Prompt
            System.out.print("\nPlease choose an option (1-6): ");
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
                        boolean stayIn = true;
                        String output = "";

                        while (stayIn) {
                            System.out.println("\n--- Earnings Multiplier Model ---");
                            System.out.println("1. Calculate P/E Ratio");
                            System.out.println("2. Calculate Intrinsic Value");
                            System.out.println("---------------------------------");
                            System.out.print("Choose an option (1-2): ");

                            try {
                                int subChoice = Integer.parseInt(scanner.nextLine().trim());

                                switch (subChoice) {
                                    case 1 -> {
                                        System.out.print("Enter the ticker symbol: ");
                                        String ticker = scanner.nextLine().trim();

                                        System.out.print("Enter the current stock price: ");
                                        double stockPrice = Double.parseDouble(scanner.nextLine().trim());

                                        System.out.print("Enter the earnings per share (EPS): ");
                                        double eps = Double.parseDouble(scanner.nextLine().trim());

                                        output = EarningsMultiplier.formatPERatio(ticker, stockPrice, eps);
                                    }
                                    case 2 -> {
                                        System.out.print("Enter the ticker symbol: ");
                                        String ticker = scanner.nextLine().trim();

                                        System.out.print("Enter the current stock price: ");
                                        double stockPrice = Double.parseDouble(scanner.nextLine().trim());

                                        System.out.print("Enter the earnings per share (EPS): ");
                                        double eps = Double.parseDouble(scanner.nextLine().trim());

                                        System.out.print("Enter your desired P/E Ratio: ");
                                        double peRatio = Double.parseDouble(scanner.nextLine().trim());

                                        output = EarningsMultiplier.formatIntrinsicValue(ticker, stockPrice, eps, peRatio);
                                    }
                                    default -> {
                                        System.out.println("Invalid option. Please enter 1 or 2.");
                                    }
                                }
                            }
                            catch (Exception e) {
                                System.out.println("Invalid input! Please enter a number (1-2).");
                                continue;
                            }
                            while (true) {
                                System.out.println(output);
                                System.out.print("Return to main menu? (enter 'yes' to return): ");
                                String response = scanner.nextLine().trim().toLowerCase();

                                if (response.equals("yes")) {
                                    stayIn = false;
                                    break;
                                }
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