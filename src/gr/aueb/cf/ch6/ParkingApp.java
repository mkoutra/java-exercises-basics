package gr.aueb.cf.ch6;

import java.util.Arrays;

public class ParkingApp {

    public static void main(String[] args) {
        int[][] timestamps = {
                {1012, 1136},
                {1317, 1417},
                {1015, 1020}
        };

        int mostCars = mostCarsSimultaneously(timestamps);

        System.out.println("Most cars existed simultaneously: " + mostCars);
    }

    public static int mostCarsSimultaneously(int[][] arr) {
        int[][] parkingStatus;
        int maxCars = 0;
        int currentCars = 0;

        parkingStatus = getParkingStatus(arr);
        sortTwoDim(parkingStatus, 0);

        for (int[] parkingLog : parkingStatus) {
            if (parkingLog[1] == 1) {
                currentCars++;
            } else if (parkingLog[1] == 0 && currentCars > 0) {
                currentCars--;
            }

            if (maxCars < currentCars) {
                maxCars = currentCars;
            }
        }

        return maxCars;
    }


    /**
     * Converts an array of arrival and departure timestamps
     * into a parking status array.
     * The input array contains rows with two timestamps: the first
     * for arrival and the second for departure. The output is a
     * two-dimensional array where each row has a timestamp in
     * the first column and a status indicator in the second column:
     * 1 for arrival, 0 for departure.
     *
     * @param arr A two-dimensional array with each row containing
     *            arrival and departure timestamps.
     * @return A two-dimensional array where the first column is
     * a timestamp, and the second is 1 for arrival or
     * 0 for departure.
     */
    public static int[][] getParkingStatus(int[][] arr) {
        int[][] parkingStatus = new int[2 * arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            // Arrival
            parkingStatus[2 * i][0] = arr[i][0];
            parkingStatus[2 * i][1] = 1;

            // Departure
            parkingStatus[2 * i + 1][0] = arr[i][1];
            parkingStatus[2 * i + 1][1] = 0;
        }
        return parkingStatus;
    }


    /**
     * Sorts a two-dimensional array based on a specified column.
     * The method sorts the rows of the given two-dimensional array
     * in ascending order according to the values in the specified column.
     *
     * @param arr A two-dimensional array to be sorted.
     * @param col The column index to use for sorting.
     */
    public static void sortTwoDim(int[][] arr, int col) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[col], b[col]));
    }


    public static void printTwoDim(int[][] arr) {
        for (int[] row : arr) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%d ", row[j]);
            }
            System.out.println();
        }
    }
}
