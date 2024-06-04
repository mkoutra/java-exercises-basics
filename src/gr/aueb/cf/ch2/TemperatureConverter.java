package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Converts Fahrenheit to Celsius.
 *
 * @author Michalis Koutrakis
 */
public class TemperatureConverter {
    
    public static void main(String[] args) {
        int fahr = 0;
        int celc = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter temperature in °F: ");
        fahr = in.nextInt();

        celc = 5 * (fahr - 32) / 9;

        System.out.printf("%d °F = %d °C\n", fahr, celc);
    }
}
