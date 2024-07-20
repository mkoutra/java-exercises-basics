package gr.aueb.cf.fiveProjects.sixIntegers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class of file operations to be used in {@link MainSixIntegers}.
 */
public class FileOperations {
    private FileOperations() {
    }

    /**
     * Returns the integers which are inside a file with name
     * {@code inputFileName} inside the resources/ directory. The integers
     * are supposed to be whitespace separated.
     *
     * @param inputFileName
     *      The name of the file containing the integers.
     *      It must be inside the resources/ directory.
     * @return
     *      An array int with the numbers found.
     * @throws FileNotFoundException
     *      If the input file does not exist.
     */
    public static int[] readNumbers(String inputFileName)
            throws FileNotFoundException {
        File inFile = new File("./resources/" + inputFileName);
        List<Integer> numbersArrayList = new ArrayList<>();
        int[] numbers;

        try (Scanner in = new Scanner(inFile)) {
            while(in.hasNextInt()) {
                numbersArrayList.add(in.nextInt());
            }

            numbers = new int [numbersArrayList.size()];
            for (int i = 0; i< numbersArrayList.size(); i++) {
                numbers[i] = numbersArrayList.get(i);
            }
            return numbers;
        } catch (FileNotFoundException e) {
            System.out.println("The input file was not found.");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Writes the combinations given, in the output
     * file specified by {@code outputFileName}. The {@code outputFileName}
     * will be placed inside the resources/ directory.
     *
     * @param combinations
     *      An ArrayList containing the different combinations.
     * @param outputFileName
     *      The name of the file to write the combinations.
     * @throws FileNotFoundException
     *      If the output file cannot be found.
     */
    public static void writeCombinations(List<int[]> combinations, String outputFileName)
            throws FileNotFoundException {
        File outFile = new File("./resources/" + outputFileName);

        try (PrintWriter pw = new PrintWriter(outFile)) {
            for (int[] a : combinations) {
                writeArray(a, pw);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Output file was not found.");
            e.printStackTrace();
        }
    }

    /**
     * Writes an array of integers {@code arr} in a {@link PrintWriter}.
     * @param arr   The input Array
     * @param pw    The Output stream
     */
    private static void writeArray(int[] arr, PrintWriter pw) {
        pw.print('[');
        for (int i = 0; i < arr.length; ++i) {
            pw.print(arr[i]);
            if (i < arr.length - 1) pw.print(", ");
        }
        pw.println(']');
    }

}
