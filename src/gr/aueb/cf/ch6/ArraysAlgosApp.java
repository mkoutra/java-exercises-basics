package gr.aueb.cf.ch6;

public class ArraysAlgosApp {

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};
        int[] lowAndHigh = getLowAndHighIndexOf(arr, 78);
        System.out.printf("{%d, %d}\n",lowAndHigh[0], lowAndHigh[1]);
    }

    /**
     * Finds the lowest and highest indices of a given key
     * within a sorted array that may contain duplicate values.
     *
     * @param arr   A sorted input array.
     * @param key   The value to find in the array.
     * @return      A two-element array where the first element
     *              is the lowest index of the key, and the second
     *              element is the highest index of the key. If the
     *              key is not found, it returns {-1, -1}.
     */
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int pos = findIndex(arr, key);      // A position of a key

        int[] lowAndHighIndex = {pos, pos}; // array to return

        if (pos == -1) {
            return lowAndHighIndex;
        }

        // Scan backwards
        while (lowAndHighIndex[0] > 0 && arr[lowAndHighIndex[0] - 1] == key) {
            lowAndHighIndex[0]--;
        }

        // Scan forwards
        while (lowAndHighIndex[1] < arr.length - 1 && arr[lowAndHighIndex[1] + 1] == key) {
            lowAndHighIndex[1]++;
        }

        return lowAndHighIndex;
    }

    /**
     * Find the position of a key value in a sorted array
     * using binary search.
     *
     * @param arr   input array
     * @param key   the value looking for
     * @return      the position of the key, otherwise -1.
     */
    public static int findIndex(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int middle = -1;
        boolean found = false;

        while (left <= right) {
            middle = (left + right) / 2;

            if (arr[middle] == key) {
                found = true;
                break;
            }
            else if (arr[middle] > key) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }

        return found ? middle : -1;
    }
}
