package gr.aueb.cf.ch4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ask user for an integer n and
 * prints n stars vertically.
 *
 * @author Michalis Koutrakis
 */
public class VerticalStars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Insert an integer n: ");
        int n = in.nextInt();

        for (int i = 0; i < n; ++i) {
            System.out.println('*');
        }
    }
}