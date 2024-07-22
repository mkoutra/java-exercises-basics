package gr.aueb.cf.fiveProjects.maximumSumSubArray;

/**
 * Find the sub-array with the maximum sum.
 *
 * @author Michalis Koutrakis
 */
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = numbers[0];
        int maxSum = numbers[0];
        int subArrayStart = 0;
        int subArrayFinish = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (sum + numbers[i] > numbers[i]) {
                sum = sum + numbers[i];
            } else {
                sum = numbers[i];
                subArrayStart = i;
            }
            if (sum >= maxSum) {
                maxSum = sum;
                subArrayFinish = i;
            }
        }

        System.out.println("Max sum: " +maxSum);
        printSubArray(numbers, subArrayStart, subArrayFinish);
    }

    public static void printSubArray(int[] arr, int start, int finish) {
        System.out.print('[');
        for (int i = start; i <=finish; i++) {
            System.out.print(arr[i]);
            if (i != finish) System.out.print(", ");
        }
        System.out.println(']');
    }
}
