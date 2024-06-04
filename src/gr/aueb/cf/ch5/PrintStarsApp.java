package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Prints stars in different shapes.
 *
 * @author Michalis Koutrakis
 */
public class PrintStarsApp {

    public static void main(String[] args) {
        int choice = -1;
        int errorCode = -1;
        int num = -1;

        while (true) {
            printMenu();
            choice = getInteger();

            errorCode = validate_choice(choice);

            if (errorCode == 1) {
                System.out.println("Quiting...");
                break;
            }

            if (errorCode == 2) {
                System.out.println("Invalid choice, please try again.");
                continue;
            }

            System.out.print("Give star number, n >> ");
            num = getInteger();

            if (isPositive(num)) {
                getPrintSchemeFromChoice(choice, num);
            } else {
                System.out.println("Invalid number, please try again.");
            }

        }

    }

    /**
     * Reads and returns an integer from stdin.
     *
     * @return  the integer given.
     */
    public static int getInteger() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * Prints the application's menu.
     */
    public static void printMenu() {
        System.out.println("1. Print n stars horizontally");
        System.out.println("2. Print n stars vertically");
        System.out.println("3. Print n lines with n stars");
        System.out.println("4. Print n lines with 1-n stars");
        System.out.println("5. Print n lines with n-1 stars");
        System.out.println("6. Exit");
        System.out.print("Please give an option >> ");
    }

    /**
     * Validates a choice and returns an error code.
     *
     * @param choice    The input value to be validated.
     * @return          The error code:
     *                  0 - Valid choice (1-5)
     *                  1 - Special condition (choice = 6)
     *                  2 - Invalid choice (all other values)
     */
    public static int validate_choice(int choice) {
        int errorCode = 2;

        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                errorCode = 0;
                break;
            case 6:
                errorCode = 1;
                break;
            default:
                errorCode = 2;
                break;
        }

        return errorCode;
    }

    /**
     * Checks if a number is positive.
     *
     * @param n The number to be checked.
     */
    public static boolean isPositive(int n) { return n > 0; }

    /**
     * Executes a print scheme based on a given choice and returns an error code.
     *
     * @param choice The chosen print scheme.
     * @param n      The parameter that defines the number of stars or lines.
     * @return       0 for valid choices, 2 for invalid choices.
     */
    public static int getPrintSchemeFromChoice(int choice, int n){
        int errorCode = 0;

        switch (choice) {
            case 1:
                printHorizontally(n);
                System.out.println();
                break;
            case 2:
                printVertically(n);
                break;
            case 3:
                printNLinesNstars(n);
                break;
            case 4:
                printNLinesOneToN(n);
                break;
            case 5:
                printNLinesNToOne(n);
                break;
            default:
                errorCode = 2;
                break;
        }
        return errorCode;
    }

    /**
     * Prints n stars horizontally (no new line in the end).
     *
     * @param n The number of stars to print horizontally.
     */
    public static void printHorizontally(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }

    /**
     * Prints n stars vertically.
     *
     * @param n the number of stars to print vertically.
     */
    public static void printVertically(int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println('*');
        }
    }

    /**
     * Prints n lines containing n stars.
     *
     * @param n the number of stars and lines.
     */
    public static void printNLinesNstars(int n) {
        for (int i = 0; i < n; i++) {
            printHorizontally(n);
            System.out.println();
        }
    }

    /**
     * Prints n lines with stars, where the first line contains
     * one star and each subsequent line contains one additional star.
     *
     * @param n the number of lines.
     */
    public static void printNLinesOneToN(int n) {
        for (int i = 0; i < n; i++) {
            printHorizontally(i + 1);
            System.out.println();
        }
    }

    /**
     * Prints n lines with stars, starting with n stars on the
     * first line, decreasing by one star each subsequent line.
     *
     * @param n the number of lines.
     */
    public static void printNLinesNToOne (int n) {
        for (int i = 0; i < n; i++) {
            printHorizontally(n - i);
            System.out.println();
        }
    }
}
