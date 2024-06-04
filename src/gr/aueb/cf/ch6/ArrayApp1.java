package gr.aueb.cf.ch6;

/**
 * Exercise 1
 * - getMaxPosition:
 *          Returns the position of the
 *          largest element in an array.
 * - getSecondSmallestElement:
 *          Returns the second-smallest element
 *          of an array.
 *
 * @author Michalis Koutrakis
 */
public class ArrayApp1 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 2};
        int low = 0;
        int high = arr.length - 1;
        int maxPosition = getMaxPosition(arr, low, high);
        int secondSmallest = getSecondSmallestElement(arr, low, high);

        System.out.println("Max element position: " + maxPosition + " --> " + arr[maxPosition]);
        System.out.println("Second-smallest element: " + secondSmallest);
    }

    /**
     * Returns the position of the largest element
     * in a specified range of an array.
     *
     * @param arr   The array to examine.
     * @param low   The starting position (inclusive).
     * @param high  The ending position (inclusive).
     * @return      The position of the largest element,
     *              or -1 if the range is invalid.
     */
    public static int getMaxPosition(int[] arr, int low, int high) {
        int maxIndex;

        if (arr == null || low <0 || high >= arr.length || low > high) {
            maxIndex = -1;
        } else {
            maxIndex = low;

            for (int i = low + 1; i <= high; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
        }

        return maxIndex;
    }

    /**
     * Returns the second-smallest
     * element of a given array.
     * @param arr   The array to examine.
     * @param low   The starting position (inclusive).
     * @param high  The ending position (inclusive).
     * @return      The second-smallest element,
     *              or Integer.MAX_VALUE if the range is invalid.
     */
    public static int getSecondSmallestElement(int[] arr, int low, int high) {
        int min;
        int secondSmallest;

        if (arr == null || low < 0 || high >= arr.length || low > high) {
            secondSmallest = Integer.MAX_VALUE;
        } else {
            min = arr[low];
            secondSmallest = Integer.MAX_VALUE;

            for (int i = low ; i <= high; i++) {
                if (arr[i] < min) {
                    secondSmallest = min;
                    min = arr[i];
                }
                else if (arr[i] > min && arr[i] < secondSmallest) {
                    secondSmallest = arr[i];
                }
            }
        }

        return secondSmallest;
    }
}
