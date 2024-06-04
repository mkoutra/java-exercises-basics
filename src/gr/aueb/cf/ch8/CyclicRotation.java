package gr.aueb.cf.ch8;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int shift = 2;
        int[] arr = {1, 2, 3, 4, 5};
        int[] shiftedArr = doCircularShiftBy(arr, 1);
        for (int i = 0; i < arr.length; ++i) {
            System.out.printf("%d, ", shiftedArr[i]);
        }
    }

    public static int[] doCircularShiftBy(int[] arr, int n) {
        int size = arr.length;
        int[] shiftedArr = new int[size];

        for (int i = 0; i < size; i++) {
            shiftedArr[(i + n) % size] = arr[i];
        }

        return shiftedArr;
    }
}
