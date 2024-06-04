package gr.aueb.cf.ch8;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {

    public static void main(String[] args) {
        int num = 153;

        System.out.println(num + " is " + isArmstrong(num));
        System.out.println(num + " is " + isArmstrongSol(num));
    }

    /**
     * Checks if a number is Armstrong number.
     * @param num   input number to check
     * @return      true if the input number is an Armstrong
     *              number, otherwise false
     */
    public static boolean isArmstrong(int num) {
        String s = Integer.toString(num);
        int size = s.length();
        int digit = 0;
        int sum = 0;

        for(int i = 0; i < size; i++) {
            digit = Integer.parseInt(s.substring(i, i + 1));
            sum += (int) Math.pow(digit, size);
        }

        return sum == num;
    }

    /**
     * The solution given for Armstrong number.
     */
    public static boolean isArmstrongSol(int inputNumber) {
        final List<Integer> digits = new ArrayList<>();
        int num = inputNumber;
        int digitsCount = 0;
        int sum = 0;

        // Find the digits count
        do {
            digitsCount++;
            digits.add(num % 10);
            num /= 10;
        } while(num != 0);

        // Find the sum
        for (int item: digits) {
            sum += (int) Math.pow(item, digitsCount);
        }

        return sum == inputNumber;
    }
}
