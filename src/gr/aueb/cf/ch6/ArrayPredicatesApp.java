package gr.aueb.cf.ch6;

import java.util.Arrays;

/**
 * Asks the user for six integers, each between 1 and 49,
 * and performs the following five validation checks:
 * 1. Verifies that there are no more than three even numbers.
 * 2. Verifies that there are no more than three odd numbers.
 * 3. Ensures that there are no more than three consecutive numbers.
 * 4. Confirms that there are no more than three numbers with the same last digit.
 * 5. Checks that there are no more than three numbers within the same range of tens.
 */
public class ArrayPredicatesApp {

    public static void main(String[] args) {

    }

    /**
     * Checks if there are less than 3 even numbers in
     * the array given.
     * @param arr   input array
     * @return      true if there are less than 3 even, otherwise false.
     */
    public static boolean lessThanThreeEven(int[] arr) {
        int count = 0;
        for(int num : arr) {
            if (num % 2 == 0) count++;
        }
        return count < 3;
    }

    /**
     * Checks if there are less than 3 odd numbers in
     * the given array.
     * @param arr   input array
     * @return      true if there are less than 3 even, otherwise false.
     */
    public static boolean lessThanThreeOdd(int[] arr) {
        int count = 0;
        for(int num : arr) {
            if (num % 2 == 1) count++;
        }
        return count < 3;
    }

    /**
     * Ensures that there are no more than three consecutive numbers.
     * @param arr   input array
     * @return      true if there are less than 3 consecutive numbers,
     *              otherwise false.
     */
    public static boolean lessThanThreeConsecutive(int[] arr) {
        if (arr == null || arr.length < 4) return true;

        boolean fourConseqFound = false;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 3; ++i) {
            if((arr[i] == (arr[i] - 1))
                    && (arr[i] == (arr[i + 2] - 2))
                    && (arr[i] == (arr[i + 3] - 3))) {
                fourConseqFound = true;
                break;
            }
        }

        return !fourConseqFound;
    }

    /**
     * Confirms that there are no more than three
     * numbers with the same last digit.
     *
     * @param arr   input array
     * @return      true if there are less than 3 numbers with same ending,
     *              otherwise false.
     */
    public static boolean lessThanThreeSameEnding(int[] arr) {
        boolean lessThanThreeSame = true;
        int[] endings = new int[arr.length];

        for (int num : arr) {
            endings[num % 10]++;
        }

        for (int nEndings : endings) {
            if (nEndings > 3) {
                lessThanThreeSame = false;
                break;
            }
        }

        return lessThanThreeSame;
    }

    /**
     * Checks that there are no more than three
     * numbers within the same range of tens.
     *
     * @param arr           input array
     * @param maxNumber     maximum number in the input array
     * @return              true if there are less than three in the same range,
     *                      otherwise false.
     */
    public static boolean lessThanThreeSameTenRange(int[] arr, int maxNumber) {
        int[] tenRanges = new int[maxNumber % 10 + 1];
        boolean threeInSameTenRange = false;
        for (int num : arr) {
            tenRanges[num/10]++;
        }

        for (int num : tenRanges) {
            if (num > 3) {
                threeInSameTenRange = true;
                break;
            }
        }

        return !threeInSameTenRange;
    }

}
