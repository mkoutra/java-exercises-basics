package gr.aueb.cf.fiveProjects.sixIntegers;

/**
 * A class of filtering methods to be used in {@link Combinations}.
 *
 * @author Michalis Koutrakis
 */
public class Filters {
    private Filters() {
    }

    /**
     * Checks if the given array contains at most four even numbers.
     *
     * @param arr
     *      The array to be checked.
     * @return
     *      True if the array contains four or fewer
     *      even numbers, false otherwise.
     */
    public static boolean hasAtMostFourEvens(int[] arr) {
        if (arr == null) return false;
        int evenCounter = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCounter++;
            }
            if (evenCounter > 4) break;
        }

        return evenCounter <= 4;
    }

    /**
     * Checks if the given array contains at most four odd numbers.
     *
     * @param arr
     *      The array to be checked.
     * @return
     *      True if the array contains four or fewer
     *      odd numbers, false otherwise.
     */
    public static boolean hasAtMostFourOdds(int[] arr) {
        if (arr == null) return false;
        int oddCounter = 0;

        for (int num : arr) {
            if (num % 2 == 1) {
                oddCounter++;
            }
            if (oddCounter > 4) break;
        }

        return oddCounter <= 4;
    }

    /**
     * Checks if the given array contains at most two consecutive numbers.

     * @param arr
     *      The array to be checked.
     * @return
     *      True if the array contains at most two consecutive numbers, false otherwise.
     */
    public static boolean hasAtMostTwoConsecutive(int[] arr) {
        if (arr == null) return false;
        boolean atMostTwoConsequtives = true;

        for (int i = 0; i < arr.length - 2; ++i) {
            if ((arr[i + 1] - arr[i]) == 1 && (arr[i + 2] - arr[i + 1]) == 1) {
                atMostTwoConsequtives = false;
                break;
            }
        }
        return atMostTwoConsequtives;
    }

    /**
     * Checks if the given array contains at most
     * three numbers with the same last digit.
     *
     * @param arr
     *      The array of integers to be checked.
     * @return
     *      True if at most three numbers have the same last digit, false otherwise.
     */
    public static boolean hasAtMostThreeWithSameEnding(int[] arr) {
        if (arr == null) return false;
        boolean lessThanThreeWithSameEnding = true;
        int[] endings = new int[10];

        for (int num : arr) {
            endings[num % 10]++;

            if (endings[num % 10] > 3) {
                lessThanThreeWithSameEnding = false;
                break;
            }
        }

        return lessThanThreeWithSameEnding;
    }

    /**
     * Checks if the given array contains at most three numbers in the same ten-range.
     *
     * @param arr
     *      The array of integers to be checked.
     * @return
     *      True if at most three numbers fall into the same ten-range, false otherwise.
     */
    public static boolean hasAtMostThreeSameTenRange(int[] arr) {
        if (arr == null) return false;
        boolean lessThanThreeSameTenRange = true;
        int[] tenRanges = new int[10];

        for (int num : arr) {
            if (Math.abs(num) >= 100) return false;

            tenRanges[Math.abs(num) / 10]++;

            if (tenRanges[Math.abs(num) / 10] > 3) {
                lessThanThreeSameTenRange = false;
                break;
            }
        }

        return lessThanThreeSameTenRange;
    }
}
