package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Asks user for an integer n and prints
 * n to 1 stars in n different lines.
 *
 * @author Michalis Koutrakis
 */
public class NToOneStars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n + 1 - i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}