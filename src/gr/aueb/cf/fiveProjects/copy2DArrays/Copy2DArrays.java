package gr.aueb.cf.fiveProjects.copy2DArrays;

/**
 * Shallow and deep copy of an 2D array.
 *
 * @author Michalis Koutrakis
 */
public class Copy2DArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {1, 1, 1}};
        int[][] shallowArray = shallowCopy(arr);
        int[][] deepArray = deepCopy(arr);
        System.out.println("Initial array:");
        print2DArray(arr);

        System.out.println("*** Shallow Copy ***");
        System.out.println("Modify element only on initial array");
        arr[2][2] = 123;
        System.out.println("--- Initial ---");
        print2DArray(arr);
        System.out.println("--- Copy ---");
        print2DArray(shallowArray);

        arr[2][2] = 1;  // Bring back to initial state

        System.out.println("*** Deep Copy ***");
        System.out.println("Modify element only on initial array");
        arr[1][1] = 555;
        System.out.println("--- Initial ---");
        print2DArray(arr);
        System.out.println("--- Copy ---");
        print2DArray(deepArray);
    }

    /**
     * Returns a shallow copy of the 2D input array.
     *
     * @param arr   2D input array
     * @return      2D array, shallow copy of the input array
     */
    public static int[][] shallowCopy(int[][] arr) {
        int[][] copiedArray = new int[arr.length][];
        for(int i = 0 ; i < arr.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }

    /**
     * Returns a deep copy of the 2D input array.
     *
     * @param arr   2D input array
     * @return      2D array, deep copy of the input array
     */
    public static int[][] deepCopy(int[][] arr) {
        int[][] copiedArray = new int[arr.length][];
        for(int i = 0 ; i < arr.length; i++) {
            int[] tmp = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                tmp[j] = arr[i][j];
            }
            copiedArray[i] = tmp;
        }
        return copiedArray;
    }

    private static void print2DArray(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
