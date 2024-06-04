package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Ask user for an integer n,
 * and creates a square made of stars.
 *
 * @author Michalis Koutrakis
 */
public class SquareStars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert an integer n: ");
        int n = in.nextInt();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
