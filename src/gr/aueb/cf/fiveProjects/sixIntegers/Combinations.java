package gr.aueb.cf.fiveProjects.sixIntegers;

import java.util.ArrayList;
import java.util.List;

/**
 * A class providing methods used to derive combinations of
 * m numbers from a given array of integers.
 *
 * @author Michalis Koutrakis
 */
public class Combinations {

    private Combinations() {
    }

    /**
     * Generates all valid combinations of length {@code m}
     * from an array of numbers, applying specific filters.
     *
     * @param numbers   The input array of numbers.
     * @param m         The number of elements in each combination.
     * @return          An ArrayList containing all the combinations.
     */
    public static List<int[]> getFilteredCombinations(final int[] numbers, int m) {
        List<int[]> allCombinations = new ArrayList<>();
        int[] tmpArr = new int[m];
        int tmpArrSize = 0;

        filteredCombinations(0, numbers.length - m,
                numbers, allCombinations, tmpArr, tmpArrSize);

        return allCombinations;
    }

    /**
     * Generates combinations of numbers with specific filtering criteria.
     *
     * @param startIndex
     *          The starting index in the input array for generating combinations.
     * @param endIndex
     *          The ending index in the input array for generating combinations.
     * @param numbers
     *          The input array of numbers from which combinations are generated.
     * @param allCombinations
     *          The list that stores all generated combinations.
     * @param tmpArr
     *          Temporary array to store the current combination being generated.
     * @param tmpArrSize
     *          The current size of the temporary array (number of elements filled).
     */
    private static void filteredCombinations(int startIndex, int endIndex,
                                             final int[] numbers, List<int[]> allCombinations,
                                             int[] tmpArr, int tmpArrSize) {
        if (tmpArrSize == tmpArr.length) {
            if (Filters.hasAtMostFourEvens(tmpArr) &&
                Filters.hasAtMostFourOdds(tmpArr) &&
                Filters.hasAtMostTwoConsecutive(tmpArr) &&
                Filters.hasAtMostThreeWithSameEnding(tmpArr) &&
                Filters.hasAtMostThreeSameTenRange(tmpArr)) {
                    allCombinations.add(tmpArr.clone());
            }
            return;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            tmpArr[tmpArrSize] = numbers[i];
            filteredCombinations(i + 1, endIndex + 1, numbers,
                    allCombinations, tmpArr, tmpArrSize + 1);
        }
    }


    /**
     * Returns an ArrayList of all the combinations
     * of {@code m} numbers inside {@code numbers}.
     *
     * @param numbers   The input array of numbers.
     * @param m         The number of elements in each combination.
     * @return          An ArrayList containing all the combinations.
     */
    public static List<int[]> getCombinations(final int[] numbers, int m) {
        List<int[]> allCombinations = new ArrayList<>();
        int[] tmpArr = new int[m];
        int tmpArrSize = 0;

        combinations(0, numbers.length - m,
                numbers, allCombinations, tmpArr, tmpArrSize);

        return allCombinations;
    }

    /**
     * Recursively generates all combinations of a
     * specified length from the input array.
     *
     * @param startIndex
     *          The starting index in the input array for generating combinations.
     * @param endIndex
     *          The ending index in the input array for generating combinations.
     * @param numbers
     *          The input array of numbers from which combinations are generated.
     * @param allCombinations
     *          The list that stores all generated combinations.
     * @param tmpArr
     *          Temporary array to store the current combination being generated.
     * @param tmpArrSize
     *          The current size of the temporary array (number of elements filled).
     */
    private static void combinations(int startIndex, int endIndex,
                                     final int[] numbers, List<int[]> allCombinations,
                                    int[] tmpArr, int tmpArrSize) {
        if (tmpArrSize == tmpArr.length) {
            allCombinations.add(tmpArr.clone());
            return;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            tmpArr[tmpArrSize] = numbers[i];
            combinations(i + 1, endIndex + 1, numbers,
                        allCombinations, tmpArr, tmpArrSize + 1);
        }
    }

    public static void printArray(int[] arr) {
        System.out.print('[');
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println(']');
    }

    public static void printCombinations(List<int[]> a) {
        for(int[] i : a) printArray(i);
    }
}
