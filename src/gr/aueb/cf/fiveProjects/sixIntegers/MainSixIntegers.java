package gr.aueb.cf.fiveProjects.sixIntegers;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * Reads integers from a file, sorts them, takes all possible combinations
 * with 6 elements which pass certain filters,
 * and writes the valid combinations to a file.
 *
 * @author Michalis Koutrakis
 */
public class MainSixIntegers {

    public static void main(String[] args) {
        project1();
    }

    /**
     * Executes the project tasks:
     * 1. Reads integers from an input file.
     * 2. Validates the read integers.
     * 3. Sorts the integers.
     * 4. Generates all possible combinations of a
     *    specified size that pass certain filters.
     * 5. Writes the valid combinations to an output file.
     */
    private static void project1() {
        final int COMBINATIONS_SIZE = 6;
        int[] numbers;
        List<int[]> combinations;

        try {
            numbers = FileOperations.readNumbers("integers.txt");

            if (!validateNumbers(numbers)) {
                System.err.println("The numbers inside the input file are not valid.");
                return;
            }

            Arrays.sort(numbers);

            combinations = Combinations.getFilteredCombinations(numbers, COMBINATIONS_SIZE);

            FileOperations.writeCombinations(combinations, "combinations.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates an array of integers based on specific criteria.
     * 1. The length of the array must be between 6 and 49, inclusive.
     * 2. Each integer in the array must be between 1 and 49, inclusive.
     *
     * @param numbers   An input array of integers to validate.
     * @return          True if the array meets both criteria; false otherwise.
     */
    private static boolean validateNumbers(int[] numbers) {
        if (numbers.length < 6 || numbers.length > 49) return false;

        for (int num : numbers) {
            if (num > 49 || num < 1) return false;
        }

        return true;
    }
}
