package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Takes three integers as input and returns the
 * corresponding date in DD/MM/YY format.
 *
 * @author Michalis Koutrakis
 */
public class DatePrint {

    public static void main(String[] args) {
        int day = -1;
        int month = -1;
        int year = -1;
        Scanner in = new Scanner(System.in);

        System.out.println("Give date in integers: ");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();

        System.out.printf("%02d/%02d/%2d\n", day, month, year % 100);
    }
}
