package gr.aueb.cf.ch6;
/**
 * Exercise 2
 * - lookUp:
 *          Returns the position of a given element
 *          in an array, or -1 if not found.
 * - printEvenElements:
 *          Prints the even numbers from the given array.
 * - getDoubleValue:
 *          Returns an array with each element
 *          being twice the corresponding element in the original array.
 * - existPositive:
 *          Checks if an array contains any positive numbers.
 * - areAllPositive:
 *          Checks if all elements in an array are positive.
 *
 * @author Michalis Koutrakis
 */
public class ArrayApp2 {

    public static void main(String[] args) {
        /* Testing */
//        int[] arr = {1, 4, 6, 8, 100, 2};
//        int elem = 100;
//        int lookUpPosition = lookUp(arr, elem);
//        System.out.println(elem + " in position --> " + lookUpPosition);
//
//        printEvenElements(arr);
//
//        int[] q3 = getDoubleValue(arr);
//        printArray(arr);
//        printArray(q3);
//
//        int[] arr2 = {-3, -2, 100};
//        System.out.println(existPositive(arr));
//        System.out.println(existPositive(arr2));
//
//        System.out.println(areAllPositive(arr));
//        System.out.println(areAllPositive(arr2));
    }

    /**
     * Prints the elements of an array, separated by spaces,
     * followed by a newline.
     *
     * @param arr The array to print.
     */
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.printf("%d ", i);
        System.out.println();
    }

    /**
     * Returns the position of an element inside an array.
     * If the element does not exist, returns -1.
     *
     * @param arr   the array to examine.
     * @param elem  the element to look for.
     * @return      the position of the element,
     *              otherwise -1.
     */
    public static int lookUp(int[] arr, int elem) {
        int position = -1;

        if (arr != null) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == elem) {
                    position = i;
                    break;
                }
            }
        }
        return position;
    }

    /**
     * Prints the even elements of the given array.
     *
     * @param arr   The array to examine.
     */
    public static void printEvenElements(int[] arr) {
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }

    /**
     * Returns an array with each element being double
     * the corresponding element in the given array.
     *
     * @param arr   The array to double.
     * @return      An array where each element is twice
     *              the value of the corresponding element
     *              in the given array.
     */
    public static int[] getDoubleValue(int[] arr) {
        int[] doubleArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            doubleArray[i] = 2 * arr[i];
        }
        return doubleArray;
    }

    /**
     * Checks if a given array contains any positive numbers.
     *
     * @param arr   The array to scan.
     * @return      True if the array contains at
     *              least one positive number,
     *              otherwise, false.
     */
    public static boolean existPositive(int[] arr) {
       boolean isPositive = false;

       for (int i : arr) {
           if (i > 0) {
               isPositive = true;
               break;
           }
       }

       return isPositive;
    }

    /**
     * Checks whether all elements of an array are positive.
     *
     * @param arr   The array to examine.
     * @return      True if all elements are positive,
     *              otherwise, false.
     */
    public static boolean areAllPositive(int[] arr) {
        boolean allPositive = true;

        for (int i : arr) {
            if (i < 0) {
                allPositive = false;
                break;
            }
        }

        return allPositive;
    }
}
