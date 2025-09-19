import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid integer.");
            }
        }
    }

    public static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            }
            catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
            }
        }
    }

    public static String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("\nInput cannot be empty.");
        }
    }

    public static String getTickerSymbol(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("\nTicker symbol cannot be empty.");
                continue;
            }

            if (input.length() >= 6) {
                System.out.println("\nInput is too long.");
                continue;
            }

            if (input.matches(".*\\d.*")) {
                System.out.println("\nTicker symbol cannot contain numbers.");
                continue;
            }

            return input;
        }
    }
}
