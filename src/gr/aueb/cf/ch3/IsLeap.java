package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Asks user for a year and checks if it is a leap year.
 *
 * @author Michalis Koutrakis
 */
public class IsLeap {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int year = -1;
        boolean isleap = false;

        // Take input from user
        while (true) {
            System.out.println("Please enter a year to check if it's a leap year: ");
            year = in.nextInt();

            // Validate input
            if (year > 0) break;
            System.out.println("Error: Year must be a positive integer.");
        }

        // Check conditions for leap year
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            isleap = true;
        }

        if (isleap) {
            System.out.printf("Year: %d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }
}
