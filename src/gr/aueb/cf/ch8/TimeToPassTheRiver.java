package gr.aueb.cf.ch8;

public class TimeToPassTheRiver {

    public static void main(String[] args) {
        int y = 6;
        int[] T = {1, 1, 2, 2, 4, 3, 1};
        int min = minTimeToPassTheRiver(T, y);
        System.out.println("min = " + min);
    }

    public static int minTimeToPassTheRiver(int[] arr, int y) {
        int min = -1;
        int[] leavesPositions = new int[y];

        for (int i = 0; i < arr.length; ++i) {
            leavesPositions[arr[i] - 1] = 1;

            if (isFull(leavesPositions)) {
                min = i;
                break;
            }
        }

        return min;
    }

    /**
     * Checks if all the values of the input array are nonzero.
     * @param arr   input array
     * @return      true if all elements are nonzero.
     */
    public static boolean isFull(int[] arr) {
        for (int i : arr) {
            if (i == 0) return false;
        }
        return true;
    }

    /**
     * Solution
     */
    public static int minTimeToPassTheRiverSol(int[] arr, int y) {
        int[] helperArray = new int[y + 1];
        int remainingSteps = y;
        int time = -1;

        for (int i = 0; i < arr.length; i++) {
            // If the leave has not set (0), set it (1) at
            // the helper array. The index of helper array is
            // the position where the leave falls.
            if (helperArray[arr[i]] == 0) {
                helperArray[arr[i]] = 1;
                remainingSteps--;
            } else continue;

            if (remainingSteps == 0) {
                time = i;
                break;
            }
        }

        return time;
    }
}
